package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.listeners;

import logger.Logger;
import org.testng.IExecutionListener;

public class MyIExecutionListener implements IExecutionListener {


    //TESTNG ENGINE BASLAMADAN ONCE- TUM SUITELERDEN ONCE
    @Override
    public void onExecutionStart() {
        long startTime= System.currentTimeMillis();
        Logger.warn("TEST PROGRAM STARTED AT: "+startTime);
    }

    //TESTNG ENGINE BITTIKTEN SONRA
    @Override
    public void onExecutionFinish() {
        long endTime= System.currentTimeMillis();
        Logger.warn("TEST PROGRAM COMPLETED AT: "+endTime);

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