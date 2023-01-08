package com.testng.annotations.c_advancedAnnotations.d_listeners.IExecutionListener;

import org.testng.IExecutionListener;

public class MyListener implements IExecutionListener {


    //TESTNG ENGINE BASLAMADAN ONCE
    @Override
    public void onExecutionStart() {
        long startTime= System.currentTimeMillis();
        System.out.println("Inform all the suite have started execution at"+ startTime);

    }

    //TESTNG ENGINE BITTIKTEN SONRA
    @Override
    public void onExecutionFinish() {
        long endTime= System.currentTimeMillis();
        System.out.println("Inform all the suite have finished execution att"+ endTime);

    }

}
    /*
    IExecutionListener: İsminden de anlaşılacağı gibi, TestNG çalıştırılmasının başlangıcını ve sonunu izler.
    Bu listener, çalışmaya başlarken/bitirirken sunucuyu başlatmayı/durdurmayı çoğunlukla kullanılır.
     Ayrıca, çalışmaya başlanacağını veya bittiğini ilgili tarafları e-posta ile bildirmek için de kullanılabilir.
     İki methodu vardır:
        onExecutionStart() - TestNG suites'leri çalıştırmaya başlamadan önce çağrılır
        onExecutionFinish() - Tüm TestNG suites'lerinin çalıştırılması bittikten sonra çağrılır
     */