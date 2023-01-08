package com.testng.annotations.c_advancedAnnotations.d_listeners.ITestListener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ItestListenerWithExample {

    int i=0;

    @Test
    public void testMethod1()//launchBrowser
    {
        System.out.println("This method will pass and will invoke the onTestSuccess method of ITestlistener");
        int i=10;
        Assert.assertEquals(i, 10);//tek amacimiz pass almak ki konuyu anlayalim
    }

    @Test
    public void testMethod2()//login
    {
        System.out.println("This method will fail and will invoke the onTestFailure method of ITestlistener");
        int i=10;
        Assert.assertEquals(i, 11);
    }

    @Test
    public void testMethod3()//odeme
    {
        System.out.println("This method will skip and will invoke the onTestSkipped method of ITestlistener");
        throw new SkipException("Skipping this test case.");

    }

    @Test(successPercentage=50, invocationCount=5)//junit Repeat(5)
    public void testMethod4()//cikis yapma
    {
        i++;//1,2
        System.out.println("Test Failed But Within Success Percentage Test Method, invocation count: " + i);
        if (i == 1 || i == 2) {
            System.out.println("this will be Failed");
            Assert.assertEquals(i, 100);
        }
    }


}