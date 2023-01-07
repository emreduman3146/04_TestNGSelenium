package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Properties;
import java.util.Set;

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

    public static Set<Cookie> allCookies;



}
