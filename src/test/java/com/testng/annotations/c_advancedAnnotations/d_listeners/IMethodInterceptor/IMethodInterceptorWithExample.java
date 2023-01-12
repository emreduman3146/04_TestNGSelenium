package com.testng.annotations.c_advancedAnnotations.d_listeners.IMethodInterceptor;


import org.testng.annotations.*;

@Listeners(MyListener.class)
public class IMethodInterceptorWithExample {

    @Test(priority=2)
    public void method1() {
        System.out.println("Method 1 will not be executed");
    }

    @Test(priority=3)
    public void method2() {
        System.out.println("Method 2 will not be executed");
    }

    @Test(priority=1)
    public void method3() {
        System.out.println("Method 3 will be executed");
    }

    @Test(priority=1, description = "Uygulamadan cikis yapilirrrrrrrrrrrrrrrrrrrrrrr")
    public void method4() {
        System.out.println("Method 4 will be executed");
    }
}


