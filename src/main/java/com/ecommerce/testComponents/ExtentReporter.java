package com.ecommerce.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecommerce.base.Base;

public class ExtentReporter extends Base {

    public static ExtentReports getExtentReportsObj() {
        String path = System.getProperty("user.dir") + "\\reports\\extent.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Ecommerce Application Test");
        reporter.config().setDocumentTitle("Test Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Narayan");

        return  extent;
    }

}
