package com.testng.testbase_loglama_propertiesReadWrite_takeSS.b_testbase_loglama.testbase_paramsFromTestSuite;

import com.testng.testbase_loglama_propertiesReadWrite_takeSS.b_testbase_loglama.Trendyol_UI_Automation;
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.driver.DriverClass;
import logger.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.driver.DriverClass.getDriver;


public class TestNG_TestBase_ForMultipleBrowsers
{
    // @Optional --> Parametreyi xml dosyasından her zaman sağlamak istemediğimizden, @Optional kullaniyoruz
    // @Parameters -> browser türünü xml dosyasından nasıl alabiliriz ???
    // @Parameters kullanarak: bu, testbasecross'in xml dosyasını okumasına yardımcı olacaktır. "browser'i" bulun ve değeri atayın

    int stepNumber=1;
    static public Actions actions;
    static public WebDriverWait wait;
    static public SoftAssert softAssert;

    @BeforeTest
    @Parameters({"browser","DURATION"})
    public void launchBrowser(String param,String param2)
    {
        //DRIVER'IMIZIN TYPE'I PARAMETER OLARAK GONDERILDI VE DRIVER OLUSTURULDU
        DriverClass.getDriver(param);


        actions= new Actions(getDriver());

        int duration=Integer.parseInt(param2);//String olan 10 degerini al integer a donustur

        wait=new WebDriverWait(getDriver(),Duration.ofSeconds(duration));

        softAssert=new SoftAssert();


        //WAIT AYARLARI YAPILDI
        //testlerimize baslamadan once genellikle before methodlarinda waitlerimizin ayarlarini yazariz
        DriverClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
        DriverClass.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(duration));

    }

    @BeforeMethod
    public void beforeMethod()
    {
        Logger.startLog("STEP"+stepNumber);

    }


    @AfterMethod
    public void afterMethod()
    {
        Logger.endLog("STEP"+stepNumber++);

    }


    @AfterTest
    public void tearDown() {

        DriverClass.closeDriver();
       // softAssert.assertAll();

    }





}