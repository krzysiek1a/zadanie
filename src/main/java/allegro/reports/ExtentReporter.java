package allegro.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {
        String path = "src\\main\\resources\\reports\\index.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("Zadanie");
        reporter.config().setDocumentTitle("Rezultat");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tester", "Krzysiek W");
        return  extent;
    }
}
