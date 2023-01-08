package com.testng.annotations.c_advancedAnnotations.d_listeners.IInvokedMethodListener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println("This method is invoked before every config method - " + method.getTestMethod().getMethodName());

    }
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println("This method is invoked after every config method - " + method.getTestMethod().getMethodName()+
                "\n-----------------------------------------------------------------");

    }

}

/*
IInvokedMethodListener: Bu listener, TestNG'de bir method öncesinde ve sonrasında çağrılır.
Bu methodlar hem test hem de diğer yapılandırma methodlarını içerir.
Bu listener'lar, yapılandırma ayarlama veya diğer temizleme etkinlikleri için yararlıdır.
İki methodu vardır:
    beforeInvocation(): Bu method, her method öncesinde çağrılır
    afterInvocation(): Bu method, her method sonrasında çağrılır
 */