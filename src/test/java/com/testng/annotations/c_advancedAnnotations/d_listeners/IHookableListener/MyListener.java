package com.testng.annotations.c_advancedAnnotations.d_listeners.IHookableListener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements IHookable
{

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {

        Object[] parameterValues = callBack.getParameters();

        if (parameterValues[0].equals("parameter 3"))
        {
            callBack.runTestMethod(testResult);

        }

        else
        {
            System.out.println("Skip the required parameter");
        }

    }
}

/*
    IHookable: Bir class bu interface'i implemente ettiğinde,
    test methodları yerine onun run methodu çağrılacaktır.
    IHookCallBack parametresinin callback methodu kullanılarak,
    test methodunun çağrılması gerçekleştirilebilir.
    Tek bir methodu vardır, run, iki parametre alır.run(IHookCallBack callBack, ITestResult testResult)
    Şimdi gerçek zamanlı bir örneğine bakalım.
    Bu örnekte, belirli bir parametre değerine göre, IHookable listener interface'i kullanılarak test atlanacaktır.
    Bu değerler, ayrı bir TestNG sınıfında bir data provider tarafından sağlanacaktır.
 */