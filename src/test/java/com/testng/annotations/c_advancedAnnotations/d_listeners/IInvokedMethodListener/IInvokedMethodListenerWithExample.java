package com.testng.annotations.c_advancedAnnotations.d_listeners.IInvokedMethodListener;


import org.testng.annotations.*;

@Listeners(MyListener.class)
public class IInvokedMethodListenerWithExample {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @Test
    public void method1() {
        System.out.println("test method 1 ");
    }

    @Test
    public void method2() {
        System.out.println("test method 2 ");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }
}


