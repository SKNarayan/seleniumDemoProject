package utilities.reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtility {

    public static ExtentReports createReport(String extentTestName) {
        try {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//" + extentTestName + ".html");
            ExtentReports extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            sparkReporter.config().setDocumentTitle("Extent Report");
            sparkReporter.config().setReportName("Test Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            return extentReports;

        } catch (Exception e) {
            throw new RuntimeException("ExtentUtility : create_report || Error while creating the extent report. \n " + e.getMessage(), e);
        }
    }



}
