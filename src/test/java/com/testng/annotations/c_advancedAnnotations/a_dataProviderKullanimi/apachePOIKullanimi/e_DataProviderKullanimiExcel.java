package com.testng.annotations.c_advancedAnnotations.a_dataProviderKullanimi.apachePOIKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class e_DataProviderKullanimiExcel
{

    //EXCEL OKUMA YAZMA ICIN KULLANDIGIM CLASSLAR/METHODLAR JDK'dan gelmez
    //MAVEN POM.XML;ime APACHE POI ISIMLI 2 TANE DEPENDENCY EKLEMEK ZORUNDAYIM
    //utility method
    public String[][] readExcelFile_via_ApachePoiDependency(String fileName, String sheetName){

        String[][] data =null;
        try
        {
            FileInputStream fis = new FileInputStream(fileName);//Excel File Path'i ile file'i bul
            XSSFWorkbook wb = new XSSFWorkbook(fis);//file'in icindeki workbook'u bul
            XSSFSheet sh = wb.getSheet(sheetName);//workbook'un icindeki sheet'i bul
            XSSFRow row = sh.getRow(0);//sheet'in icindeki ILK row'u bul

            int noOfRows = sh.getPhysicalNumberOfRows();//toplam row sayisini return eder

            int noOfCols = row.getLastCellNum();//Ilk row'un son elemaninin sutun numarasini return et

            //EXCELDEKI TABLE'IMIZA GORE ARRAYIMIZI OLUSTURDUK
            data = new String[noOfRows][noOfCols];
           //data=new String[4][2];


            //ARTIK SIRA GELDI CELL OKUMAYA ve arrayimizi doldurmaya
            Cell cell;//Cell isimli class

            //nested for loop
            for(int i =0; i<noOfRows;i++)//1 boyutu gezen loop, 4 defa gezecek
            {
                for(int j=0;j<noOfCols;j++)//22. boyutu gezen loop, 2'ser defa gezecek
                {
                    row = sh.getRow(i);//TABLE'IN i'inci ROW'unu aldik
                    cell= row.getCell(j);//ROW'daki j'inci CELL/HUCRE'yi aldik

                    data[i][j] = cell.getStringCellValue();//cell'in icindeki degeri alip String[][] array'e koyduk
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return data;//excel'den copyledigimis datalari rray depolamistik, simdi bu arrayi retrun edelim
    }


    @DataProvider(name = "excelDataProvider", parallel = true)
    public Object[][] excelDataProvider() {


        //String isim="abc";
        //String isim2=getIsim();

        String [][] testdataFromExcel= readExcelFile_via_ApachePoiDependency("src/test/java/com/testng/annotations/c_advancedAnnotations/a_dataProviderKullanimi/apachePOIKullanimi/dataProvider.xlsx","testNGData");

        String[][] testdata={
                {"....","...."},
                {"....","...."},
                {"....","...."},
                {".....","...."}
        };

        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
     //   Object[][] arrObj = readExcelFile_via_ApachePoiDependency("src/test/java/com/testng/annotations/c_advancedAnnotations/dataProviderKullanimi/apachePOIKullanimi/dataProvider.xlsx","Sheet1");
        return testdataFromExcel;

        //JAVA BILGISI: RETURN KEYWORD'UNDEN SONRA HIC BIR SEKILDE KOD YAZILAMAZ, YAZARSAN COMPILER KIRMIZI YAKAR
    }


    @Test(dataProvider = "excelDataProvider")
    public void apachePoiDependencyUsageExample(String browser, String url)
    {
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().avoidShutdownHook().create().get(url);break;
            case "firefox":
                WebDriverManager.firefoxdriver().avoidShutdownHook().create().get(url);break;
            case "edge":
                WebDriverManager.edgedriver().avoidShutdownHook().create().get(url);break;
        }
    }





}
