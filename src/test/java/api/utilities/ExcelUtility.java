package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	//Get the no.of.rows from the sheet provided
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		
		return rowCount;
	}
	
	
	//Get the cell count of the particular row
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		
		return cellCount;
	}
	
	
	//Get the cell value
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
		
		workbook.close();
		fi.close();
		
		return data;
	}
	
	//Set the Cell Value
	public void setCellData(String sheetName, int rowNum, int colNum, String data ) throws IOException {
		File xlfile = new File(path);
		
		if(!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		//If sheet doesn't exists, create a new sheet
		if(workbook.getSheetIndex(sheetName)== -1) {
			workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
		}
		
		//If row doesnt exist, create a new row
		if(sheet.getRow(rowNum)== null) {
			sheet.createRow(rowNum);
			row = sheet.getRow(rowNum);
		}
		
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
	

}
