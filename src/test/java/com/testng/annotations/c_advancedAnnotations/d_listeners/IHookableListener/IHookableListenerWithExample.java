package com.testng.annotations.c_advancedAnnotations.d_listeners.IHookableListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class IHookableListenerWithExample {

    @DataProvider
    public Object[][] testDataTeminEdiciMethod()
    {
        return new Object[][]
        {
            {"dataProvider-testData 1"},
            {"dataProvider-testData 2"},
            {"dataProvider-testData 3"}
        };
    }





    @Test(dataProvider="testDataTeminEdiciMethod")
    public void t(String parameter)
    {
        System.out.println("test method to be called with the following parameter is " + parameter);
    }

}