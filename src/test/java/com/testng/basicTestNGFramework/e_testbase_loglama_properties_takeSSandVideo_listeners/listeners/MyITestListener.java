package com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.listeners;

import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.Constants;
import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.TakeScreenShotsUtil;
import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.WebElementUtil;
import logger.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.Constants.FAILED_STEP_SCREENSHOTS_PATH;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.Constants.SCREENSHOTS_PATH;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.FileUtil.createDirectoryIfNotExist;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.ObjectUtil.stepNumber;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.ObjectUtil.webElementName;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.TakeScreenShotsUtil.takeScreenshot;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.WebElementUtil.getWebElement;
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


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage"+ result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result)
    {

        Logger.info("STEP"+stepNumber+"---->"+ result.getName()+"----> FAILED!");

        try {
            createDirectoryIfNotExist(FAILED_STEP_SCREENSHOTS_PATH);
            takeScreenshot(getDriver(), FAILED_STEP_SCREENSHOTS_PATH,result.getName()+"_FAILED",false,true,webElementName);//can throw exception
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info("STEP"+stepNumber+"---->"+ result.getName()+"----> SKIPPED!");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.info("STEP"+stepNumber+"---->"+ result.getName()+"----> PASSED!");
    }



    @Override//@BEFORE METHOD bundan once calisir
    public void onTestStart(ITestResult result) {
        Logger.startLog("STEP"+stepNumber+" - - "+ result.getName());

    }



}