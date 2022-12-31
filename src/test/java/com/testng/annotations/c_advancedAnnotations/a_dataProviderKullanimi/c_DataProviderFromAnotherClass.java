package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class c_DataProviderFromAnotherClass
{


    @Test
    void setUp()
    {
        System.out.println("DATAPROVIDER EXAMPLE FROM ANOTHER CLASS");
    }



    @Test(
            dataProvider = "testData2",
            dataProviderClass = DataProviderlariDepoladigimClass.class,
            dependsOnMethods = "setUp"
    )
    public void dataProviderKullanimi2(String browser, String url)
    {
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().avoidShutdownHook().create().get(url);break;
            case "firefox":
                WebDriverManager.firefoxdriver().avoidShutdownHook().create().get(url);break;
            case "edge":
                WebDriverManager.edgedriver().avoidShutdownHook().create().get(url);break;
        }
    }







}
