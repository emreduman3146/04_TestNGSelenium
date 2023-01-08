package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities;

public class Constants
{
    public static final String WEBELEMENTS_PATH= "src/test/java/com/testng/basicTestNGFramework/f_testbase_loglama_properties_takeSS_listeners_extentReport/webElements/webElements.properties";

    public static final String USER_DIR=System.getProperty("user.dir");
    public static final String TEST_OUTPUT_PATH=USER_DIR+"\\src\\test\\java\\com\\testng\\basicTestNGFramework\\f_testbase_loglama_properties_takeSS_listeners_extentReport\\test-output\\";
    public static final String SCREENSHOTS_PATH= TEST_OUTPUT_PATH+"screenshots\\";
    public static final String FAILED_STEP_SCREENSHOTS_PATH= SCREENSHOTS_PATH+ "failedSteps\\";
    public static final String SCREENRECORDING_PATH= TEST_OUTPUT_PATH+"screenRecordings\\";
    public static final String PDFPATH_SCREENSHOTS= TEST_OUTPUT_PATH+"PDFs\\";


   //F PACKAGE'I ILE GELDI
    public static final String EXTENT_SPARK_REPORT= TEST_OUTPUT_PATH+"extent-report\\";

    public static String ssPath;
}
