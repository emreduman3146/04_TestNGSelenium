package com.testng.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {


    //Sadece tanimdir, declaration
   static private WebDriver driver;//null
   static private Driver myObje;

    private Driver()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver= WebDriverManager.chromedriver().avoidShutdownHook().capabilities(options).create();
    }

    //static import ile mu method import edilip kolayca kullanilabilsin diye
    static public WebDriver getDriver()
    {
        if(driver==null)
            myObje=new Driver();

        return driver;

    }


}
