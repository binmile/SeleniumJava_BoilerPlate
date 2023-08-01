package com.automate.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] readTestDataFromExcel(String fileName, String sheetName)
			throws FileNotFoundException, IOException {
		
		String filePath = System.getProperty("user.dir") + 
				File.separator + "src" +
				File.separator + "test" +
				File.separator + "resources" +
				File.separator + "testdata" +
				File.separator + fileName + ".csv";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][columns];

		for (int i = 1; i < rows; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columns; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				default:
					break;

				}
			}

		}
		workbook.close();
		return data;

	}

}
