package org.visual.test.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.visual.test.common.Browser;
import org.visual.test.steps.GeneralSteps;

public class TestRunner {

    Browser browser;
    GeneralSteps generalSteps;

    @Parameters({"url"})
    @Test(description = "Single test", priority = 1)
    public void initialTest(@Optional("null") String url){
        this.browser = new Browser();
        this.browser.launchBrowser(url);
    }

    @Test(description = "Checking Home Page", priority = 2, dependsOnMethods = {"initialTest"})
    public void checkHomePage(){

        this.generalSteps = new GeneralSteps(this.browser);

        generalSteps.checkImage("logo.jpg", "green", true);
        generalSteps.checkImage("home_services.jpg", "green", true);
        generalSteps.checkImage("home_work.jpg", "green", true);
        generalSteps.checkImage("home_network.jpg", "green", true);
        generalSteps.checkImage("home_contact.jpg", "green", true);
        generalSteps.checkImage("home_header.jpg", "green", true);

        generalSteps.checkImage("home_mid_menu.jpg", "green", true);
    }

    @AfterSuite
    public void tearDown(){
        browser.closeBrowser();
    }

}
