package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities;

import org.openqa.selenium.JavascriptExecutor;
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

import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil.ekranGoruntusu_aciklamasi;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.ObjectUtil.stepNumber;
import static com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities.WebElementUtil.getWebElement;
import static com.testng.basicTestNGFramework.z_driver.DriverClass.getDriver;

public class TakeScreenShotsUtil
{
    public static  <T> String takeScreenshot(T ssOfWhat, String defaultPath, String fileName,boolean fullScreen,boolean highlight,String webElementName) throws IOException, InterruptedException {


        Thread.sleep(500);//her screen shot almadan once yarim saniye bekleyelim
        String date = new SimpleDateFormat("EEE yyyy-MMMM-dd hhmmss a ").format(new Date());

        String aciklama = "Step" + stepNumber + "_" + date + "_" + fileName;
        String target = defaultPath + aciklama + ".png";

        try
        {
            if (highlight)
            {
                try {
                    //SELENIUM-JAVA'NIN JS'YI KULLANMASINI SAGLAYAN CLASSTIR
                    JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                    jse.executeScript("arguments[0].style.border='3px solid red'", getWebElement(webElementName));
                }catch (Exception e){
                    //HIC BIR SEY YAZDIRMA CIKTISINI OKUMAYA BILE GEREK OLMAYAN HATADIR BU
                }

            }
            if (fullScreen) {
                Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
                ImageIO.write(s.getImage(), "PNG", new File(target));
            }
            else {

                TakesScreenshot ts = (TakesScreenshot) ssOfWhat;

                byte[] source = ts.getScreenshotAs(OutputType.BYTES);

                ekranGoruntusu_aciklamasi.put(source, aciklama);//JAVADA MAPLER KONUSU

                //test-output/screenshots directory'sine kaydeder
                File finalDestination = new File(target);
                FileOutputStream fileOutputStream = new FileOutputStream(finalDestination);
                fileOutputStream.write(source);

            }


            //PDF'E EKLEME ISLEMINI BURAYA YAZ PDFUtil kullanarak yap
            //Testng listeners ile fail olanlari faile koy
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        return target;// just incase , ama kullanmiyoruz
    }
}
