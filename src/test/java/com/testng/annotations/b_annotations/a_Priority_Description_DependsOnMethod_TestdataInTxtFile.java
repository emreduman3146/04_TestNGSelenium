package com.testng.annotations.b_annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.testng.annotations.b_annotations.driver.Driver.getDriver;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getValueFromTxtFile;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getWebElement;

//JAVA +SELENIUM +TESTNG+INTELLIJ+MAVEN ILE AUTOMATION TESTING YAPIYORUZ
public class a_Priority_Description_DependsOnMethod_TestdataInTxtFile
{
    //TEST CASE01
        //TEST STEP1 Indigoya git
        //TEST STEP2 arama motoruna The Analyst by John Katzenbach (kitap ve yazarin adini) gir
        //TEST STEP3 ilk sirada THE ANALYST: A NOVEL kitap ismi olmali

    private static WebDriver driver;
    SoftAssert sa;


    @BeforeClass
    void assertionSetup()
    {
        sa = new SoftAssert();
    }


    @Test( priority =1,
            description = "Indigo Sitesine Git")
    public void launchChromeBrowser_and_navigateToTheUrl()
    {
        try
        {
            System.out.println("STEP1-launchChromeBrowser_and_navigateToTheUrl step Initialized");

            String value=getValueFromTxtFile("Constants","URL");
            getDriver().get(value);//value:URL adresi

            //SOFT ASSERT-> VERIFICATION YAPILIYOR
            sa.assertTrue(getDriver().getTitle().startsWith(getValueFromTxtFile("TestData","homePageTitle")));

            System.out.println("STEP1 -launchChromeBrowser_and_navigateToTheUrl has done!");

        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("STEP1'DE HATA OLUSMUSTUR!");

            //EGER ILK STEP'TE EXCEPTION ALINDIYSA HARD ASSERT ILE TEST'I SONLANDIR
            Assert.fail();

        }

    }


    @Test( priority = 2,
            //dependsOnMethods = "launchChromeBrowser_and_navigateToTheUrl",
            description = "Arama motoruna kitap ismi girilip enter'a basiliyor ve ardindan kitap ismi verify ediliyor")
    public void searchForTheBook_inIndigo() {
        try
        {

            System.out.println("STEP2-searchForTheBook_inIndigo Initialized");

            //WAIT FOR POPUP, IMPLICITLY
            //JAVA BILGISI STRING->INTEGER CASTING
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getValueFromTxtFile("Constants","DURATION"))));

            //POPUP KAPATILDI
            //getDriver().findElement(By.xpath("......")).click();

            getWebElement("stayInTheKnowPopUpClose_button").click();

            //KITABIN ISMINI GIR

            getWebElement("searchBar_textBox").sendKeys(getValueFromTxtFile("TestData","aratilanKitap"));

            //ENTER TUSUNA BAS - getDriver().sendKeys(Keys.ENTER);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            //VERIFICATION YAPILIYOR- SOFT ASSERTION
            sa.assertEquals(getWebElement("ilkUrun").getText(),getValueFromTxtFile("TestData","kitapIsmi"),"Kitap ismi eslesmiyor");

            System.out.println("STEP2-searchForTheBook_inIndigo has done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("STEP2'DE HATA OLUSMUSTUR!");
        }
    }

    @AfterClass
    void afterClass()
    {
        sa.assertAll();
    }

}
