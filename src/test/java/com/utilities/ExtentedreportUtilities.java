package com.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentedreportUtilities {
	private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize the ExtentReports object
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Initialize ExtentTest object for each scenario
    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    // Get the current test
    public static ExtentTest getTest() {
        return test;
    }

    // Flush the report after tests are executed
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}


