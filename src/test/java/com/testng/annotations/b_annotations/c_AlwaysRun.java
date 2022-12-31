package com.testng.annotations.b_annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class c_AlwaysRun
{

    @Test(//priority = 2
             )
    public void testSetup() {
        System.out.println("Test1");
        Assert.fail("Bilerek bu @Testi fail ettiriyorum");
        Assert.assertTrue(false);
        System.out.println("Assertion fail verdikten sonraki kodlarim");

    }



    @Test(  //priority = 1,
            dependsOnMethods = "testSetup",//testSetup isimli @Test methodu calismadan ben calismam
            alwaysRun = true//BAGIMLI OLDUGUM @TESTmethodu fail olsa bile beni calistir
    )
    public void testFeature() {
        System.out.println("Test2");
    }


    //EGER BIR @TEST METHODUNUN BAGIMLI OLDUGU @TESTIN ICINDE FAIL ALINIRSA @TESTIN KENDISI DE CALISTIRILMAZ

}
