package com.testng.annotations.c_advancedAnnotations.d_listeners.IMethodInterceptor;

import org.testng.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyListener implements IMethodInterceptor {


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methodsInstance, ITestContext testContext)
    {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        for (IMethodInstance method : methodsInstance)
        {
            Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
            if (testMethod.priority() == 1)
            {
                result.add(method);
            }

            if(testMethod.description().equals("Uygulamadan cikis yapilir"))
            {
                result.remove(method);
            }
        }
        return result;
    }


}

/*
    IMethodInterceptor: Bu listener, TestNG tarafından çalıştırılması gereken methodları değiştirmeye yardımcı olur.
    TestNG methodları çağırmadan hemen önce çağrılır.
    Sadece intercept adinda bir methodu vardir var ve değiştirilmiş method listesi döndürür.
    Örneği inceleyelim. Buradaki kod, sadece test sınıfındaki öncelik 1 olan methodları çalıştıracaktır.
    Diğer farklı öncelikleri olan methodlar çalıştırılmayacaktır.
    Bu, IMethodInterceptor listener'ını implemente etikten sonra yapılacaktır.
 */