package io.github.tquality.checkit.CheckOnPage.StandardCheck;

import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * CheckIt if 2 objects are equal
 */
public abstract class CheckItEquals {

    /**
     * Check if 2 booleans are equal
     * @param webDriver the running webdriver
     * @param firstObject the first object
     * @param secondObject the second object
     * @param screenshotFolder the folder we want to store our scnreeshots in
     */
    public static void booleanAreEqual(WebDriver webDriver,boolean firstObject, boolean secondObject, String screenshotFolder){
        if (firstObject != secondObject){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"ObjectNotEqual");
        }
        Assert.assertEquals(firstObject,secondObject);
    }

    /**
     * Check if 2 Strings are equal
     * @param webDriver the running webdriver
     * @param firstObject the first object
     * @param secondObject the second object
     * @param screenshotFolder the folder we want to store our scnreeshots in
     */
    public static void stringsAreEqual(WebDriver webDriver,String firstObject, String secondObject, String screenshotFolder){
        if (!firstObject.equals(secondObject)){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"ObjectNotEqual");
        }
        Assert.assertEquals(firstObject,secondObject);
    }

    /**
     * Check if 2 ints are equal
     * @param webDriver the running webdriver
     * @param firstObject the first object
     * @param secondObject the second object
     * @param screenshotFolder the folder we want to store our scnreeshots in
     */
    public static void intAreEqual(WebDriver webDriver,int firstObject, int secondObject, String screenshotFolder){
        if (firstObject != secondObject){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"ObjectNotEqual");
        }
        Assert.assertEquals(firstObject,secondObject);
    }

    /**
     * Check if 2 longs are equal
     * @param webDriver the running webdriver
     * @param firstObject the first object
     * @param secondObject the second object
     * @param screenshotFolder the folder we want to store our scnreeshots in
     */
    public static void longAreEqual(WebDriver webDriver,long firstObject, long secondObject, String screenshotFolder){
        if (firstObject != secondObject){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"ObjectNotEqual");
        }
        Assert.assertEquals(firstObject,secondObject);
    }

    /**
     * Check if 2 double are equal
     * @param webDriver the running webdriver
     * @param firstObject the first object
     * @param secondObject the second object
     * @param screenshotFolder the folder we want to store our scnreeshots in
     */
    public static void doubleAreEqual(WebDriver webDriver,double firstObject, double secondObject, String screenshotFolder){
        if (firstObject != secondObject){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"ObjectNotEqual");
        }
        Assert.assertEquals(firstObject,secondObject);
    }
}
