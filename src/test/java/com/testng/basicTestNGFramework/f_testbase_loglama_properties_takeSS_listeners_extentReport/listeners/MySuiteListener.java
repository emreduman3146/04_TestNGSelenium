package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.Constants;
import com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil;
import logger.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil.*;

public class MySuiteListener implements ISuiteListener {


    @Override//BEFORESUITE GIBIDIR
    public void onStart(ISuite suite) {
        Logger.startLog(suite.getName());

        //F PACKAGEG;I ILE GELDI
        spark = new ExtentSparkReporter(Constants.EXTENT_SPARK_REPORT+"spark.html");//RAPORUMUN TUPINI BELIRLEYEN CLASSTI
        spark.config().setTheme(Theme.STANDARD);//config()->configuration-ayar yapmak  setTheme-temasini degistir
        spark.config().setDocumentTitle("TRENDYOL AUTOMATION TESTING - TESTNG_7 - EXTENT REPORT 5 - SPARK REPORT");
        spark.config().setReportName("EXTENT REPORT 5 - SPARK REPORT");


        extent = new ExtentReports();
        extent.attachReporter(spark);//ilk class reporrt tipi + ayarlarini tutar bunu extent'in icine atariz ki extent bu reportu yonetsin


    }


    @Override//AFTERSUITE GIBIDIR
    public void onFinish(ISuite suite)
    {
        Logger.endLog(suite.getName());

        extent.flush();//MyITestListener'da yazdigimiz kodlari rapora basar

    }

}