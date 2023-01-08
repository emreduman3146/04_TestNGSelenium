package com.testng.annotations.c_advancedAnnotations.d_listeners.ITestAnnonationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class MyListener implements IAnnotationTransformer {


    @Override
    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstrutor, Method testMethod)
    {
        if (testMethod.getName().equals("changeInvocationCountOfMethod"))
        {
            System.out.println("Changing invocation for the following method: " + testMethod.getName());
            testAnnotation.setInvocationCount(3);

        }

        if (testMethod.getName().equals("changeEnabledOfMethod"))
        {
            System.out.println("Changing enabled for the following method: " + testMethod.getName());
            testAnnotation.setEnabled(true);
        }

    }



    /*
        TestNG'de IAnnotationTransformer adlı bir arayüz vardır.
        Bu arayüz, test sınıfının test annotations'larını TestNG tarafından işlenmeden önce değiştirmenize olanak sağlar.
        IAnnotationTransformer'ı kullanmak için, transform() adlı bir methodu implemente etmeniz gerekir.
        Bu method, test sınıfını ve test methodunu alır.
        transform() methodu, test sınıfındaki her test methodu için çağrılır ve test methodunun test annotations'larını değiştirmeyi istediğiniz şekilde kullanabilirsiniz.

        4 parametre alir
            ITestAnnotation annotation
            Class testClass
            Constructor testConstructor
            Method testMethod
     */


    /*
        Not: @Listener annotation'ı, IAnnotationTransformer hariç herhangi bir ITestNGListener sınıfını içerebilir.
        Bunun nedeni, son listener'ın en erken TestNG'ye bildirilmesi gerektiğidir,
        böylece annotation'ları çalışma zamanında geçersiz kılabilirler.
        Bu nedenle, testNG.xml dosyasında belirtilmelidirler.
     */
}