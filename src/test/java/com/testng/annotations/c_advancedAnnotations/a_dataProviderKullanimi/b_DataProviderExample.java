package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.testng.driver.Driver.getDriver;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getValueFromTxtFile;

public class b_DataProviderExample
{

    SoftAssert sa;

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){

        Object [][] arrayim=new Object[][]
        {//.1boyut
                {"https://www.chapters.indigo.ca/en-ca/","Canada's Biggest Bookstore:"}//2.boyut = 1.LOOP
        };

        return arrayim;
    }



    @BeforeClass
    void assertionSetup()
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7000));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

        sa = new SoftAssert();
    }




    @Test( dataProvider = "test-data")
    public void launchChromeBrowser_and_navigateToTheUrl(String param1, String param2)
    {
        try
        {
            System.out.println("STEP1-launchChromeBrowser_and_navigateToTheUrl step Initialized");

            String value=param1;
            getDriver().get(value);//value:URL adresi

            //SOFT ASSERT-> VERIFICATION YAPILIYOR
            sa.assertTrue(getDriver().getTitle().startsWith(param2));

            System.out.println("STEP1 -launchChromeBrowser_and_navigateToTheUrl has done!");

        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("STEP1'DE HATA OLUSMUSTUR!");

            //EGER ILK STEP'TE EXCEPTION ALINDIYSA HARD ASSERT ILE TEST'I SONLANDIR
            Assert.fail();

        }

    }







}
