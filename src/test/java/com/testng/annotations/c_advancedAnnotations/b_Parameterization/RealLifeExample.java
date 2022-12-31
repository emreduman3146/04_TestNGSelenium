package com.testng.annotations.c_advancedAnnotations.b_Parameterization;

import com.testng.annotations.b_annotations.txtFiledanVeriOkuma.MyConstantsNameIsWrongException;
import com.testng.annotations.b_annotations.txtFiledanVeriOkuma.MyTestDataNameIsWrongException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;



public class RealLifeExample
{
    //TEST CASE01
    //TEST STEP1 Indigoya git
    //TEST STEP2 arama motoruna The Analyst by John Katzenbach (kitap ve yazarin adini) gir
    //TEST STEP3 ilk sirada THE ANALYST: A NOVEL kitap ismi olmali

    static WebDriver driver;//null

    @BeforeClass
    @Parameters({"browser","DURATION"})
    void launchBrowser(String param,String param2) throws MyConstantsNameIsWrongException, MyTestDataNameIsWrongException, InterruptedException {

        switch (param)
        {
            case "chrome":
                ChromeOptions option1=new ChromeOptions();
                option1.addArguments("--start-maximized");
                driver= WebDriverManager.chromedriver().avoidShutdownHook().capabilities(option1).create();break;
            case "firefox":
                driver= new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions option3=new EdgeOptions();
                option3.addArguments("--start-maximized");
                driver= new EdgeDriver(option3);;break;
        }

        //testlerimize baslamadan once genellikle before methodlarinda waitlerimizin ayarlarini yazariz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(param2)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(param2)));

        Thread.sleep(1000);
    }


    @Test
    @Parameters({"URL","homePageTitle"})
    public void launchChromeBrowser_and_navigateToTheUrl(String param,String param2) throws InterruptedException {
        try
        {
            System.out.println("STEP1-launchChromeBrowser_and_navigateToTheUrl step Initialized");

            driver.get(param);//value:URL adresi

            //SOFT ASSERT-> VERIFICATION YAPILIYOR
            Assert.assertTrue(driver.getTitle().startsWith(param2));

            System.out.println("STEP1 -launchChromeBrowser_and_navigateToTheUrl has done!");

        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("STEP1'DE HATA OLUSMUSTUR!");
        }
        Thread.sleep(1000);


    }


    @Test( priority = 1)
    @Parameters({"aratilanKitap","kitapIsmi"})
    public void searchForTheBook_inIndigo(String param,String param2) throws InterruptedException {
        try
        {
            System.out.println("STEP2-searchForTheBook_inIndigo Initialized");

            //POPUP KAPATILDI
            driver.findElement(By.xpath("//button[@class='browsepopup-closebtn']")).click();

            //KITABIN ISMINI GIR
            WebElement searchBar=driver.findElement(By.name("SearchBoxKeywords"));
            searchBar.sendKeys(param);

            //ENTER TUSUNA BAS - getDriver().sendKeys(Keys.ENTER);
            Actions actions=new Actions(driver);
            actions.moveToElement(searchBar).doubleClick().sendKeys(Keys.ENTER).build().perform();


            //VERIFICATION YAPILIYOR- SOFT ASSERTION
            Assert.assertEquals(driver.findElement(By.xpath("//a[@class='product-list__product-title'])[1]")).getText(),param2,"Kitap ismi eslesmiyor");

            System.out.println("STEP2-searchForTheBook_inIndigo has done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("STEP2'DE HATA OLUSMUSTUR!");
        }

        Thread.sleep(1000);

    }


}
