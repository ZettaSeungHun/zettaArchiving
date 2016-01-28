package com.jetta.archiving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 엑셀파일 읽는 방법 참조
 * */
public class ReadExcelFile {

	public static void main(String[] args) throws IOException{
				
		try {
		     
		    FileInputStream file = new FileInputStream(new File("D:\\백업목록.xlsx"));
		     
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook(file); // 엑셀 2007이하버전, 확장자가 xls인경우 XSFWorkbook --> HSSFWorkbook
		 
		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0); // 엑셀 2007이하버전, 확장자가 xls인경우 XSSFSheet --> HSSFSheet
		     
		    //Iterate through each rows from first sheet
		    Iterator<Row> rowIterator = sheet.iterator();
		    while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		         
		        //For each row, iterate through each columns
		        Iterator<Cell> cellIterator = row.cellIterator();
		        while(cellIterator.hasNext()) {
		             
		            Cell cell = cellIterator.next();
		             
		            switch(cell.getCellType()) {
		                case Cell.CELL_TYPE_BOOLEAN:
		                    System.out.print(cell.getBooleanCellValue() + "\t\t");
		                    break;
		                case Cell.CELL_TYPE_NUMERIC:
		                    System.out.print(cell.getNumericCellValue() + "\t\t");
		                    break;
		                case Cell.CELL_TYPE_STRING:
		                    System.out.print(cell.getStringCellValue() + "\t\t");
		                    break;
		            }
		        }
		        System.out.println("");
		    }
		    
		    file.close();
		    FileOutputStream out = 
		        new FileOutputStream(new File("C:\\test.xls"));
		    workbook.write(out);
		    out.close();
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
