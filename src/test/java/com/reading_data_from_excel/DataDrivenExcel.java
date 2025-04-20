package com.reading_data_from_excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class DataDrivenExcel {
  
  public static FileInputStream ip;

  public static XSSFWorkbook workbook;
    
  public static XSSFSheet sheet;
  //Step 1: Create an Excel Sheet (.xlsx) Which has the data.
  //Step 2: Copy that Excel sheet in your Eclipse (Package) 
  //Step 3: If you edit the local excel sheet it will make no difference to excel
  // which is copied here .so please delete the excel sheet from here and copy the updated excel
  // sheet and paste it.


  @DataProvider(name="Rediff")
  public Object[][] getRediffExcelSheet() throws IOException{
   Object[][] data = DataDrivenExcel.readFromExcelRediffData("login");
   return data;
  }

  @DataProvider(name="TutorialNinja")
  public Object[][] getTNExcelSheet() throws IOException{
   Object[][] data = DataDrivenExcel.readFromExcelTNData("LoginTN");
   return data;
  }

   // Step 1: Create a Method and pass a String sheetname parameter 

 public static Object[][] readFromExcelRediffData(String SheetName) throws IOException{

  //Step 2: Create the object of FileInputStream and pass the path of the Excel Sheet in its Contructor

    ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\reading_data_from_excel\\RediffData.xlsx");


   //Step 3: Create the Object of XSSFWorkbook

    workbook = new XSSFWorkbook(ip);

   //Step 4: use the Workbook reference to call the getsheet(overloaded method)
   sheet=workbook.getSheet(SheetName);

   //Step 5: once you get the sheet,now you need no of rows and no of cols
   int rows=sheet.getLastRowNum();
   int cols= sheet.getRow(0).getLastCellNum();

   //Step 6: Create a Dimensional Object 
   Object [][] data = new Object[rows][cols];

   for(int i =0;i<rows;i++){
     XSSFRow row=sheet.getRow(i+1);

      for(int j=0;j<cols;j++){
       XSSFCell cell = row.getCell(j);

       //Step 7: Determine the Cell datatype
          CellType celltype=cell.getCellType();
          switch(celltype){
           case STRING:
             data[i][j] = cell.getStringCellValue();
             break;

           case NUMERIC:
             data[i][j] = Integer.toString((int)cell.getNumericCellValue());  
             break;

           case BOOLEAN:
             data[i][j] = cell.getBooleanCellValue();
             break;

          }

      }
   }
    return data;
   
 }

 public static Object[][] readFromExcelTNData(String SheetName) throws IOException{

  //Step 2: Create the object of FileInputStream and pass the path of the Excel Sheet in its Contructor

    ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\reading_data_from_excel\\RediffData.xlsx");


   //Step 3: Create the Object of XSSFWorkbook

    workbook = new XSSFWorkbook(ip);

   //Step 4: use the Workbook reference to call the getsheet(overloaded method)
   sheet=workbook.getSheet(SheetName);

   //Step 5: once you get the sheet,now you need no of rows and no of cols
   int rows=sheet.getLastRowNum();
   int cols= sheet.getRow(0).getLastCellNum();

   //Step 6: Create a Dimensional Object 
   Object [][] data = new Object[rows][cols];

   for(int i =0;i<rows;i++){
     XSSFRow row=sheet.getRow(i+1);

      for(int j=0;j<cols;j++){
       XSSFCell cell = row.getCell(j);

       //Step 7: Determine the Cell datatype
          CellType celltype=cell.getCellType();
          switch(celltype){
           case STRING:
             data[i][j] = cell.getStringCellValue();
             break;

           case NUMERIC:
             data[i][j] = Integer.toString((int)cell.getNumericCellValue());  
             break;

           case BOOLEAN:
             data[i][j] = cell.getBooleanCellValue();
             break;

          }

      }
   }
    return data;
   
 }



}


