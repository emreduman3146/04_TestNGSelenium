package com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.testbase;

import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.PDFUtil;
import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.ScreenRecorderUtil;
import logger.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.Constants.*;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.FileUtil.refreshDirectory;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.ObjectUtil.*;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.TakeScreenShotsUtil.takeScreenshot;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.closeDriver;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.getDriver;

public class TestNG_TestBase_ForMultipleBrowsers05
{

    @BeforeSuite
    public void cleanDirectory() throws IOException, AWTException {
        if(cleanAllTestOutputFromPreviousExecution)
        {
            refreshDirectory(TEST_OUTPUT_PATH);
            cleanAllTestOutputFromPreviousExecution=false;
        }

        ScreenRecorderUtil.startRecording();

    }

    @BeforeTest
    @Parameters({"browser","DURATION"})
    public void launchBrowser(@Optional("chrome") String param,String param2) {
        //DRIVER'IMIZIN TYPE'I PARAMETER OLARAK GONDERILDI VE DRIVER OLUSTURULDU
        getDriver(param);


        actions= new Actions(getDriver());

        int duration=Integer.parseInt(param2);//String olan 10 degerini al integer a donustur

        wait=new WebDriverWait(getDriver(),Duration.ofSeconds(duration));

        softAssert=new SoftAssert();


        //WAIT AYARLARI YAPILDI
        //testlerimize baslamadan once genellikle before methodlarinda waitlerimizin ayarlarini yazariz
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(duration));

    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String param) throws InterruptedException {
        Thread.sleep(2000);
        if (getDriver()==null)
            getDriver(param);

   }


    @AfterMethod
    public void afterMethod() throws IOException, InterruptedException {
        Thread.sleep(2000);
        if (getDriver()!=null)
            takeScreenshot(getDriver(), SCREENSHOTS_PATH,"endOfStep",false,false,"");//can throw exception

        Logger.endLog("STEP"+stepNumber++);
    }


    @AfterTest
    public void tearDown() throws IOException {
        ScreenRecorderUtil.stopRecording();

        closeDriver();
        //softAssert.assertAll();
        // -> EGER TEST STEPLERININ ICINDE SOFTASSERTION KULLANDIYSAK BU SATIRI EN SONDA CALISTIRMALIYIZ

    }


    @AfterSuite
    public void afterSuite()
    {
        PDFUtil.pdfWrite(ekranGoruntusu_aciklamasi,PDFPATH_SCREENSHOTS,"trendyolEkranGoruntuleri");
    }

}



