package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class d_DataProviderKullanimi_Parallel
{


    @Test
    void setUp()
    {
        System.out.println("DATAPROVIDER EXAMPLE WITH PARALLEL EXECUTION");
    }

    @DataProvider(name = "testData2",parallel = true)
    public static Object[][] testData2() {
        return new Object[][] {
                {"chrome","https://www.google.com"},//1.loop
                {"firefox","https://www.mozilla.com"},//1.loop
                {"edge","https://www.edge.com"}//1.loop
        };
    }

    //DEFAULT OLARAK HER ZAMAN ARKADA 1 TANE THREAD CALISIR(YESIL OKA TIKLAYINCA)
    //ARKAPLANDA 3 TANE THREAD OLUSUR. HER THREAD 1 PARAMETREYI ALIP COMPILE/RUN DER
    @Test(
            dataProvider = "testData2",
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
