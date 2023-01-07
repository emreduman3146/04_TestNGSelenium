package com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static com.testng.testbase_loglama_propertiesReadWrite_takeSS.d_testbase_loglama_properties_takeSSandVideo.utilities.ObjectUtil.screenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil
{

    public static void startRecording() throws IOException, AWTException
    {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc,
                gc.getBounds(),
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null,
                new File(Constants.SCREENRECORDING_PATH));
        screenRecorder.start();
    }

    public static void stopRecording() throws IOException
    {
        screenRecorder.stop();
    }

}