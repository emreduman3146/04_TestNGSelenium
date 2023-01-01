package com.testng.annotations.c_advancedAnnotations.b_Parameterization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleParameterKullanimi
{

    @Test
    @Parameters({"browser","url"})
    public void parallelCrossBrowserTesting(String param, String param2)
    {
        System.out.println("Thread NAME : "+Thread.currentThread().getName());

        switch (param)
        {
            case "chrome":
                WebDriverManager.chromedriver().avoidShutdownHook().create().get(param2);break;
            case "firefox":
                WebDriverManager.firefoxdriver().avoidShutdownHook().create().get(param2);break;
            case "edge":
                WebDriverManager.edgedriver().avoidShutdownHook().create().get(param2);break;
        }

    }


    /*
    paramatereler testNG.xml filelardan gelmelidir
     */


}
