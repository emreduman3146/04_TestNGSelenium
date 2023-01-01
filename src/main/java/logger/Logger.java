package logger;


import org.apache.log4j.*;

import java.io.IOException;

public class Logger//benim Logger classsim
{

    //LOGGER CLASSINDAN OBJECT OLUSTURDUK
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class.getName());

    //LOGLAMANIN ILKEL VE PRATIK YOLUNU ANLAMAK ICIN MAIN METHODUNU ICINE LOG-LAYOUT-APPENDER CLASSLARINDAN LOGLAMA SISTEMI KURDUK
    public static void main(String[] args) throws IOException {

        //LAYOUT CLASSINDAN OBJE OLUSTURMALIYIZ
        Layout layout=new SimpleLayout();
        //layout=new HTMLLayout();
        //layout=new XMLLayout();
        layout=new PatternLayout("%p %d %C %M %m %n");

        //2-Create appender + link layout
        Appender appender=new ConsoleAppender(layout);
        appender=new FileAppender(layout,System.getProperty("user.dir")+"/src/main/java/log-output/log4j_appender.log");

        //link appender with logger
        log.addAppender(appender);



        log.info("info");
        log.debug("debugging");
        log.fatal("fatal");


    }

    public static void startLog (String testClassName)
    {
        //log.info("Test is Starting...");
        log.info("---------------------------------------------------------------------------------------");
        log.info("***********************        "+testClassName+ " STARTED    **************************");
        log.info("---------------------------------------------------------------------------------------");
    }


    public static void endLog (String testClassName)
    {
        //log.info("Test is Ending...");
        log.info("---------------------------------------------------------------------------------------");
        log.info("**************************     "+testClassName+ " ENDED       **************************");
        log.info("---------------------------------------------------------------------------------------");
    }

    //Info Level
    public static void info (String message) {
        log.info(message);
    }

    //Warn Level
    public static void warn (String message) {
        log.warn(message);
    }

    //Error Level
    public static void error (String message) {
        log.error(message);
    }

    //Fatal Level
    public static void fatal (String message) {
        log.fatal(message);
    }

    //Debug Level
    public static void debug (String message) {
        log.debug(message);
    }
}
