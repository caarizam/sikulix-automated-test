package org.visualtest.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Browser {

    private WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;
    final int SCROLL_SIZE = 300;
    public final boolean DOWN = false;
    public final boolean UP = true;

    public void launchBrowser(String url, int width, int height) {


        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chrome/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-plugins");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--lang=en");

        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(width, height));
        driver.manage().window().setPosition(new Point(0, 0));

        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);


    }

    public void scrollDownUp(boolean direction){
        try{
            if(direction == this.DOWN){
                this.js.executeScript("window.scrollBy(0,200);");
            }else{
                this.js.executeScript("window.scrollBy(0,-200);");
            }
        }catch (Exception ex){}
    }

    public void scrollTo(int pointX, int pointY){
        try{
            this.js.executeScript("window.scrollTo(" + pointX + "," + pointY + ");");
        }catch (Exception ex){}
    }

    public int getPageHeight(){
        try{
            Object valuePageHeigh = this.js.executeScript("var body = document.body,\n" +
                    "    html = document.documentElement; return Math.max( body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight );");
            int pageHeight = Integer.parseInt(valuePageHeigh.toString());
            System.out.println("valueSize: " + pageHeight);

            return pageHeight;
        }catch (Exception ex){
            return 0;
        }
    }

    public int calculateScrollTries(int pageHeigh){

        int scrolls = (pageHeigh / this.SCROLL_SIZE);
        return scrolls;

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
