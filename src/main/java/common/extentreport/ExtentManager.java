package common.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.FormatDate;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static FormatDate formatDate = new FormatDate();
    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/"+formatDate.formatTime()+"report.html");
        reporter.config().setReportName("RAILWAY2_TEST");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Admin", "Program Name");
        extentReports.setSystemInfo("ThoDuong", "Selenium LV1");
        return extentReports;
    }
}
