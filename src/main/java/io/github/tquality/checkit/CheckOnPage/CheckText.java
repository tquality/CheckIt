package io.github.tquality.checkit.CheckOnPage;

import io.github.tquality.Waiting.WaitForIt;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CheckText {

    /**
     * Searches for all elements with the exact given text and asserts this
     * @param webdriver the running webdriver
     * @param text the text we want to find
     */
    public void exactTextOnPage(WebDriver webdriver, String text){
        String xpath = "./[text()='" + text + "']";
        Optional<WebElement> webElements = WaitForIt.waitForElementXpath(webdriver,xpath);
        if (!webElements.isEmpty()){
            List<WebElement> webElementsFound = webElements.stream().collect(Collectors.toList());
            for (WebElement webElement:webElementsFound) {
                Assert.assertEquals(webElement.getText(),text,"Element does not have the exact text");
            }
        }
    }

    /**
     * Searches if the pages contains elements that contain a certain string
     * @param webDriver the running webdriver
     * @param containText the part of the text we search
     */
    public void pageContainsText(WebDriver webDriver, String containText){
        String xpath = "./[contains(text(),'" + containText + "']";
        Optional<WebElement> webElements = WaitForIt.waitForElementXpath(webDriver,xpath);
        if (!webElements.isEmpty()){
            List<WebElement> webElementsFound = webElements.stream().collect(Collectors.toList());
            for (WebElement webElement:webElementsFound) {
                Assert.assertEquals(webElement.getText().indexOf(containText),true,"Element does not contain the exact text");
            }
        }
    }

    /**
     * Check if a page doesn't contain a certain text
     * @param webDriver the running webdriver
     * @param text the text we don't want on the page
     */
    public void pageDoesNotContainText(WebDriver webDriver, String text){
        String xpath = "./[contains(text(),'" + text + "']";
        try {
            WaitForIt.waitForElementXpath(webDriver, text);
        }catch (NoSuchElementException ignored){
            return;
        }
        Assert.assertEquals(false,true,"Found elements on the page that contained the given text");
    }
}
