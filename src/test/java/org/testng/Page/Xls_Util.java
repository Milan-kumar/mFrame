package org.testng.Page;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Xls_Util {
	FileInputStream fis = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;

	public Xls_Util(String path) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
//			System.out.println("Last row num:" + sheet.getLastRowNum());
			fis.close();
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
	}

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		if (index == -1)
			return 0;
		return sheet.getLastRowNum();
	}

	public String getCellData(String sheetName, int rowNum, String colName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return "";
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		int col_Num = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num = i;

		}
		if(col_Num==-1)
			return "";
		row = sheet.getRow(rowNum);
		cell = row.getCell(col_Num);
		if(cell==null)
			return "";
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		return "Value for"+colName+"not found";

	}

}
