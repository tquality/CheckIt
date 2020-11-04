package io.github.tquality.checkit.CheckOnPage;

import io.github.tquality.Waiting.WaitForIt;
import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Class to check if an element is editable
 */
public abstract class CheckElementEnabled {

    public static void elementWithNameEnableCheck(WebDriver webDriver, String elementName, boolean elementEnabled, String screenshotfolder){
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
        if (webElement.isEnabled() != elementEnabled){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectEnableStatus");
            Assert.assertEquals(webElement.isEnabled(),elementEnabled,"Element " + elementName + " is not show in the correct enable status");
        }
    }

    public static void elementWithXpathEnableCheck(WebDriver webDriver,String elementXpath,boolean elementEnable,String screenshotfolder){
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
        if (webElement.isEnabled() != elementEnable){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectEnableStatus");
            Assert.assertEquals(webElement.isEnabled(),elementEnable,"Element " + elementXpath + " is not show in the correct enable status");
        }
    }

    public static void elementWithIdEnableCheck(WebDriver webDriver,String elementId,boolean elementEnabled,String screenshotfolder){
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
        if (webElement.isEnabled() != elementEnabled){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isEnabled(),elementEnabled,"Element " + elementId + " is not show in the correct Enabled status");
        }
    }

    public static void elementWithCssSelectorEnableCheck(WebDriver webDriver,String cssSelector,boolean elementEnable,String screenshotfolder){
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
        if (webElement.isEnabled() != elementEnable){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotfolder,"ElementNotInCorrectDisplayStatus");
            Assert.assertEquals(webElement.isEnabled(),elementEnable,"Element " + cssSelector
                    + " is not show in the correct enable status");
        }
    }
}
