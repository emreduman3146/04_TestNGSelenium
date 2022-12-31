package com.testng.annotations.c_advancedAnnotations.b_Parameterization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassicParameterKullanimi
{

    //BU CLASSTA 2 TANE ORNEGIMIZ VAR
    //TEST SUITE, YESIL JAVA DIRECTORY'SININ ALTINDAKI @TESTLERIMIZI TEK ELDEN YONETMEMIZI SAGLAYAN .xml FILEDIR
    //Parametreli @Testlerimin run edilmesinin yolu testNG.xml file'dir


    @Test
    @Parameters({"keyWord1"})//parameters taginin  icine variable isimleri yazariz
                             //yani keyWord1 bir variable ismi olmak zorunda
    public void testMethod(String param1) throws InterruptedException {
        System.out.println(param1);
        Thread.sleep(3000);
    }



    @Test(priority = 1)
    @Parameters({"browser"})
    public void testMethod2(String param)
    {
        switch (param)
        {
            case "chrome":
                WebDriverManager.chromedriver().avoidShutdownHook().create().get("https://www.google.com");break;
            case "firefox":
                WebDriverManager.firefoxdriver().avoidShutdownHook().create().get("https://www.google.com");break;
            case "edge":
                WebDriverManager.edgedriver().avoidShutdownHook().create().get("https://www.google.com");break;
        }

    }




    /*
    paramatereler testNG.xml filelardan gelmelidir
     */


}
