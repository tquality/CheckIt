package io.github.tquality.checkit.Screenshot;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class to take screenshots
 */
public abstract class TakeScreenshot {

    /**
     * Resolve the screenshot dir
     * @param pathScreenshotFolder the path of the screenshot dir in string
     * @return a path of the screenshot dir
     */
    private static Path resolveScreenshotDir(String pathScreenshotFolder) {
        final Path dir = Paths.get(pathScreenshotFolder);
        if (!Files.isDirectory(dir)) {
            try {
                Files.createDirectories(dir);
            } catch (IOException e) {
                throw new RuntimeException("Issue with creating screenshot dir", e);
            }
        }
        return dir;
    }

    /**
     * Create a screenshot and save it as an PNG
     * @param seleniumWebdriver the running webdriver
     * @param pathScreenshotFolder the path to the screenshot folder
     * @param nameScreenshot the name of the screenshot
     */
    public static void createScreenshotPNG(WebDriver seleniumWebdriver, String pathScreenshotFolder, String nameScreenshot){
        Path screenshotDir = TakeScreenshot.resolveScreenshotDir(pathScreenshotFolder);
        Capabilities dataBrowser = ((RemoteWebDriver) seleniumWebdriver).getCapabilities();
        File screencapture = ((TakesScreenshot) seleniumWebdriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.getFileUtils().copyFile(screencapture, screenshotDir.resolve(nameScreenshot + ".png").toFile());
        }catch (IOException e){
            throw new RuntimeException("Failed to create screencaptur",e);
        }
    }

    /**
     * Create a screenshot and save it as an JPEG
     * @param seleniumWebdriver the running webdriver
     * @param pathScreenshotFolder the path to the screenshot folder
     * @param nameScreenshot the name of the screenshot
     */
    public static void createScreenshotJPEG(WebDriver seleniumWebdriver, String pathScreenshotFolder,String nameScreenshot){
        Path screenshotDir = TakeScreenshot.resolveScreenshotDir(pathScreenshotFolder);
        Capabilities dataBrowser = ((RemoteWebDriver) seleniumWebdriver).getCapabilities();
        File screencapture = ((TakesScreenshot) seleniumWebdriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.getFileUtils().copyFile(screencapture, screenshotDir.resolve(nameScreenshot + ".jpeg").toFile());
        }catch (IOException e){
            throw new RuntimeException("Failed to create screencaptur",e);
        }
    }
}
