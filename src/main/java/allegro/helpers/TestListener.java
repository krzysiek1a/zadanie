package allegro.helpers;

import allegro.reports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener extends Base implements ITestListener {

    ExtentReports extent = ExtentReporter.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "test success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            test.log(Status.FAIL, "Failed Case is: " + iTestResult.getName());
            test.log(Status.FAIL, iTestResult.getName()+" FAIL with error " + iTestResult.getThrowable());
            test.addScreenCaptureFromPath(SeleniumHelper.takeScreenshot(iTestResult.getMethod().getMethodName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        extent.flush();
    }
}
