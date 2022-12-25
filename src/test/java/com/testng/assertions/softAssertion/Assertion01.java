package com.testng.assertions.softAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class Assertion01
{
    //DECLARATIONS
    private static WebDriver driver;
    SoftAssert softAssert;


    @BeforeClass
    void setUpForClass()
    {
        softAssert=new SoftAssert();
    }

    @BeforeMethod
    void setUp()
    {
        driver=WebDriverManager.chromedriver().create();
        driver.get("https://www.google.com");
    }
    @Test
    void method01()
    {
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();

        softAssert.assertEquals(actualTitle,expectedTitle);//pass

        expectedTitle="Googleee";

        softAssert.assertEquals(expectedTitle,actualTitle,"Expected title is not matching to actual title");

        softAssert.assertTrue(expectedTitle.equals(actualTitle));
        softAssert.assertTrue(expectedTitle.equals(actualTitle),"Expected title is not matching to actual title");

        System.out.println("method01() bitti !!!" );
    }

    @Test
    void method02()
    {
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();

        softAssert.assertNotEquals(expectedTitle,actualTitle);
        softAssert.assertNotEquals(expectedTitle,actualTitle,"Expected title is matching to actual title");

        softAssert.assertFalse(expectedTitle.equals(actualTitle));
        softAssert.assertFalse(expectedTitle.equals(actualTitle),"Expected title is matching to actual title");

    }


    @Test
    public void method03() throws MalformedURLException
    {
        URL url = new URL("https://www.chapters.indigo.ca/en-ca/");

        try
        {
            driver.navigate().to(url);
            WebElement popUpCloseButton=driver.findElement(By.xpath("//button[@class=\"browsepopup-closebtnn\"]"));
            popUpCloseButton.click();


        }
        catch (Exception e) //try block'ta herhangi bir Exception cikarsa catch edelim
        {
            //Overloaded fail() methodlari
            //Assert.fail();
            //Assert.fail("Selenium locator kullanimi dogru ama site performansindan dolayi element gec yuklendi");

            NoSuchElementException exception=new NoSuchElementException("PopUp is not shown up immediately!");
            softAssert.fail("Selenium locator kullanimi dogru ama site performansindan dolayi element gec yuklendi",exception);

        }
    }

    @AfterMethod
    void afterMethod()
    {
        //test kosarken yaptigim tum soft assertlerin sonucu program bittikten sonra ban goster
        softAssert.assertAll();
    }

}
