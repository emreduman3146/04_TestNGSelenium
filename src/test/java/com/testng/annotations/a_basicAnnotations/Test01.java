package com.testng.annotations.a_basicAnnotations;

import org.testng.annotations.*;

public class Test01
{
    //JUNIT5.9'A BENZIYOR

    //The annotated method will be run only once before all tests in this suite have run.
    //TestSuite-> Eleimizdeki @Testleri 1 yerden yoneten class(junit) ya da xml olabilir
    @BeforeSuite
    public static void BeforeSuite()
    {
        System.out.println("Test Suite calistiriliyor");
    }

    @BeforeTest
    public static void BeforeTest()
    {
        System.out.println("Database connectivity set up");
    }

    @BeforeClass//BeforeAll
    public static void beforeClass()
    {
        System.out.println("BeforeClass");
    }

    //@BeforeGroups

    @BeforeMethod//BeforeEach
    public static void BeforeMethod()
    {
        System.out.println("Navigated to Google");
    }

    @Test//Test
    public static void test01()
    {
        System.out.println("----Test1 done----");
    }

    @Test
    public void test02()
    {
        System.out.println("----Test2 done----");
    }

    @AfterMethod//AfterEach - her @Test methodundan sonra calisir
    public void AfterMethod()
    {
        System.out.println("Closing chrome");
    }

    @AfterClass//AfterAll - Test classi icerisinde sadece 1 kez calisir
    public static void afterClass()
    {
        System.out.println("AfterClass");
    }


    @AfterTest
    public void AfterTest()
    {
        System.out.println("Disconnected to DB");
    }

    @AfterSuite
    public static void AfterSuite()
    {
        System.out.println("Test Suite bitti");
    }

}
