package io.github.tquality.checkit.CheckOnPage.DataCheck;

import io.github.tquality.Waiting.WaitForIt;
import io.github.tquality.checkit.Screenshot.TakeScreenshot;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Check for texts on page
 */
public abstract class CheckText {

    /**
     * Check if the page source contains a certain text
     * @param webdriver the running webdriver
     * @param text the text we want to find
     * @param screenshotFolder the screenshotfolder
     */
    public static void pageSourceContainsText(WebDriver webdriver, String text, String screenshotFolder){
        boolean check = webdriver.getPageSource().contains(text);
        if(!check){
            TakeScreenshot.createScreenshotJPEG(webdriver,screenshotFolder,"TextNotFound");
            Assert.assertEquals(true,check);
        }
    }

    /**
     * Check if the page source contains a certain text
     * @param webdriver the running webdriver
     * @param text the text we want to find
     * @param screenshotFolder the screenshotfolder
     */
    public static void pageSourceDoesNotContainText(WebDriver webdriver, String text, String screenshotFolder){
        boolean check = webdriver.getPageSource().contains(text);
        if(check){
            TakeScreenshot.createScreenshotJPEG(webdriver,screenshotFolder,"TextNotFound");
            Assert.assertEquals(false,check);
        }
    }

    /**
     * Check if a text effectivly is shown on the page
     * @param webDriver the running webdriver
     * @param text the text we want to find
     * @param screenshotFolder the screenshotfolder for screenshots
     */
    public static void textDisplayedOnPage(WebDriver webDriver,String text,String screenshotFolder){
        WaitForIt.waitForElementPresentXpath(webDriver,"//*[contains(text(),'" + text + "')]");
        try{
            List<WebElement> webElements = webDriver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
            for (WebElement webelement:webElements) {
                if (!webelement.isDisplayed()){
                    TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"Text not found on the page");
                    Assert.assertEquals(false,true,"Text not found on the page");
                }
            }
        }catch (NoSuchElementException ignored){
            TakeScreenshot.createScreenshotJPEG(webDriver,screenshotFolder,"Text not found on the page");
            Assert.assertEquals(false,true,"Text not found on the page");
        }
    }
}
