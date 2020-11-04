package io.github.tquality.checkit.CheckOnPage;

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
public abstract class CheckElementDisplayed {

    public static void elementWithNameDisplayCheck(WebDriver webDriver,String elementName,boolean elementDisplayed,String screenshotfolder){
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

    public static void elementWithXpathDisplayCheck(WebDriver webDriver,String elementXpath,boolean elementDisplayed,String screenshotfolder){
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

    public static void elementWithIdDisplayCheck(WebDriver webDriver,String elementId,boolean elementDisplayed,String screenshotfolder){
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

    public static void elementWithCssSelectorDisplayCheck(WebDriver webDriver,String cssSelector,boolean elementDisplayed,String screenshotfolder){
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
}
