package com.testng.annotations.a_basicAnnotations;

import org.testng.annotations.*;

public class IkinciTest

{

    @BeforeTest
    public static void BeforeTest()
    {
        System.out.println("Test02->Database connectivity set up");
    }


    @BeforeMethod
    public static void BeforeMethod()
    {
        System.out.println("Navigated to Google");
    }

    @Test
    public static void test01()
    {
        System.out.println("----Test1 done----");
    }

    @Test
    public void test02()
    {
        System.out.println("----Test2 done----");
    }

    @Test
    public void test03()
    {
        System.out.println("----Test3 done----");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("Closing chrome");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("Test02->Disconnected to DB");
    }



}
