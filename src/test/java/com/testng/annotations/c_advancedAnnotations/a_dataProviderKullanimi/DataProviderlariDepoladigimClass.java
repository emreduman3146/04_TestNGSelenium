package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi;

import org.testng.annotations.DataProvider;

public class DataProviderlariDepoladigimClass
{


    @DataProvider(name = "testData2", parallel = true)
    public static Object[][] testData2() {
        return new Object[][] {
                {"chrome","https://www.google.com"},//1.loop
                {"firefox","https://www.mozilla.com"},
                {"edge","https://www.edge.com"}
        };
    }


}
