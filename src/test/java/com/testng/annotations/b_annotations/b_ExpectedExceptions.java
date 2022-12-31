package com.testng.annotations.b_annotations;

import com.testng.annotations.b_annotations.txtFiledanVeriOkuma.MyConstantsNameIsWrongException;
import com.testng.annotations.b_annotations.txtFiledanVeriOkuma.MyTestDataNameIsWrongException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.testng.driver.Driver.getDriver;
import static com.testng.annotations.b_annotations.txtFiledanVeriOkuma.TxtOkuma.getValueFromTxtFile;

public class b_ExpectedExceptions
{

    /*
        TestNG'de @Test anotasyonunun expectedExceptions parametresi,
        bir test metodunun atması beklenen istisna listesini belirtmek için kullanılır.

        Test metodu başka bir istisna atarsa veya hiçbir istisna atmazsa,
        test bir başarısızlık olarak değerlendirilecektir.
     */


    SoftAssert sa;

    @BeforeClass
    void assertionSetup()
    {
        sa = new SoftAssert();
    }


    @Test(
            expectedExceptions =
                    {
                            MyConstantsNameIsWrongException.class,
                            MyTestDataNameIsWrongException.class
                    }
            ,expectedExceptionsMessageRegExp = "Searched constant is not found!"

    )
    public void launchChromeBrowser_and_navigateToTheUrl() throws MyConstantsNameIsWrongException, MyTestDataNameIsWrongException {


        System.out.println("STEP1-launchChromeBrowser_and_navigateToTheUrl step Initialized");


        String value=getValueFromTxtFile("Constants","URL");
        getDriver().get(value);//value:URL adresi

        //SOFT ASSERT-> VERIFICATION YAPILIYOR
        sa.assertTrue(getDriver().getTitle().startsWith(getValueFromTxtFile("TestData","homePageTitle")));

        System.out.println("STEP1 -launchChromeBrowser_and_navigateToTheUrl has done!");

    }



    @Test
    (
        expectedExceptions =
        {
            //MyConstantsNameIsWrongException.class
            MyTestDataNameIsWrongException.class,
        }
        ,expectedExceptionsMessageRegExp = "Searched data is not found!"
    )
    public void test02() throws MyConstantsNameIsWrongException, MyTestDataNameIsWrongException
    {
        String value=getValueFromTxtFile("TestData","homePageTitleee");
        getDriver().get(value);//value:URL adresi

    }

}
