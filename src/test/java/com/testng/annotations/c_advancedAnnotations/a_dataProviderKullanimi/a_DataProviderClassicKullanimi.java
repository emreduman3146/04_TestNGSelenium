package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class a_DataProviderClassicKullanimi
{
    //bir dataProvider testng methodunun retrun type'i ancak ve ancak
    //2 boyutlu-2 dimensional array olmalidir
    //Array'in declaration type: Object olmak zorundadir

    //JAVA BILGISI: Javanin jdk'sindaki ya da elimle olusturdugum yeni bir classsin
    //EN UST ATASI KIMDIR? -> Object Class idir

    //HAFTA ICI IHTIYAC DUYANLAR JAVA OBJECT CLASSINI GOOGLEYALA
    int i1=5;
    Object i2=5;
    Object isim1="abc";
    Object array= new int[10];//1,2,3,4,5


    //dataProvider methodu loop gibi calisir
    @DataProvider(name = "benDataTeminEdenBirMethodum")
    public static Object[][] testData()
    {
        return new Object[][] {
                {1,2,3}, //1.loop datasi- tek seferde return edecegi param sayisi 3 adettir
                {4, 5, 9}, //2. loop datasi - bu methodu dataProvider olarak alan bir @Test methodunun 3 tane params'i olmali
                {2, 3, 5} //3.loop
        };
    }



    @Test(dataProvider = "benDataTeminEdenBirMethodum")
    public void testMethod(int sayi1, int sayi2, int toplam) {
        Assert.assertEquals(sayi1+sayi2,toplam);
    }




}
