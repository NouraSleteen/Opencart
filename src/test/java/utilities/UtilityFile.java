package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityFile {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	String file;

	public UtilityFile(String file) {
		this.file = file;
	}

	public int getRowCount(String sheet) throws IOException {
		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		wsheet = workbook.getSheet(sheet);
		int rowcount = wsheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}

	public int getCellCount(String sheet, int rownum) throws IOException {
		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		wsheet = workbook.getSheet(sheet);
		row = wsheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;

	}

	public String getCellData(String sheet, int rownum, int colom) throws IOException {
		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		wsheet = workbook.getSheet(sheet);
		row = wsheet.getRow(rownum);
		/*
		 * if (row == null) { workbook.close(); return ""; }
		 */

		cell = row.getCell(colom);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}

	// Update cell data

	public void setCellData(String sheet, int rownum, int colom, String data) throws IOException {
		File xfile = new File(file);
		if (!xfile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(file);
			workbook.write(fo);
		}

		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		if (workbook.getSheetIndex(sheet) == -1)
			workbook.createSheet(sheet);
		wsheet = workbook.getSheet(sheet);
		if (wsheet.getRow(rownum) == null)
			wsheet.createRow(rownum);
		row = wsheet.getRow(rownum);
		cell = row.createCell(colom);
		cell.setCellValue(data);
		fo = new FileOutputStream(file);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

}
