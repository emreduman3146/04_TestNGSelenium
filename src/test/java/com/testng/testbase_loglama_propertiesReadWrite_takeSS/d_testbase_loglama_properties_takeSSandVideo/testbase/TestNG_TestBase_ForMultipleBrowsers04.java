package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.testbase;

import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.Constants.*;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.FileUtil.refreshTestOutput;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.ObjectUtil.*;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.TakeScreenShotsUtil.takeScreenshot;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.z_driver.DriverClass.*;

import com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.Constants;
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.FileUtil;
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.PDFUtil;
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.ScreenRecorderUtil;
import logger.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TestNG_TestBase_ForMultipleBrowsers04
{

    @BeforeSuite
    public void cleanDirectory() throws IOException, AWTException {
        if(cleanAllTestOutputFromPreviousExecution)
        {
            refreshTestOutput();//bu directory'i sil ve ici bos secilde tekrardan olustur
            cleanAllTestOutputFromPreviousExecution=false;
        }

        ScreenRecorderUtil.startRecording();

    }

    @BeforeTest
    @Parameters({"browser","DURATION"})
    public void launchBrowser(@Optional("chrome") String param,String param2) throws IOException {
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
    public void beforeMethod()
    {
         Logger.startLog("STEP"+stepNumber);
    }


    @AfterMethod
    public void afterMethod() throws IOException, InterruptedException {

        takeScreenshot(getDriver(), SCREENSHOTS_PATH,"endOfStep",false);//can throw exception

        Logger.endLog("STEP"+stepNumber++);


    }


    @AfterTest
    public void tearDown() throws IOException {
        ScreenRecorderUtil.stopRecording();

        closeDriver();
        softAssert.assertAll();
        // -> EGER TEST STEPLERININ ICINDE SOFTASSERTION KULLANDIYSAK BU SATIRI EN SONDA CALISTIRMALIYIZ

    }


    @AfterSuite
    public void afterSuite()
    {
        PDFUtil.pdfWrite(ekranGoruntusu_aciklamasi,PDFPATH_SCREENSHOTS,"trendyolEkranGoruntuleri");
    }


}



