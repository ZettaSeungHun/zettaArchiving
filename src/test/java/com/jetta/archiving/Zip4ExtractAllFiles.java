package com.jetta.archiving;

import com.jetta.archiving.utils.ZTime;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zip4ExtractAllFiles {

	public static void main(String[] args){
			
		String path = "D://작업장";
		 
		try {

			  String milliseconds = ZTime.getCurrentDateTime();

			  // Initiate ZipFile object with the path/name of the zip file.
			  ZipFile zipFile = new ZipFile(path+"_"+milliseconds+".zip");

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
			  e.printStackTrace();
			 }
		
	}
}
