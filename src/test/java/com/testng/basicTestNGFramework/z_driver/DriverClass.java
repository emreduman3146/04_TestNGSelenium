package com.testng.basicTestNGFramework.z_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverClass {

    //hic bir Classtan erisilemez
    private static WebDriver driver;

    public static WebDriver getDriver(String browser)//browser parameter coming from TestBaseCross class
    {
        if (driver == null)
        {
            //eger xml'deki  browser null degilse , xml file'daki browser kullanilir
            //eger xml'deki  browser null ise, asagidaki satirda elle yazilan(hardCoded) parameter(chrome) kullanilir
            browser = browser == null ? "chrome" : browser;

            switch (browser)
            {
                case "chrome":
                    ChromeOptions option1=new ChromeOptions();
                    option1.addArguments("--start-maximized","--disable-notifications");
                    driver= WebDriverManager.chromedriver().avoidShutdownHook().capabilities(option1).create();
                    break;
                case "firefox":
                    driver= new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    EdgeOptions option3=new EdgeOptions();
                    option3.addArguments("--start-maximized");
                    driver= new EdgeDriver(option3);
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();//Selenium 3'te browser baslatma sekli boyle idi
                    driver=new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();//setup()  eski driver olusturma yontemidir
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }

        return driver;
    }


   public static WebDriver getDriverByDefaultBrowser()
    {
        return getDriver(null);
    }

    //yukaridaki 2 method'tan biri testlerimizi yazdigimiz classta kullanildiktan sonra
    //bu method ihtiyac halinde testlerimizi yazdigimiz classta kullanilir
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;//BUNU YAZIN KESINLIKLE CUNKU BIZ QUIT ILE BROWSERI KAPATSAK BILE DRIVER NULL OLMAZ
        }
    }
}
