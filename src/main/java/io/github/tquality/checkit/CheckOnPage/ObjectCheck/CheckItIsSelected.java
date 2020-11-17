package io.github.tquality.checkit.CheckOnPage.ObjectCheck;

import io.github.tquality.Waiting.WaitForIt;
import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Check it if an element is selected or not
 */
public class CheckItIsSelected {

    /**
     * Selection test on obect
     * @param webDriver running webdriver
     * @param elementName the element we want to test
     * @param elementSelected is the element selected or not
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithName(WebDriver webDriver, String elementName, boolean elementSelected, String screenshotfolder){
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
        if (webElement.isSelected() != elementSelected){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementSelectionIncorrect");
            Assert.assertEquals(webElement.isEnabled(),elementSelected,"Element " + elementName + " is not correct");
        }
    }

    /**
     * Selection test on obect
     * @param webDriver running webdriver
     * @param elementXpath the element we want to test
     * @param elementSelected is the element selected or not
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithXpath(WebDriver webDriver,String elementXpath,boolean elementSelected,String screenshotfolder){
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
        if (webElement.isSelected() != elementSelected){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementSelectionIncorrect");
            Assert.assertEquals(webElement.isEnabled(),elementSelected,"Element " + elementXpath + " is not correct");
        }
    }

    /**
     * Selection test on obect
     * @param webDriver running webdriver
     * @param elementId the element we want to test
     * @param elementSelected is the element selected or not
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithId(WebDriver webDriver,String elementId,boolean elementSelected,String screenshotfolder){
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
        if (webElement.isSelected() != elementSelected){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementSelectionIncorrect");
            Assert.assertEquals(webElement.isEnabled(),elementSelected,"Element " + elementId + " is not correct");
        }
    }

    /**
     * Selection test on obect
     * @param webDriver running webdriver
     * @param cssSelector the element we want to test
     * @param elementSelected is the element selected or not
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithCssSelector(WebDriver webDriver,String cssSelector,boolean elementSelected,String screenshotfolder){
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
        if (webElement.isSelected() != elementSelected){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementSelectionIncorrect");
            Assert.assertEquals(webElement.isEnabled(),elementSelected,"Element " + cssSelector
                    + " is not correct");
        }
    }

    /**
     * Selection test on obect
     * @param webDriver running webdriver
     * @param object the element we want to test
     * @param elementSelected is the element selected or not
     * @param screenshotfolder the screenshotfolder for errors
     */
    public static void elementWithByObject(WebDriver webDriver,By object,boolean elementSelected,String screenshotfolder){
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
        if (webElement.isSelected() != elementSelected){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementSelectionIncorrect");
            Assert.assertEquals(webElement.isEnabled(),elementSelected,"Element is not correct");
        }
    }
}
