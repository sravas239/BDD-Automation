package Stepdefintion;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Hooks {
	private WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {
        // Initialize WebDriver
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Extent Reports (only once)
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            
        }

        // Create a new test in the Extent Report for each scenario
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if the scenario fails
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/screenshots/" + scenario.getName() + ".png";
            File destFile = new File(screenshotPath);
            try {
                FileUtils.copyFile(srcFile, destFile);
                // Log screenshot to Extent Report
                test.fail("Scenario Failed, Screenshot captured: " + screenshotPath);
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log scenario pass to Extent Report
            test.pass("Scenario passed!");
        }

        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Flush ExtentReports (write everything to the file)
        extent.flush();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static ExtentTest getTest() {
        return test;
    }

}
