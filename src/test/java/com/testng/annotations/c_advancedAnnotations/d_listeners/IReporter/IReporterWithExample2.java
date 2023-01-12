package com.testng.annotations.c_advancedAnnotations.d_listeners.IReporter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IReporterWithExample2 {

    @Test(groups="unitTest")
    public void testcase1() {
        System.out.println("This test case will pass");
    }

    @Test(groups="componentTest")
    public void testcase2() {
        System.out.println("This test case will fail");
        Assert.assertTrue(false);
    }

    @Test(groups="integrationTest")
    public void testcase3() {
        System.out.println("this test case does not belong to the group smoke");
    }

}