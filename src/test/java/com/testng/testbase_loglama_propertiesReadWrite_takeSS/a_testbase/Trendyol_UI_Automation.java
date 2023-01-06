package com.testng.testbase_loglama_propertiesReadWrite_takeSS.a_testbase;

//DRIVER OLUSUMU ICIN
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.z_driver.DriverClass.getDriver;

//@BEFORECLASS @AFTERCLASS YONETIMI ICIN
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.a_testbase.testbase_paramsFromTestSuite.TestNG_TestBase_ForMultipleBrowsers01;

//SELENIUM CLASSES/METHODS ICIN
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//TESTNG ANNOTATIONS+METHODS ICIN
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Trendyol_UI_Automation extends TestNG_TestBase_ForMultipleBrowsers01
{
    //TESTCASE01
        //CHROME A GIT
        //TRENDYOLA GIT
        //LOGIN OL
        //LOGIN BILGILERININ KULLANICI SAYFASINDA DOGRU BIR SEKILDE GOZUKUP GOZUKMEDIGINE BAK
        //LOGOFF
        //BROWSER'I KAPAT




    @Test
    @Parameters({"URL","country","expectedTitle"})
    public static void navigateToURL(String URL, String country,String expectedTitle)
    {


        //URL'YE NAVIGATE ET
        getDriver().get(URL);

        //YURTDISINDA OLANLARIN ONUNE EK BIR ISLEM CIKIYOR- DROPDOWN'DAN ULKE SELECT YAP
        WebElement countryDropDown = getDriver().findElement(By.xpath("//div[@class='country-select']//select"));
        Select select =new Select(countryDropDown);
        select.selectByVisibleText(country);


        //SELECT BUTTON'UNU CLICK YAP
        WebElement countrySelectButton= getDriver().findElement(By.xpath("//button[text()=\"Select\"]"));
        countrySelectButton.click();

        //ASSERTION YAP
        String actualPageTitle = getDriver().getTitle();
        Assert.assertEquals(actualPageTitle,expectedTitle);
    }



}
