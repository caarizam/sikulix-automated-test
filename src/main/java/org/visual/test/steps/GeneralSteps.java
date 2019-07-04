package org.visual.test.steps;

import org.sikuli.script.*;
import org.visual.test.common.Browser;
import org.visual.test.common.CommonMethods;

public class GeneralSteps {

    private Screen screen;
    private String path;

    CommonMethods common;
    Browser browser;

    public GeneralSteps(Browser browser){
        this.browser = browser;
        screen = new Screen();
        common = new CommonMethods();
        path = System.getProperty("user.dir") + "/src/test/resources/images/";
    }

    public void singleTest(){

        try{
            screen.find(path + "notrobot.jpg").highlight(2);
            screen.find(path + "check_box.jpg").click();
        }catch (Exception ex){
            System.out.println("error on single test : " + ex.getMessage());
        }

    }

    public void checkImage(String imageName, String colorName, boolean expected){

        try{
            screen.find(path + imageName).highlight(1, colorName);
            common.delaySec(1);
        }catch (Exception ex){
            System.out.println("Exception ex : " + ex.getMessage());
        }

    }

    public void searchAndCheck(String imageName, String colorName, boolean expected){

        int tries = 3;
        boolean found = false;

        while(tries < 0 || found == true){
            try{
                screen.find(path + imageName).highlight(1, colorName);
                common.delaySec(1);
                found = true;
            }catch (Exception ex){
                System.out.println("Exception ex : " + ex.getMessage());
            }
        }

    }

}
