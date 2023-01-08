package com.testng.basicTestNGFramework.d_testbase_loglama_properties_takeSSandVideo.utilities;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.testng.basicTestNGFramework.d_testbase_loglama_properties_takeSSandVideo.utilities.Constants.*;

public class FileUtil
{

    public static void refreshTestOutput()
    {
        try {
            File f = new File(TEST_OUTPUT_PATH);

            if(f.exists())//boyle bir path'te file var ise true return eder
            {
                FileUtils.cleanDirectory(f); //Optional-TEST-OUTPUT DIRECTORY'SININ ICINI SILER

                //TEST-OUTPUT DIRECTORY'SINI SILER
                FileUtils.forceDelete(f);
            }

            if(!f.exists()){
                //SCREENSHOTS_PATH VE SCREENRECORDING_PATH DIRECTORY'LERINI OLUSTURUR
                FileUtils.forceMkdir(new File(SCREENSHOTS_PATH));
                FileUtils.forceMkdir(new File(SCREENRECORDING_PATH));
                FileUtils.forceMkdir(new File(PDFPATH_SCREENSHOTS));
            }
                    }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }




}