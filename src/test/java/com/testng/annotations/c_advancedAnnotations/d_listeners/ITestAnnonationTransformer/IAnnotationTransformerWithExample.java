package com.testng.annotations.c_advancedAnnotations.d_listeners.ITestAnnonationTransformer;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//alttaki satir gereksiz islevsel degildir
@Listeners(com.testng.annotations.c_advancedAnnotations.d_listeners.ITestAnnonationTransformer.MyListener.class)
public class IAnnotationTransformerWithExample
{


    @Test(invocationCount=5)// --> JUNIT5.9 DAKI @RepeatedTest(5) kullanimina esittir
    public void changeInvocationCountOfMethod()
    {
        System.out.println("This method have invocation count set to 5 but at run time it shall become 3 ");
    }


    @Test(enabled = true)
    public void changeEnabledOfMethod()
    {
        System.out.println("This method have enabled attribute as true but changed to false by listener");
    }

}
