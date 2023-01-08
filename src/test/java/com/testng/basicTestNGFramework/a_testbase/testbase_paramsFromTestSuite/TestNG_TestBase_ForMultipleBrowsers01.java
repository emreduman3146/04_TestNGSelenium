package com.testng.basicTestNGFramework.a_testbase.testbase_paramsFromTestSuite;

import com.testng.basicTestNGFramework.z_driver.DriverClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestNG_TestBase_ForMultipleBrowsers01
{
    // @Optional --> Parametreyi xml dosyasından her zaman sağlamak istemediğimizden, @Optional kullaniyoruz
    // @Parameters -> browser türünü xml dosyasından nasıl alabiliriz ???
    // @Parameters kullanarak: bu, testbasecross'in xml dosyasını okumasına yardımcı olacaktır. "browser'i" bulun ve değeri atayın

    @BeforeTest
    @Parameters({"browser","DURATION"})
    public void launchBrowser(String param,String param2)
    {

        //DRIVER'IMIZIN TYPE'I PARAMETER OLARAK GONDERILDI VE DRIVER OLUSTURULDU
        DriverClass.getDriver(param);

        //WAIT AYARLARI YAPILDI
        //testlerimize baslamadan once genellikle before methodlarinda waitlerimizin ayarlarini yazariz
        DriverClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(param2)));
        DriverClass.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(param2)));

    }




    @AfterTest
    public void tearDown() {

        DriverClass.closeDriver();
    }





}