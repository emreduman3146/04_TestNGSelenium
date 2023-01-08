package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectUtil
{
    public static int stepNumber=1;
    public static Actions actions;
    public static  WebDriverWait wait;
    public static  SoftAssert softAssert;

    public static Properties properties;
    public static String path;

    public static String webElementName;
    public static boolean cleanAllTestOutputFromPreviousExecution=true;//Constant'a koy

    public static ScreenRecorder screenRecorder;//MONTE DEPENDENCY'DEN GELEN CLASSTIR, JDK'DA YOKTUR

    public static Map<byte[],String> ekranGoruntusu_aciklamasi=new LinkedHashMap<>();//ObjectUtil'e koy



    //TESTNG EXTENT-SPARK REPORT OLUSTURMAK ICIN IHTIYAC DUYDUGUMUZ CLASSLAR
    //POM.XML'E KOYDUGUMUZ EXTENTREPORTS ISIMMLI DEPENDENCY'NIN GELIRLER
    public static ExtentSparkReporter spark;//RAPORUN TIPINI BELIRLEYEN CLASS
    public static ExtentReports extent;//RAPORU OLUSTURUCAK CLASS
    public static ExtentTest test;//RAPORUN ICINE GIDIP YAZI YAZACAK, RESIM YAPISTIRACAK CLASS



}
