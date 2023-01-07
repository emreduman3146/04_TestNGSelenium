package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.Constants.ekranGoruntusu_aciklamasi;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.ObjectUtil.stepNumber;
import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.z_driver.DriverClass.getDriver;

public class TakeScreenShotsUtil
{
    public static  <T> String takeScreenshot(T ssOfWhat, String defaultPath, String fileName,boolean fullScreen) throws IOException, InterruptedException {


        Thread.sleep(500);//her screen shot almadan once yarim saniye bekleyelim
        String date = new SimpleDateFormat("EEE yyyy-MMMM-dd hhmmss a ").format(new Date());

        String aciklama="Step"+ stepNumber +"_"+date +"_"+ fileName;
        String target = defaultPath + aciklama+ ".png";


        if(fullScreen) {
            Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
            ImageIO.write(s.getImage(), "PNG", new File(target));
        }
        else {

            TakesScreenshot ts = (TakesScreenshot) ssOfWhat;

            byte[] source = ts.getScreenshotAs(OutputType.BYTES);

            ekranGoruntusu_aciklamasi.put(source,aciklama);//JAVADA MAPLER KONUSU

            try {
                //test-output/screenshots directory'sine kaydeder
                File finalDestination = new File(target);
                FileOutputStream fileOutputStream=new FileOutputStream(finalDestination);
                fileOutputStream.write(source);

            }
            catch (Exception exception){
                exception.printStackTrace();
            }

            //PDF'E EKLEME ISLEMINI BURAYA YAZ PDFUtil kullanarak yap
            //Testng listeners ile fail olanlari faile koy
        }




        return target;// just incase , ama kullanmiyoruz
    }

}
