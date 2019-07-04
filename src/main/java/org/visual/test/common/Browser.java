package org.visual.test.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Browser {

    private WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;

    public void launchBrowser(String url) {


        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chrome/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-plugins");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--lang=en");

        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
        driver.manage().window().maximize();

        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);


    }

    public void scrollDownUp(boolean direction){

        if(direction){
            this.js.executeScript("window.scrollBy(0,200)"); //Scroll vertically down by 1000 pixels
        }else{

        }

    }



    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] takeScreenShot(){
        return ((TakesScreenshot) this.driver)
                .getScreenshotAs(OutputType.BYTES);
    }

}
