package com.testng.annotations.b_annotations.txtFiledanVeriOkuma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.testng.driver.Driver.getDriver;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getValueFromTxtFile;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getWebElement;

//JAVA +SELENIUM +TESTNG+INTELLIJ+MAVEN ILE AUTOMATION TESTING YAPIYORUZ
public class a_Priority_Description_DependsOnMethod_TestdataInTxtFile
{
    //TEST CASE01
        //TEST STEP1 Indigoya git
        //TEST STEP2 arama motoruna The Analyst by John Katzenbach (kitap ve yazarin adini) gir
        //TEST STEP3 ilk sirada THE ANALYST: A NOVEL kitap ismi olmali

    static SoftAssert sa;
    static WebDriverWait wait;


    @BeforeClass
    void assertionSetup()
    {
        //WEBDRIVERWAIT YA DA FLUENTWAIT ISE WEBELEMENTE OZGU BEKLEME CESIDI IDI
        //Exclicitly wait boyle tanimlanir ama kullanmaya gelince birebir kodlariin arasinda kullanilir
        wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));

        //WAIT AYARI YAPILIYOR -
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7000));//BURADA YAZDIGIM AYAR PROJEMIN HER SATIRIN UYGULANIR
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));//Herhabgi bir webelementin yukelnemsini 7 sn. ye kadar bekle

        sa = new SoftAssert();
    }


    @Test( priority =1,
            description = "Indigo Sitesine Git"
           //timeOut = 6000
    )
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


    @Ignore//junit5.9'da da var
    @Test( priority = 2,
            enabled = true, // false bu method calismaz
            //dependsOnMethods = "launchChromeBrowser_and_navigateToTheUrl",
            description = "Arama motoruna kitap ismi girilip enter'a basiliyor ve ardindan kitap ismi verify ediliyor")
    public void searchForTheBook_inIndigo() {
        try
        {

            System.out.println("STEP2-searchForTheBook_inIndigo Initialized");

            getWebElement("stayInTheKnowPopUpClose_button").click();

            //KITABIN ISMINI GIR
            WebElement searchBar=getWebElement("searchBar_textBox");
            searchBar.sendKeys(getValueFromTxtFile("TestData","aratilanKitap"));

            //ENTER TUSUNA BAS - getDriver().sendKeys(Keys.ENTER);
            Actions actions=new Actions(getDriver());
            actions.moveToElement(searchBar).doubleClick().sendKeys(Keys.ENTER).build().perform();

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


    /*
    timeout=3000
    belirtilen 3000 milisaniye (3 saniye) zaman aşımı süresini aştığı için başarısız olacaktır.
    Zaman aşımını milisaniye cinsinden @Test anotasyonuna belirtebilirsiniz.



    Ayrıca, tüm test sınıfı için de bir zaman aşımı belirleyebilirsiniz.
    Bunu yapmak için, @Test(timeOut = 10000) anotasyonunu spesifik bir test yöntemi yerine sınıfın kendine uygulayın.
    Bu, belirtilen zaman aşımı süresini aşan tüm test yöntemlerinin başarısızlıkla sonuçlanmasına neden olacaktır.
     */

}
