package com.ravi.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ravi.utilities.CommonUtilities;
import com.ravi.utilities.TestBase;


public class TestListener implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>(); 

    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Test Suite is ending!"));
        extent.flush();
    }

    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentManager.extLogger = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(ExtentManager.extLogger);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        try {
			ExtentManager.extLogger.log(Status.FAIL, "Failed"+ExtentManager.extLogger.addScreenCaptureFromPath(CommonUtilities.takeScreenShotWebReturnPath(TestBase.driver, result.getClass().getName()+"_"+result.getMethod().getMethodName())));
        } catch (IOException e) {
		}
    }

    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
        try {
			
			ExtentManager.extLogger.log(Status.SKIP,"SKIP: "+ ExtentManager.extLogger.addScreenCaptureFromPath(CommonUtilities.takeScreenShotWebReturnPath(TestBase.driver, TestBase.sClassNameForScreenShot+"_"+result.getMethod().getMethodName())));
		} catch (IOException e) {
		}
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
    
}