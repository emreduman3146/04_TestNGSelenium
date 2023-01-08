package com.testng.annotations.c_advancedAnnotations.d_listeners.ISuiteListener;


import org.testng.annotations.*;


public class ISuiteListenerWithExample2 {

    @BeforeSuite
    public void bsuite()
    {
        System.out.println("BeforeSuite method started for the first IsuiteListener example 2 class");
    }

    @Test
    public void test()
    {
        System.out.println("Test method started for the first IsuiteListener example 2 class");
    }

    @AfterSuite
    public void asuite()
    {
        System.out.println("AfterSuite method started for the first IsuiteListener example 2 class");
    }

}


/*
    ISuiteListener: İsminden de anlaşılacağı gibi, bu listener suite seviyesinde çalışır.
    Suite çalıştırılmaya başlamadan ve bitirilmeden önce dinler ve çalışır.
    İki methodu vardır:
        onStart: test suite çalıştırmaya başlamadan önce çağrılır
        onFinish: test suite çalıştırılması bittikten sonra çağrılır.
 */