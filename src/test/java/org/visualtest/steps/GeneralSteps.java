package org.visualtest.steps;

import org.sikuli.script.*;
import org.visualtest.common.Browser;
import org.visualtest.common.CommonMethods;
import org.visualtest.common.Constants;

public class GeneralSteps {

    private Screen screen;
    private String path;

    CommonMethods common;
    Browser browser;

    public GeneralSteps(Browser browser){
        this.browser = browser;
        screen = new Screen();
        screen.setAutoWaitTimeout(Constants.getInstance().getDefaultWaitTimeout());
        common = new CommonMethods();
        path = System.getProperty("user.dir") + "/src/test/resources/images/";
    }

    /**
     * This method allows finding an image and scrolls the page
     * @param imageName
     * @param colorName
     * @param scrolls
     * @return
     */
    public boolean findImage(String imageName, String colorName, int scrolls){

        boolean found = false;

        while(scrolls > 0 || found == false){
            try{
                screen.find(path + imageName).highlight(1, colorName);
                common.delaySec(1);
                found = true;
                return true;
            }catch (Exception ex){

            }
            this.browser.scrollDownUp(this.browser.DOWN);
            scrolls--;
        }
        return false;
    }

    /**
     * This method allows finding an image
     * @param imageName
     * @param colorName
     * @return
     */
    public boolean findImage(String imageName, String colorName){

        try{
            Pattern imagePattern = new Pattern(path + imageName).similar((float)0.9);
            screen.find(imagePattern).highlight(1, colorName);
            common.delaySec(1);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    /**
     * This method allows finding an image and performs a click on it
     * @param imageName
     * @param colorName
     * @return
     */
    public boolean findClickImage(String imageName, String colorName){

        try{
            Pattern imagePattern = new Pattern(path + imageName).similar((float)0.9);
            screen.find(imagePattern).highlight(2, colorName);
            screen.find(imagePattern).click();
            common.delaySec(2);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    /**
     * This method allows finding an image and performs the hover mouse action on it
     * @param imageName
     * @param colorName
     * @return
     */
    public boolean findAndMove(String imageName, String colorName){

        try{
            Pattern imagePattern = new Pattern(path + imageName).similar((float)0.9);
            screen.find(imagePattern).highlight(2, colorName);
            screen.find(imagePattern).hover();
            common.delaySec(2);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

}
