package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.Constants;
import logger.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.Constants.FAILED_STEP_SCREENSHOTS_PATH;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.Constants.ssPath;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.FileUtil.createDirectoryIfNotExist;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil.*;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.TakeScreenShotsUtil.takeScreenshot;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.getDriver;

public class MyITestListener implements ITestListener {

    @Override//BEFORETEST GIBIDIR
    public void onStart(ITestContext contextStart) {

        Logger.startLog(contextStart.getName());
    }

    @Override
    public void onFinish(ITestContext contextFinish) {
        Logger.endLog(contextFinish.getName());


    }


    @Override//BEFORE METHOD ILE AYNIDIR-
    public void onTestStart(ITestResult result)
    {
        Logger.startLog("STEP"+stepNumber+" - - "+ result.getName());

        test=extent.createTest(result.getMethod().getConstructorOrMethod().getName())
                .assignAuthor("SDET Dmn")
                .assignCategory("Smoke Test")
                .assignDevice("Windows");
    }


    @Override
    public void onTestSuccess(ITestResult result)
    {
        String logMessage="  STEP"+stepNumber+"---->"+ result.getName()+"----> PASSED!";
        Logger.info(logMessage);
        test.log(Status.PASS,result.getName());
        test.info(logMessage);
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Logger.info("Test failed but it is in defined success ratio " + iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String logMessage="  STEP"+stepNumber+"---->"+ result.getName()+"----> FAILED!";
        Logger.info(logMessage);

        try {
            createDirectoryIfNotExist(FAILED_STEP_SCREENSHOTS_PATH);
            Constants.ssPath=takeScreenshot(getDriver(), FAILED_STEP_SCREENSHOTS_PATH,result.getName()+"_FAILED",false,true,webElementName);//can throw exception
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        test.log(Status.FAIL,result.getName());
        test.warning(logMessage);




    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logMessage="  STEP"+stepNumber+"---->"+ result.getName()+"----> SKIPPED!";

        Logger.info(logMessage);
        test.log(Status.SKIP,result.getName());
        test.skip(result.getName()+logMessage);
    }






}