package com.jetta.archiving.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jetta.archiving.conf.Conf;
import com.jetta.archiving.conf.ZConfiguration;
import com.jetta.archiving.model.Target;

public class TargetInfo {
	
	final static Logger logger = Logger.getLogger(TargetInfo.class);
	
	public static List<Target> getTargetInfo(){
		
		Properties prop = ZConfiguration.getProp();
		String filePath = prop.getProperty(Conf.backupInfo);
		List<Target> result = new ArrayList<Target>();
		
		try {
		     
		    FileInputStream file = new FileInputStream(new File(filePath));
		     
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook(file); // 엑셀 2007이하버전, 확장자가 xls인경우 XSFWorkbook --> HSSFWorkbook
		 
		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0); // 엑셀 2007이하버전, 확장자가 xls인경우 XSSFSheet --> HSSFSheet
		     		    
		    for(int i=1; i <sheet.getLastRowNum(); i++){
		    	
		    	Row row = sheet.getRow(i);
		    	
		    	if(row == null){
		    		// 에러 처리
		    	}else{
		    		
		    		Target target = new Target();
		    		
			        Cell cell0 = row.getCell(0);
			        target.setType(cell0.getStringCellValue());
			       
			        Cell cell1 = row.getCell(1);
			        target.setPath(cell1.getStringCellValue());
			        
			        Cell cell2 = row.getCell(2);
			        target.setCycle((int)cell2.getNumericCellValue());
			        		    		
			        result.add(target);
		    	}
		    }
		    
		    file.close();
		    
		} catch (FileNotFoundException e) {
		    logger.error(e);
		} catch (IOException e) {
		    logger.error(e);
		}
	
		
		return result;
	}
	
}
