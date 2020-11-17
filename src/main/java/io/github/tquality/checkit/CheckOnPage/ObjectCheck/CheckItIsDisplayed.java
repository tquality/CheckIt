package io.github.tquality.checkit.CheckOnPage.ObjectCheck;

import io.github.tquality.Waiting.WaitForIt;
import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Check if an element is shown on the page
 */
public abstract class CheckItIsDisplayed {

    /**
     * Display test on an element
     * @param webDriver the running webdriver
     * @param elementName the element we want to test
     * @param elementDisplayed is the element displayed
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithName(WebDriver webDriver,String elementName,boolean elementDisplayed,String screenshotfolder){
        WebElement webElement = null;
        for (int i=0;i<10;i++) {
            WaitForIt.waitForPageToLoad(webDriver);
            try {
                webElement = webDriver.findElement(By.name(elementName));
                break;
            } catch (NoSuchElementException ignored) {
                TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"NoElementsFound");
                Assert.assertEquals(true,false,"No Element found with name:" + elementName);
            }
        }
        if (webElement.isDisplayed() != elementDisplayed){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isDisplayed(),elementDisplayed,"Element " + elementName + " is not show in the correct displaystatus");
        }
    }

    /**
     * Display test on an element
     * @param webDriver the running webdriver
     * @param elementXpath the element we want to test
     * @param elementDisplayed is the element displayed
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithXpath(WebDriver webDriver,String elementXpath,boolean elementDisplayed,String screenshotfolder){
        WebElement webElement = null;
        for (int i=0;i<10;i++) {
            WaitForIt.waitForPageToLoad(webDriver);
            try {
                webElement = webDriver.findElement(By.xpath(elementXpath));
                break;
            } catch (NoSuchElementException ignored) {
                TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"NoElementsFound");
                Assert.assertEquals(true,false,"No Element found with name:" + elementXpath);
            }
        }
        if (webElement.isDisplayed() != elementDisplayed){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isDisplayed(),elementDisplayed,"Element " + elementXpath + " is not show in the correct displaystatus");
        }
    }

    /**
     * Display test on an element
     * @param webDriver the running webdriver
     * @param elementId the element we want to test
     * @param elementDisplayed is the element displayed
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithId(WebDriver webDriver,String elementId,boolean elementDisplayed,String screenshotfolder){
        WebElement webElement = null;
        for (int i=0;i<10;i++) {
            WaitForIt.waitForPageToLoad(webDriver);
            try {
                webElement = webDriver.findElement(By.id(elementId));
                break;
            } catch (NoSuchElementException ignored) {
                TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"NoElementsFound");
                Assert.assertEquals(true,false,"No Element found with id:" + elementId);
            }
        }
        if (webElement.isDisplayed() != elementDisplayed){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isDisplayed(),elementDisplayed,"Element " + elementId + " is not show in the correct displaystatus");
        }
    }

    /**
     * Display test on an element
     * @param webDriver the running webdriver
     * @param cssSelector the element we want to test
     * @param elementDisplayed is the element displayed
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithCssSelector(WebDriver webDriver,String cssSelector,boolean elementDisplayed,String screenshotfolder){
        WebElement webElement = null;
        for (int i=0;i<10;i++) {
            WaitForIt.waitForPageToLoad(webDriver);
            try {
                webElement = webDriver.findElement(By.cssSelector(cssSelector));
                break;
            } catch (NoSuchElementException ignored) {
                TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"NoElementsFound");
                Assert.assertEquals(true,false,"No Element found with cssselector:" + cssSelector);
            }
        }
        if (webElement.isDisplayed() != elementDisplayed){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isDisplayed(),elementDisplayed,"Element " + cssSelector
                    + " is not show in the correct displaystatus");
        }
    }

    /**
     * Display test on an element
     * @param webDriver the running webdriver
     * @param object the element we want to test
     * @param elementDisplayed is the element displayed
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithByObject(WebDriver webDriver,By object,boolean elementDisplayed,String screenshotfolder){
        WebElement webElement = null;
        for (int i=0;i<10;i++) {
            WaitForIt.waitForPageToLoad(webDriver);
            try {
                webElement = webDriver.findElement(object);
                break;
            } catch (NoSuchElementException ignored) {
                TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"NoElementsFound");
                Assert.assertEquals(true,false,"No Element found");
            }
        }
        if (webElement.isDisplayed() != elementDisplayed){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isDisplayed(),elementDisplayed,"Element is not show in the correct displaystatus");
        }
    }
}
