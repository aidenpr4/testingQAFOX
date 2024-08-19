package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testBase.RegBase;

public class ExtentTestListener extends RegBase implements ITestListener {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ExtentReports extent;

	static {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
		sparkReporter.config().setReportName("My Test Report");
		sparkReporter.config().setDocumentTitle("Extent Report");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip("Test Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// Initialize or configure as needed
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
}
