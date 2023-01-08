package com.testng.annotations.c_advancedAnnotations.d_listeners.IExecutionListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MyListener2 implements ISuiteListener {

    //TUM LISTENER INTERFACELERININ KULLANILMA AMACI TEKNIK BILGI ALMAK
    //VE BILGILERI LOGLAMA YAPARKEN
    //REPORTING YAPARKEN KULLANMAK ICIN

    @Override//BEFORESUITE GIBIDIR HER SUITE'DEN ONCE CALISIR AMA @BEFORESUITE YAPISINDAN DAHA ONCE CALISIR
    public void onStart(ISuite suite) {
        System.out.println("onStart function started of ISuiteListener "+suite.getName() );

    }

    @Override//@AFTERSUITE METHODUNDAN SONRA CALISIR
    public void onFinish(ISuite suite) {
        System.out.println("onFinish function started of ISuiteListener " +suite.getName());

    }

}