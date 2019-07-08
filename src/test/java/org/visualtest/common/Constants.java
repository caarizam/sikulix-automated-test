package org.visualtest.common;

public class Constants {

    private static Constants instance;

    private Constants() {
    }

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    public final String GREEN = "green";
    public final String BLUE = "blue";
    public final String RED = "red";

    private final int pageHeight = 744;
    private final int pageWidth = 1382;
    private int defaultTimeout = 7;
    private int defaultWaitTimeout = 10;

    public int getPageHeight() {
        return pageHeight;
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public int getDefaultTimeout() {
        return defaultTimeout;
    }

    public void setDefaultTimeout(int defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
    }

    public int getDefaultWaitTimeout() {
        return defaultWaitTimeout;
    }

    public void setDefaultWaitTimeout(int defaultWaitTimeout) {
        this.defaultWaitTimeout = defaultWaitTimeout;
    }
}
