package com.ecommerce.utils;

import com.ecommerce.base.Base;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils extends Base {
     public static String  path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\ecommerce\\testDatas\\EcommerceAppTestData.xlsx";
    public static String[][] getExcelData(String sheetname) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet =  workbook.getSheet(sheetname);
        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        String[][] data = new String[rows - 1][columns];
        DataFormatter df = new DataFormatter();
        for (int i = 0; i < rows - 1 ; i++){       //not started from i=1 because, we have to add data into data[][], so cant start with 1.
            for (int j = 0; j < columns; j++){
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }
        return data;
    }
}
