package com.qa.trcrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TESTDATA_SHEET_PATH = "D:\\eclipse-workspace\\Nov2021POMSeries\\src\\main\\java\\com\\qa\\trcrm\\testdata\\TestData.xlsx";
	public static Workbook wb;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
		
		Object data[][] = null;
		try {
			FileInputStream fis=new FileInputStream(TESTDATA_SHEET_PATH);
			wb=WorkbookFactory.create(fis);
			sheet=wb.getSheet(sheetName);
			
			
			
			 data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
						data[i][j]=sheet.getRow(i+1).getCell(j).toString();
						
					}
				}
			
			
		} catch (FileNotFoundException e) {
						e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
