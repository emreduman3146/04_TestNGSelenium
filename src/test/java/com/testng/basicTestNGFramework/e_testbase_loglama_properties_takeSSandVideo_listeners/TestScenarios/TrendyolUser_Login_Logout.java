package com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.TestScenarios;


import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.TakeScreenShotsUtil;
import com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.testbase.TestNG_TestBase_ForMultipleBrowsers05;
import logger.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.Constants.SCREENSHOTS_PATH;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.ObjectUtil.*;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.TakeScreenShotsUtil.takeScreenshot;
import static com.testng.basicTestNGFramework.e_testbase_loglama_properties_takeSSandVideo_listeners.utilities.WebElementUtil.getWebElement;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.getDriver;

public class TrendyolUser_Login_Logout extends TestNG_TestBase_ForMultipleBrowsers05
{


    @Test(
            testName = "Navigate to Homepage",
            description = "Select a country and navigate to Trendyol Homepage and assert pageTitle"
    )
    @Parameters({"URL","country","expectedTitle"})
    public void navigateToURL(String URL, String country, String expectedTitle)
    {

        try
        {
            //URL'YE NAVIGATE ET
            getDriver().get(URL);
            TakeScreenShotsUtil.takeScreenshot(getDriver(), SCREENSHOTS_PATH,"CountrySelectPage",false,false,"");//can throw exception


            //YURTDISINDA OLANLARIN ONUNE EK BIR ISLEM CIKIYOR- DROPDOWN'DAN ULKE SELECT YAP
            WebElement countryDropDown = getWebElement("countryDropDown");//static methodtur. static import ile erisim sagladik.
            Select select =new Select(countryDropDown);
            select.selectByVisibleText(country);
            takeScreenshot(getDriver(), SCREENSHOTS_PATH,webElementName,false,true,webElementName);//can throw exception


            //SELECT BUTTON'UNU CLICK YAP
            WebElement countrySelectButton=getWebElement("countrySelectButton");
            countrySelectButton.click();

            Logger.info("Country-> "+country+" selected and Navigated to"+URL+" successfully");


            //ASSERTION YAP
            String actualPageTitle = getDriver().getTitle();
            Assert.assertEquals(actualPageTitle,expectedTitle,"Page title assertion is failed!");

            Logger.info("actualPageTitle = " + actualPageTitle);
            Logger.info("expectedTitle = " + expectedTitle);

        }
        catch (Exception exception)
        {
            Logger.error("Test is failed due to -> "+exception.getMessage());
            Assert.fail();
        }

    }


    @Test(  priority = 1,
            testName = "Log in the Account",
            description = "Click on girisYap Button and send the email-password and submit"
    )
    @Parameters({"email","password","DURATION"})
    public void loginTheAccount(@Optional("abc@gmail.com") String email, String password,String duration)
    {

        try
        {
            //GIRIS YAP LINKININ UZERINE HOVER OVER YAP
            WebElement girisYapLinkText=getWebElement("girisYapLinkText");
            actions.moveToElement(girisYapLinkText).perform();


            //ACIGA CIKAN GIRIS YAP BUTTONUNA CLICK YAP
            WebElement girisYapButonu=getWebElement("girisYapButonu");
            takeScreenshot(getDriver(), SCREENSHOTS_PATH,webElementName,false,true,webElementName);
            actions.pause(1000).click(girisYapButonu).perform();


            //TURUNCU GIRIS YAP BUTTONU DISPLAYED MI ASSERT ET
            WebElement girisFormuGirisYapButonu=getWebElement("girisFormuGirisYapButonu");
            Assert.assertTrue(girisFormuGirisYapButonu.isDisplayed());

            Logger.info("girisYapButonu is clicked and girisFormuGirisYapButonu verified if it is displayed!!!");


            //EMAIL TEXTBOX'INA TESTSUITE'DEN GELEN PARAM'I GIR
            WebElement girisFormuEmailTextBox=getWebElement("girisFormuEmailTextBox");
            girisFormuEmailTextBox.sendKeys(email);

            //PASSWORD TEXTBOX'INA TESTSUITE'DEN GELEN PARAM'I GIR
            WebElement girisFormuSifreTextBox=getWebElement("girisFormuSifreTextBox");
            girisFormuSifreTextBox.sendKeys(password);

            wait.until(ExpectedConditions.elementToBeClickable(girisFormuGirisYapButonu));
            Thread.sleep(2000);
            takeScreenshot(getDriver(), SCREENSHOTS_PATH,webElementName,false,false,"");

            girisFormuGirisYapButonu.click();

            Logger.info("Email-Password has been sent and login page is submitted!");
            Thread.sleep(2000);
            takeScreenshot(getDriver(), SCREENSHOTS_PATH,webElementName,true,false,"");


            //HESABIM LINKI MEVCUT OLANA KADAR BEKLE -SONRA HOVER OVER YAP
            WebElement hesabim=wait.until(ExpectedConditions.visibilityOf(getWebElement("hesabim")));
            actions.pause(1000).moveToElement(hesabim).perform();
            WebElement username=getWebElement("username");
            Assert.assertEquals(username.getText(),email,"Username in the user page is not matching to email address used for login!!!");

            Logger.info("VERIFIED THAT IF THE EMAIL IS MATCHING TO USERNAME IN THE USER PAGE!");
            Logger.info("actualUsername = " + username.getText());
            Logger.info("expectedUsername = " + email);


        }
        catch (Exception exception)
        {
            Logger.error("Test is failed due to -> "+exception);
            Assert.fail();

        }



    }


    @Test(  priority = 2,
            testName = "Log off the Account",
            description = "Click on cikisYapButonu Button and close driver!"
    )
    public void logoffTheAccount()
    {
        try
        {
            //CLICK ON cikisYapButonu BUTTON
            WebElement cikisYapButonu=getWebElement("cikisYapButonu");
            cikisYapButonu.click();
            Logger.info("CLICKED cikisYapButonu!");


            //DO ASSERTION FOR girisYapButonu  - BU WEB ELEMENTI 2 KEZ LOCATE ETTIK, DEMEKKI KOTU KOD YAZIYORUZ.
            WebElement girisYapLinkText=wait.until(ExpectedConditions.elementToBeClickable(getWebElement("girisYapLinkTextTTTTTTTTT")));
            Assert.assertTrue(girisYapLinkText.isDisplayed());
            Logger.info("VERIFIED girisYapLinki TO MAKE SURE LOGOFF PROCESSED AS EXPECTED!");

        }
        catch (Exception exception)
        {
            Logger.error("Test is failed due to -> "+exception);
            Assert.fail();//TESTNG HATASI FIRLATIRIM

        }
    }


}
