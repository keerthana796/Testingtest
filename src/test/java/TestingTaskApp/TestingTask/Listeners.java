package TestingTaskApp.TestingTask;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener {
	ExtentTest test;
	AppiumDriver driver;
	ExtentReports extent = ExtentReporterNg.getReporterObject();
	@Override
	public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
