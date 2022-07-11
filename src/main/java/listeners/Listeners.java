package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.CommonUtilFunction;
import utilities.ExtentReporter;

public class Listeners extends CommonUtilFunction implements ITestListener {

	ExtentReports extentreporter = ExtentReporter.getExtenntReports();
	
	public ExtentTest extenttest;

	// making thread safe to use this resources multiple places simultaneously
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		//Making thread as safe
		extenttest = extentreporter.createTest(result.getName());
		extentTestThread.set(extenttest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// extenttest.log(Status.PASS, "Test passed");
		// using safe thread
		extentTestThread.get().log(Status.PASS, "Test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// extenttest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		WebDriver driver = null;
		String testname = result.getName();
		try {
			// it will give current webDriver
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			   
			String screeenshortfilepath = takescreenshot(testname, driver);
			extentTestThread.get().addScreenCaptureFromPath(screeenshortfilepath, testname);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentreporter.flush();
	}

}
