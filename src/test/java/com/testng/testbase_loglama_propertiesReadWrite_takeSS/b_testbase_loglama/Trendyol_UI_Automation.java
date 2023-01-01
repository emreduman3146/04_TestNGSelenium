package com.testng.testbase_loglama_propertiesReadWrite_takeSS.b_testbase_loglama;

//DRIVER OLUSUMU ICIN
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.driver.DriverClass.getDriver;

//@BEFORECLASS @AFTERCLASS YONETIMI ICIN
import com.testng.testbase_loglama_propertiesReadWrite_takeSS.b_testbase_loglama.testbase_paramsFromTestSuite.TestNG_TestBase_ForMultipleBrowsers;

//SELENIUM CLASSES/METHODS ICIN
import logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

//TESTNG ANNOTATIONS+METHODS ICIN
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Trendyol_UI_Automation extends TestNG_TestBase_ForMultipleBrowsers
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
            Logger.info("Navigated to "+URL+" successfully");


            //YURTDISINDA OLANLARIN ONUNE EK BIR ISLEM CIKIYOR- DROPDOWN'DAN ULKE SELECT YAP
            WebElement countryDropDown = getDriver().findElement(By.xpath("//div[@class='country-select']//select"));
            Select select =new Select(countryDropDown);
            select.selectByVisibleText(country);


            //SELECT BUTTON'UNU CLICK YAP
            WebElement countrySelectButton= getDriver().findElement(By.xpath("//button[text()=\"Select\"]"));
            countrySelectButton.click();

            Logger.info("Country-> "+country+" selected.");


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

    @Parameters({"email","password"})
    public void loginTheAccount(@Optional("abc@gmail.com") String email, String password)
    {

        try
        {
            //GIRIS YAP LINKININ UZERINE HOVER OVER YAP
            WebElement girisYapLinkText=getDriver().findElement(By.xpath("//p[text()='Giriş Yap']"));
            actions.moveToElement(girisYapLinkText).perform();

            //ACIGA CIKAN GIRIS YAP BUTTONUNA CLICK YAP
            WebElement girisYapButonu=getDriver().findElement(By.xpath("//div[@class='login-button']"));
            girisYapButonu.click();

            //TURUNCU GIRIS YAP BUTTONU DISPLAYED MI ASSERT ET
            WebElement girisFormuGirisYapButonu=getDriver().findElement(By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']//span[text()='Giriş Yap']"));
            Assert.assertTrue(girisFormuGirisYapButonu.isDisplayed());

            Logger.info("girisYapButonu is clicked and girisFormuGirisYapButonu verified if it is displayed!!!");


            //EMAIL TEXTBOX'INA TESTSUITE'DEN GELEN PARAM'I GIR
            WebElement girisFormuEmailTextBox=getDriver().findElement(By.id("login-email"));
            girisFormuEmailTextBox.sendKeys(email);

            //PASSWORD TEXTBOX'INA TESTSUITE'DEN GELEN PARAM'I GIR
            WebElement girisFormuSifreTextBox=getDriver().findElement(By.id("login-password-input"));
            girisFormuSifreTextBox.sendKeys(password);

            //GEREKLI BILGILER GIRILDIKTEN SONRA SUBMIT ET
            girisFormuSifreTextBox.submit();

            Logger.info("Email-Password has been sent and login page is submitted!");


            //HESABIM LINKI MEVCUT OLANA KADAR BEKLE -SONRA HOVER OVER YAP
            WebElement hesabim=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Hesabım')]")));
            actions.moveToElement(hesabim).perform();

            WebElement username=getDriver().findElement(By.xpath("//p[@class='user-name']"));
            Assert.assertEquals(username.getText().toLowerCase(),email,"Username in the user page is not matching to email address used for login!!!");

            Logger.info("VERIFIED THAT IF THE EMAIL IS MATCHING TO USERNAME IN THE USER PAGE!");
            Logger.info("actualUsername = " + username.getText());
            Logger.info("expectedUsername = " + email);

        }
        catch (Exception exception)
        {
            Logger.error("Test is failed due to -> "+exception.getMessage());
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
            WebElement cikisYapButonu=getDriver().findElement(By.xpath("//p[text()='Çıkış Yap']"));
            cikisYapButonu.click();
            Logger.info("CLICKED cikisYapButonu!");


            //DO ASSERTION FOR girisYapButonu  - BU WEB ELEMENTI 2 KEZ LOCATE ETTIK, DEMEKKI KOTU KOD YAZIYORUZ.
            WebElement girisYapLinkText=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Giriş Yap']")));
            Assert.assertTrue(girisYapLinkText.isDisplayed());


            Logger.info("VERIFIED girisYapLinki TO MAKE SURE LOGOFF PROCESSED AS EXPECTED!");

        }
        catch (Exception exception)
        {
            Logger.error("Test is failed due to -> "+exception.getMessage());
        }



    }



}
