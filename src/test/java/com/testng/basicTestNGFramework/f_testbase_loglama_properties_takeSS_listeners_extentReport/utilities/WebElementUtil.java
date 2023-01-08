package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil.webElementName;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.PropertiesReadWrite.getProperty;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.getDriver;

public class WebElementUtil
{

    public static WebElement getWebElement(String webElementAdi) throws NoSuchElementException
    {
        webElementName=webElementAdi;

        return generateWebElement( getWebElementDetailsInArray(webElementAdi) );
    }


    //.properties file'indan get edilen value'nun bir String Array'e atanma islemini yapan methodtur
    private static String[] getWebElementDetailsInArray(String key)
    {

        String[] locaterType_Value = getProperty(key).split(",",2);
        return locaterType_Value;
        // [ {xpath},  { //p[contains(text(),'Hesabım')] } ]   2 ELEMANLI ARRAY
    }


    //WEBELEMENT OLUSTURMA
    private static WebElement generateWebElement(String[] locatorType_value) throws NoSuchElementException
    {
        WebElement element = null;
        String locatorType=locatorType_value[0].trim();//trim() ile locatorType'in basindaki ve sonundaki bosluklari sil ve String'e atama yap
        String value=locatorType_value[1].trim();

        switch (locatorType)
        {
            case "xpath": element=getDriver().findElement(By.xpath(value));break;
            case "cssSelector": element=getDriver().findElement(By.cssSelector(value));break;
            case "name": element=getDriver().findElement(By.name(value));break;
            case "id": element=getDriver().findElement(By.id(value));break;
            case "className": element=getDriver().findElement(By.className(value));break;
            case "tagName": element=getDriver().findElement(By.tagName(value));break;
            case "linkText":element= getDriver().findElement(By.linkText(value));break;
            case "partialLinkText": element=getDriver().findElement(By.partialLinkText(value));break;
        }

        return element;
    }
}
