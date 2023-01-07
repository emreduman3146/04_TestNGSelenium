package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constants
{
    //JAVA BILGISI: final olan(degistirilemeyen) variable'lari isimlendirirken hep UPPERCASE(buyuk harf) kullaniriz

    public static final String WEBELEMENTS_PATH=
            "src/test/java/com/testng/testbase_loglama_propertiesReadWrite_takeSS/d_testbase_loglama_properties_takeSSandVideo/webElements/webElements.properties";

    public static final String USER_DIR=System.getProperty("user.dir");
    public static final String TEST_OUTPUT_PATH=USER_DIR+"\\src\\test\\java\\com\\testng\\testbase_loglama_propertiesReadWrite_takeSS\\d_testbase_loglama_properties_takeSSandVideo\\test-output\\";
    public static final String SCREENSHOTS_PATH= TEST_OUTPUT_PATH+"screenshots\\";
    //public static final String FAILED_STEP_SCREENSHOTS_PATH= SCREENSHOTS_PATH+ "failedSteps\\";
    public static final String SCREENRECORDING_PATH= TEST_OUTPUT_PATH+"screenRecordings\\";
    public static final String PDFPATH_SCREENSHOTS= TEST_OUTPUT_PATH+"PDFs\\";

    public static Map<byte[],String> ekranGoruntusu_aciklamasi=new LinkedHashMap<>();//ObjectUtil'e koy






}
