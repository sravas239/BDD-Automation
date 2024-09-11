package Stepdefintion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtilities {
		public static void captureScreenshot(WebDriver driver, String filePath) throws IOException {
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		    File destFile = new File("C:\\Users\\DELL\\eclipse-workspace\\Project1\\BddAutomation\\path\\to\\save\\Screenshots.png");
		    FileUtils.copyFile(srcFile, destFile);
		}

}
