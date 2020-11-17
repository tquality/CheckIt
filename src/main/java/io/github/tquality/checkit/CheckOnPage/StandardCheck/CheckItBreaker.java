package io.github.tquality.checkit.CheckOnPage.StandardCheck;

import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Class to break a testcase
 */
public abstract class CheckItBreaker {

    /**
     * Break the test and take a screenshot, the result expected is true
     * @param webdriver the running webdriver
     * @param result The boolean result
     * @param screenshotFolder the screenshotfolder
     */
    public static void breakTestTrue(WebDriver webdriver,boolean result,String screenshotFolder){
        TakeScreenshot.createScreenshotJPEG(webdriver,screenshotFolder,"TextNotFound");
        Assert.assertEquals(true,result);
    }

    /**
     * Break the test and take a screenshot, the result expected is false
     * @param webdriver the running webdriver
     * @param result The boolean result
     * @param screenshotFolder the screenshotfolder
     */
    public static void breakTestFalse(WebDriver webdriver,boolean result,String screenshotFolder){
        TakeScreenshot.createScreenshotJPEG(webdriver,screenshotFolder,"TextNotFound");
        Assert.assertEquals(false,result);
    }
}
