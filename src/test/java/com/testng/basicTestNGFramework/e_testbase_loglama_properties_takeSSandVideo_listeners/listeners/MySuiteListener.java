package com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.listeners;

import logger.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {


    @Override//BEFORESUITE GIBIDIR
    public void onStart(ISuite suite) {
        Logger.startLog(suite.getName());

    }


    @Override//AFTERSUITE GIBIDIR
    public void onFinish(ISuite suite)
    {
        Logger.endLog(suite.getName());

    }

}