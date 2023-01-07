package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.Constants.WEBELEMENTS_PATH;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.ObjectUtil.*;

public class PropertiesReadWrite
{

    //STATIC BLOCK - SADECE 1 KEZ ILK SIRADA CALISIR
    //Bu block'un objective'i (amaci)-> bir .properties file'inin path'ini kullanarak, o file'i 'properties' isimli static variable'a assign etmektir.
    static
    {
        path = WEBELEMENTS_PATH;//By Default
        try
        {
            loadFileIntoProperties(path);//satir 34 teki methodumuzu burada call(cagirmak) ediyoruz. -calling a method-
        }
        catch (IOException e)//Bu exception turu: Dosya bulunamadi hatasidir.
        {
            e.printStackTrace();
        }
    }

    //Bu method 1 kez calismali ve bir daha kullanilmamali
    //bu yuzden private'tir ve static blockun icinde kullanilmistir.
    //methodun amaci -> line 12'deki 'properties' isimli objenin initialize edilmesini saglamaktir.
    private static void loadFileIntoProperties(String path) throws IOException {
        try(FileInputStream fis = new FileInputStream(path))//FileInputStream JDK'dan gelen classtir,  .txt/.properties/.xlsx/.csv gibi file'larin icini okumamizi saglar
        {
            properties = new Properties();//Key=value seklindeki datalarin read/write edilmesini saglayan Class'tir. jdk'dan gelir.
            properties.load(fis);//fis-> bunyesinde okunacak file'i tutar. 'properties' objesi ise bu file'i key=value seklinde okumamizi saglar.
        }
    }




    //.PROPERTIES FILE OKUMA ISLEMI


    public static String getProperty(String key)
    {
        return properties.getProperty(key);
        //getProperty methodu, Properties Class'inin icinden hazir gelir.
        //'properties' objesinin bunyesinde barindirdigi file'in key=value seklinde store edilen datalarin READ edilmesini saglar
        //1 String parameter ister.Bu parameter .properties file'inin icindeki bir key'e equals ise bu key'nin value'sunu return eder.
    }




    //.PROPERTIES FILE YAZMA ISLEMLERI

    public static void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        //setProperty methodu, Properties Class'inin icinden hazir gelir.
        //'properties' objesinin bunyesinde barindirdigi file'in icinde key=value seklinde store edilen datalarin WRITE edilmesini saglar

        flush();//Guncellenen .propeties file'i kaydedip kapatiyoruz

    }


    public static void flush() throws IOException
    {
        //JAVA BILGISI: TRY-CATCH-FINALLY EXCEPTION HANDLING KONUSUNUN ALT BIR KONUSU:
        //konu adi: try-with-resources
        //google'lama yapmak isteyenler bu konuyu calisabilirler
        //Ya da mehmet hoca ile yapilan cover derslerinde hocaniza sorunuz :)

        try (final OutputStream outputstream = new FileOutputStream(path);)//FileOutputStream Classi djk'dan gelir. path'i verilen file'in icinin WRITE edilmesini saglar.
        {
            properties.store(outputstream,"File Updated");
        }
    }




}
