package com.testng.assertions.hardAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assertion02
{
    private static WebDriver driver;
    WebElement searchBar;


    @Test
    void assertSame()
    {
        //JAVA BILGISI: String Pool Bellek Calisma mantigi
        String str1 = "hello";
        String str2 = "world";
        String str3 = "hello";

        Assert.assertSame(str1, str3); // passes
        Assert.assertSame(str1, str2); // fails
    }

    @Test
    void assertNullKullanimi()
    {

        driver=WebDriverManager.chromedriver().create();
        driver.get("https://www.google.com");
        searchBar=driver.findElement(By.name("q"));
        String olmayanAttribute=searchBar.getAttribute("boyleBirTagYok");// null
        Assert.assertNull(olmayanAttribute,"Boyl bir attribute sahip degil webElementimiz. Bu yuzden null sonuc bekliyoruz");
    }

}
