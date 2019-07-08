package org.visualtest.runner;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.visualtest.common.Browser;
import org.visualtest.common.Constants;
import org.visualtest.steps.GeneralSteps;

public class TestRunner {

    Browser browser;
    GeneralSteps generalSteps;

    @Parameters({"url"})
    @Test(description = "Single test", priority = 1)
    public void initialTest(@Optional("null") String url){
        this.browser = new Browser();
        this.browser.launchBrowser(url, Constants.getInstance().getPageWidth(), Constants.getInstance().getPageHeight());
    }

    @Test(description = "Checking Home Page", priority = 2, dependsOnMethods = {"initialTest"})
    public void checkHomePage(){

        boolean result;

        this.generalSteps = new GeneralSteps(this.browser);

        result = generalSteps.findImage("logo.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Logo was not found");

        result = generalSteps.findImage("home_services.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Services section was not found");

        result = generalSteps.findImage("home_work.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Work section was not found");

        result = generalSteps.findImage("home_network.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Network section was not found");

        result = generalSteps.findImage("home_contact.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Contact section was not found");

        result = generalSteps.findImage("home_header.jpg", Constants.getInstance().GREEN);
        Assert.assertEquals(true, result, "Header section was not found");

        int pageHeight = this.browser.getPageHeight();
        int scrolls = this.browser.calculateScrollTries(pageHeight);

        result = generalSteps.findImage("home_mid_menu.jpg", Constants.getInstance().GREEN, scrolls);
        Assert.assertEquals(true, result, "Mid Menu section was not found");
    }

    @Test(description = "Checking Services Page", priority = 2, dependsOnMethods = {"checkHomePage"})
    public void checkServicesSection(){

        browser.scrollTo(0, 0);
        boolean result = generalSteps.findClickImage("home_services_text.jpg", Constants.getInstance().BLUE);
        Assert.assertEquals(true, result, "Services section was not found");

        result = generalSteps.findAndMove("content_factory.jpg", Constants.getInstance().BLUE);
        Assert.assertEquals(true, result, "Content Factory was not found");

        result = generalSteps.findAndMove("content_global.jpg", Constants.getInstance().BLUE);
        Assert.assertEquals(true, result, "Content Global was not found");


    }

    @AfterSuite
    public void tearDown(){
        browser.closeBrowser();
    }

}
