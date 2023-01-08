package com.testng.annotations.c_advancedAnnotations.d_listeners.ITestListener;

import logger.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override//@BEFORETEST GIBI DAVRANIR
    public void onStart(ITestContext contextStart) {
        System.out.println("onStart method started  "+contextStart.getName());
    }

    @Override//@AFTERTEST GIBI DAVRANIR
    public void onFinish(ITestContext contextFinish) {
        System.out.println("onFinish method finished");

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage"+ result.getName());

    }

    @Override//ANLIK OLARAK UZERINDE CALISILAN @TEST FAIL EDERSE BU METHODUN ICINI DE CALISTIR
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed"+ result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped"+ result.getName());

    }

    @Override//HER @TEST ANNOTATION'DAN ONCE CALISIR  - @BEFOREMETHOD
    public void onTestStart(ITestResult result) {
        System.out.println("Method started  "+ result.getName());

    }

    @Override//ANLIK OLARAK UZERINDE CALISILAN @TEST PASS EDERSE BU METHODUN ICINI DE CALISTIR
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed"+ result.getName());

    }

}

/*
ITestListener: Bu, TestNG listener'ları arasında en sık kullanılanıdır.
 ITestListener, sınıfta implemente edilen bir arayüzdür ve o sınıf, tanımlanan ITestListener methodlarını geçersiz kılar.
 ITestListener, istenilen olaylara dinler ve methodları buna göre çalıştırır.
 Aşağıdaki methodları içerir:
        onStart(): test sınıfının instantiate edildikten ve herhangi bir testNG methodunun çalıştırılmasından önce çağrılır.
        onTestSuccess(): bir test başarılı olduğunda çağrılır
        onTestFailure(): bir test başarısız olduğunda çağrılır
        onTestSkipped(): bir test atlandığında çağrılır
        onTestFailedButWithinSuccessPercentage(): tanımlanan başarı yüzdesinin içinde olsa da bir method başarısız olduğunda çağrılır
        onFinish(): bir sınıfın tüm testleri çalıştırıldıktan sonra çağrılır.

Yukarıda belirtilen methodlar, ITestContext ve ITestResult parametrelerini kullanır.
ITestContext, test çalıştırması hakkında bilgi içeren bir sınıftır.
ITestResult, testin sonucunu tanımlayan bir arayüzdür.
 */