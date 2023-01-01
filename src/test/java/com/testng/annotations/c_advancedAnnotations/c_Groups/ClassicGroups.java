package com.testng.annotations.c_advancedAnnotations.c_Groups;

import org.testng.annotations.*;

public class ClassicGroups
{

    @BeforeClass
    void beforeClass()
    {
        System.out.println("before class");
    }

    @BeforeGroups(groups = {"group1"})
    void beforeGroupsMethod()
    {
        System.out.println("BEFORE GROUPS group1 icin calis");
    }


    @Test(groups = { "group1", "group2" })
    public void test_method1()
    {
        System.out.println("method1 - group1,group2 uyesi test");
    }

    @Test(groups = {"group2"} )
    public void test_method2()
    {
        System.out.println("method2 - group2 uyesi test");
    }

    @Test(groups = {"group1"})
    public void test_method3()
    {
        System.out.println("method3 - group1 uyesi test");
    }


    //Diyelimki bu classta 100 tane test 10 tane de group var



    @AfterGroups(groups = {"group1","group2"})
    void afterGroupMethod()
    {
        System.out.println("AFTER GROUPS group1 icin calis");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("after class");
    }

}
