package org.visual.test.common;

public class CommonMethods {

    public void delaySec(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (Exception ex){

        }
    }

}
