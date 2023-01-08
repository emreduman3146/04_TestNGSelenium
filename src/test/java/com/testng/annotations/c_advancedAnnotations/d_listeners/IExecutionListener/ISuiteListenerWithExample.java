package com.testng.annotations.c_advancedAnnotations.d_listeners.IExecutionListener;

import com.testng.annotations.c_advancedAnnotations.d_listeners.ISuiteListener.MyListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)//ARTIK @TESTLERIMI YAZDIGIM "ISuiteListenerWithExample" IM "MyListener" ISIMLI LISTENER ILE BAGI VAR
public class ISuiteListenerWithExample {

    @BeforeSuite
    public void bsuite()
    {
        System.out.println("BeforeSuite method started for the first IsuiteListener example class");
    }

    @Test
    public void test()
    {
        System.out.println("Test method started for the first IsuiteListener example class");
    }

    @AfterSuite
    public void asuite()
    {
        System.out.println("AfterSuite method started for the first IsuiteListener example class");
    }

}

/*
    ISuiteListener: İsminden de anlaşılacağı gibi, bu listener suite seviyesinde çalışır.
    Suite çalıştırılmaya başlamadan ve bitirilmeden önce dinler ve çalışır.
    İki methodu vardır:
        onStart: test suite çalıştırmaya başlamadan önce çağrılır
        onFinish: test suite çalıştırılması bittikten sonra çağrılır.
 */