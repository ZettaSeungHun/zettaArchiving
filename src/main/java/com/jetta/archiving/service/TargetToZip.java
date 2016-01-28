package com.jetta.archiving.service;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jetta.archiving.conf.Conf;
import com.jetta.archiving.conf.ZConfiguration;
import com.jetta.archiving.utils.ZTime;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class TargetToZip {

	final static Logger logger = Logger.getLogger(TargetToZip.class);
	
	// 폴더를 백업
	public void folderToZip(String path, String where){
		 
		try {
			
			Properties prop = ZConfiguration.getProp();
			String rootPath = prop.getProperty(Conf.backupResultRootDir);

			  String milliseconds = ZTime.getCurrentDateTime();			  
			  String zipFilePath = rootPath + path.replace(":", "").replace('\\', '_') +"_"+milliseconds+".zip";
			  
			  if(logger.isDebugEnabled()){
				  logger.debug("\n백업파일경로 : " + zipFilePath);
			  }

			  // Initiate ZipFile object with the path/name of the zip file.
			  ZipFile zipFile = new ZipFile(zipFilePath);
			  
			  //System.out.println(zipFile.toString());
			  
			  // Folder to add
			  String folderToAdd = path;

			  // Initiate Zip Parameters which define various properties such
			  // as compression method, etc.
			  ZipParameters parameters = new ZipParameters();

			  // set compression method to store compression
			  parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

			  // Set the compression level
			  parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			  // Add folder to the zip file
			  zipFile.addFolder(folderToAdd, parameters);

			 } catch (Exception e) {
				 logger.error(e);
			 }
		
	}
	
	// 파일을 백업
	public void fileToZip(String path, String where){
		 
		try {
			
			  Properties prop = ZConfiguration.getProp();
			  String rootPath = prop.getProperty(Conf.backupResultRootDir);

			  String milliseconds = ZTime.getCurrentDateTime();			  
			  String zipFilePath = rootPath + path.replace(":", "").replace('\\', '_') +"_"+milliseconds+".zip";

			  if(logger.isDebugEnabled()){
				  logger.debug("백업파일경로 : " + zipFilePath);
			  }
			  
			  // Initiate ZipFile object with the path/name of the zip file.
			  ZipFile zipFile = new ZipFile(zipFilePath);
			  
			  // Folder to add
			  //String filePath = path;

			  // Initiate Zip Parameters which define various properties such
			  // as compression method, etc.
			  ZipParameters parameters = new ZipParameters();

			  // set compression method to store compression
			  parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

			  // Set the compression level
			  parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			  // Add folder to the zip file
			  zipFile.addFile(new File(path), parameters);
			  //zipFile.createZipFile(new File(path), parameters);

			 } catch (Exception e) {
				 logger.error(e);
			 }
		
	}	
}
