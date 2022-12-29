package com.testng.annotations.b_annotations.txtFiledanVeriOkuma;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.testng.annotations.b_annotations.driver.Driver.getDriver;

public class TxtOkuma
{

    private static String currentDirectory = System.getProperty("user.dir");
    //C:\Users\Emre Duman\IdeaProjects\FullStack_WebAutomation_TestingBootcamp\TestNGFramework


    private static String txtFilePath;

    //TESTDATA VE CONSTANT OKUMAK ICIN
    public static String getValueFromTxtFile(String fileName, String expectedDataName) throws MyTestDataNameIsWrongException, MyConstantsNameIsWrongException {
        boolean testdataIsmiMevcut =false;
        boolean sabitDegerIsmiMevcut =false;

        txtFilePath=currentDirectory+"\\b_txtFiles\\"+fileName+".txt";//dynamic coding


        String dataName;
        String dataValue = null;

        try
        {
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine())//pathini bulundurdugum file'in icindeki satirda bir deger var mi?
            {
                //siradaki tum satiri getir
                String data = myReader.nextLine();

                //eger satir '=' char'ini icermiyorsa bu while lopp'un bu donguunu atla/es gec
                if(!data.contains("="))
                    continue;

                //satirdaki ifadeyi '=' isaretinden 2'ye bol ve Array'in icine depola
                String [] dataName_dataValue=data.split("=");

                //JAVA BILGISI STRING CLASSI METHODLARI
                dataName=dataName_dataValue[0].trim();
                dataValue=dataName_dataValue[1].trim();

                if(expectedDataName.equalsIgnoreCase(dataName))
                {
                    testdataIsmiMevcut=true;
                    sabitDegerIsmiMevcut=true;
                    break;//WHILE LOOPTAN CIKILACAK
                }

            }

            myReader.close();//ICERISINDE While loop ile gezdigimiz txt file'dan cikis yapildi

            //aranan data bulunamadiysa hata firlat
            if(!testdataIsmiMevcut)
                throw new MyTestDataNameIsWrongException("Searched data is not found!");

            //aranan sabit bulunamadiysa hata firlat
            if(!sabitDegerIsmiMevcut)
                throw new MyConstantsNameIsWrongException("Searched constant is not found!");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File name is not found!");
            e.printStackTrace();
        }

        return dataValue;

    }


    //WEBELEMENT OKUMAK ICIN
    public static WebElement getWebElement(String elementName) throws MyWebElementNameIsWrongException,NoSuchElementException {
        String webElementName;
        String locatorType=null;
        String locator = null;
        boolean elementIsmiMevcut=false;

        txtFilePath=currentDirectory+"\\b_txtFiles\\"+"WebElements.txt";//hardcoding terminology


        try
        {
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                //tum satiri getir
                String data = myReader.nextLine();

                //eger satir '=' char'ini icermiyorsa bu while lopp'un bu donguunu atla/es gec
                if(!data.contains("->"))
                    continue;

                //satirdaki ifadeyi '->' isaretinden 3'e bol ve Array'in icine depola
                String[] webElementName_type_Locator = data.split("->");

                //webElementName basindaki ve sonundaki bosluklari sil
                webElementName = webElementName_type_Locator[0].trim();

                if (elementName.equalsIgnoreCase(webElementName))
                {
                    elementIsmiMevcut = true;
                    locatorType = webElementName_type_Locator[1].trim();
                    locator = webElementName_type_Locator[2].trim();
                    break;
                }

            }
            //txt file'i kapat
            myReader.close();

            //aranan element bulunamadiysa hata firlat
            if(!elementIsmiMevcut)
                throw new MyWebElementNameIsWrongException("Given WebElement Name Is not Available");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("WebElementlerin saklandigi dosya bulunamadi!");
            e.printStackTrace();
        }


        //Elimizdeki locatorTipi ve locator ile webElement olusturmaya geldi sira
        WebElement element=generateWebElement(locatorType,locator);

        //olusturulan webElementi return et
        return element;

    }


    //WEBELEMENT OLUSTURMA
    private static WebElement generateWebElement(String locatorType, String locator) throws NoSuchElementException {
        WebElement element = null;

        switch (locatorType)
        {
            case "xpath": element=getDriver().findElement(By.xpath(locator));break;
            case "cssSelector": element=getDriver().findElement(By.cssSelector(locator));break;
            case "name": element=getDriver().findElement(By.name(locator));break;
            case "id": element=getDriver().findElement(By.id(locator));break;
            case "className": element=getDriver().findElement(By.className(locator));break;
            case "tagName": element=getDriver().findElement(By.tagName(locator));break;
            case "linkText":element= getDriver().findElement(By.linkText(locator));break;
            case "partialLinkText": element=getDriver().findElement(By.partialLinkText(locator));break;
        }

        return element;
    }
}
