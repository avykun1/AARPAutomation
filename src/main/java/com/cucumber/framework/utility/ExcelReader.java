package com.cucumber.framework.utility;


import com.cucumber.framework.TestBase.TestBase;
import com.cucumber.framework.helper.LoggerHelper;
import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class ExcelReader {
    private static final Logger log = LoggerHelper.getLogger(ExcelReader.class);
    private static Map<String, String> map = new HashMap<>();
    private static XSSFWorkbook wb;
    private static XSSFSheet ws;
    private static XSSFCell cell;
    private static String filepath=ResourceHelper.getResourcePath(TestBase.configProps.getProperty("TestData"));
    //private static String xvcpFilepath=ResourceHelper.getResourcePath(TestBase.configProps.getProperty("XVCPTestData"));
    private static String sheetName=TestBase.environment;
    private static String portalCredentialsSheetName=TestBase.configProps.getProperty("ENV")+"PortalCredentials";
    public static int rowCounter=0;


    private static Map<String, String> credentials = new HashMap<>();


    public static void readExcel(String scenarioName) throws IOException {
        FileInputStream fis;
        int k = 0;
        try {

            fis = new FileInputStream(filepath);
            wb = new XSSFWorkbook(fis);
            ws = wb.getSheet(sheetName);
            int row = findRow(scenarioName);
            rowCounter=row;

            int cols = ws.getRow(0).getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                map.put(ws.getRow(0).getCell(j, Row.CREATE_NULL_AS_BLANK).toString(), ws.getRow(row).getCell(j, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
            }
        } catch (Exception e) {
            log.error(scenarioName+"is not added into Test Data sheet");
        }

    }

    private static int findRow(String scenarioName) {
        /*
         *  This is the method to find the row number
         */
        int rows = ws.getPhysicalNumberOfRows();
        int rowNum = 0;

        for (int i = 1; i < rows+1; i++) {
            if (ws.getRow(i).getCell(2, Row.CREATE_NULL_AS_BLANK).toString().trim().equalsIgnoreCase(scenarioName)) {
                return i;
            }
        }
        return -1;
    }


    private static int findCredRow(String role) {
        /*
         *  This is the method to find the row number
         */
        int rows = ws.getPhysicalNumberOfRows();
        int rowNum = 0;

        for (int i = 1; i < rows+1; i++) {
            if (ws.getRow(i).getCell(0, Row.CREATE_NULL_AS_BLANK).toString().trim().equalsIgnoreCase(role)) {
                return i;
            }
        }
        return -1;
    }

    public static String getCellData(String columName){
        return map.get(columName);
    }

    public static void readCredentials(String role){


        FileInputStream fis;
        int k = 0;
        try {
            fis = new FileInputStream(filepath);
            wb = new XSSFWorkbook(fis);
            ws = wb.getSheet(portalCredentialsSheetName);
            int row = findCredRow(role);

            int cols = ws.getRow(0).getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                credentials.put(ws.getRow(0).getCell(j, Row.CREATE_NULL_AS_BLANK).toString(), ws.getRow(row).getCell(j, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static String getPortalTestData(String value){
        //readCredentials(role);
        return credentials.get(value);
    }





    // returns true if data is set successfully else false
    public static boolean setCellData(String colName,
                                      String data) {

        if(!TestBase.scenarioName.startsWith("XVCP")){
            return false;
        }


        //FileInputStream fis;
        try {
          /*  fis = new FileInputStream(resultfilepath);
            wb = new XSSFWorkbook(fis);*/

            if (rowCounter <= 0)
                return false;

            int index = wb.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            XSSFSheet sheet = wb.getSheetAt(index);

            XSSFRow row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                // System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }
            if (colNum == -1)
                return false;

          //  sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowCounter);
            if (row == null)
                row = sheet.createRow(rowCounter);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            // cell style
            // CellStyle cs = workbook.createCellStyle();
            // cs.setWrapText(true);
            // cell.setCellStyle(cs);


            cell.setCellValue(data);

            FileOutputStream fileOut = new FileOutputStream(filepath);

            wb.write(fileOut);

            fileOut.close();

            wb = new XSSFWorkbook(new FileInputStream(filepath));



        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static String getUserName(String role) {
        ExcelReader.readCredentials(role);
        return credentials.get("UserName");
    }

    public void writeData(String colName, String data) throws IOException {
      /*  XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet ws=wb.getSheet(sheetName);*/
            int colNum=0;
        XSSFRow row = ws.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            // System.out.println(row.getCell(i).getStringCellValue().trim());
            if (row.getCell(i).getStringCellValue().trim().equals(colName))
                colNum = i;
        }

        row = ws.getRow(rowCounter);



        ws.autoSizeColumn(colNum);
        row = ws.getRow(rowCounter);
        if (row == null)
            row = ws.createRow(rowCounter);

        cell = row.getCell(colNum);
        if (cell == null)
            cell = row.createCell(colNum);


        // cell style
        // CellStyle cs = workbook.createCellStyle();
        // cs.setWrapText(true);
        // cell.setCellStyle(cs);


        cell.setCellValue(data);
        CellStyle style = wb.createCellStyle();
        style.setWrapText(true);
        cell.setCellStyle(style);

        FileOutputStream fileOut = new FileOutputStream(filepath);


        wb.write(fileOut);

        fileOut.close();


    }

}



