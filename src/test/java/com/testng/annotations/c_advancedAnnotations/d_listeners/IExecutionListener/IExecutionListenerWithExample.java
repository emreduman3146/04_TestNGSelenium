package com.testng.annotations.c_advancedAnnotations.d_listeners.IExecutionListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class IExecutionListenerWithExample {

    @Test
    public void method1()
    {
        System.out.println("this method is method 1");

    }

    @Test
    public void method2()
    {
        System.out.println("this method is method 2");

    }

    @Test
    public void method3()
    {
        System.out.println("this method is method 3");

    }


}



