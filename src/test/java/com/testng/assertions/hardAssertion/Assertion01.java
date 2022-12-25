package com.testng.assertions.hardAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Assertion01
{
    private static WebDriver driver;//null

    @BeforeMethod
    void setUp()
    {
        driver=WebDriverManager.chromedriver().create();
        driver.get("https://www.google.com");
    }
    @Test
    void method01()
    {
        //TESTING=> BEKLENILEN SONUC ILE GERCEK SONUCUN KARSILASTIRILMASI
        String expectedTitle="google";
        String actualTitle=driver.getTitle();

        //JAVA BILGISI: OVERLOADED METHODLAR
        //Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle,"Expected title is NOT matching to actual title");

        Assert.assertTrue(expectedTitle.equals(actualTitle));
        Assert.assertTrue(expectedTitle.equals(actualTitle),"Expected title is NOT matching to actual title");

    }

    @Test
    void method02()
    {
        String expectedTitle="firefox";
        String actualTitle=driver.getTitle();

        Assert.assertNotEquals(actualTitle,expectedTitle);
        Assert.assertNotEquals(actualTitle,expectedTitle,"Expected title is matching to actual title");

        Assert.assertFalse(expectedTitle.equals(actualTitle));
        Assert.assertFalse(expectedTitle.equals(actualTitle),"Expected title is matching to actual title");

    }


    @Test
    public void method03() throws MalformedURLException
    {
        URL url = new URL("https://www.chapters.indigo.ca/en-ca/");

        try
        {
            driver.navigate().to(url);
            WebElement popUpCloseButton=driver.findElement(By.xpath("//button[@class=\"browsepopup-closebtn\"]"));
            popUpCloseButton.click();


        }
        catch (Exception e) //try block'ta herhangi bir Exception cikarsa catch edelim
        {
            //Overloaded fail() methodlari
            //Assert.fail();
            //Assert.fail("Selenium locator kullanimi dogru ama site performansindan dolayi pop up gec yuklendi");

            NoSuchElementException exception=new NoSuchElementException("PopUp is not shown up immediately!");
            Assert.fail("Selenium locator kullanimi dogru ama site performansindan dolayi element gec yuklendi",exception);

        }
    }

    @Test
    public void method04() throws MalformedURLException
    {
        URL url = new URL("https://www.chapters.indigo.ca/en-ca/");

        try
        {
            driver.navigate().to(url);

            //Asagidaki satirda hata firlatilirsa assertThrows() bunu hem catch eder hem de assert eder
            Assert.assertThrows(NoSuchElementException.class,()->driver.findElement(By.xpath("//button[@class=\"browsepopup-closebtn\"]")));

        }
        catch (Exception e)
        {
            Assert.fail();
        }
    }
}
