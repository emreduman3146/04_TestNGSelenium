package com.testng.basicTestNGFramework.f_testbase_loglama_properties_takeSS_listeners_extentReport.utilities;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.Map;


public class PDFUtil
{

    public static Document document;
    public static PdfWriter pdfWriter;
    public static Image image;

    public static void pdfWrite(Map<byte[],String> ekranGoruntusu_aciklamasi, String pdfpath, String fileName)
    {
        try
        {
            document = new Document();//PDF DOCUMENTI

            String path=pdfpath+fileName+".pdf";
            FileOutputStream fos = new FileOutputStream(path);

            pdfWriter = PdfWriter.getInstance(document, fos);

            pdfWriter.open();
            document.open();

            for (Map.Entry<byte[], String> entry : ekranGoruntusu_aciklamasi.entrySet())
            {
                byte[] key = entry.getKey();
                String value = entry.getValue();
                //ELIMIZDEKI BYTE DATA'YI IMAGE FORMATINA DONUSTURUR
                image= Image.getInstance(key);

                //IMAGE'IN PDF ICINE YERLESTIRILMEDEN ONCE BOYUT AYARLARININ YAPILMASI
                image.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

                //IMAGE'I PDF'E EKLE
                document.add(new Paragraph(value+"\n\n"));
                document.add(image);
            }

            //PDF'I KAPAT
            document.close();
            pdfWriter.close();


        }
        catch (Exception exception){
            exception.printStackTrace();
        }


    }



}