package com.jetta.archiving.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.jetta.archiving.model.Target;
import com.jetta.archiving.service.TargetToZip;
import com.jetta.archiving.service.TargetInfo;

public class MainP {

	final static Logger logger = Logger.getLogger(MainP.class);
	
	public static void main(String[] args){
		
		TargetToZip backup = new TargetToZip();
		
		List<Target> list = TargetInfo.getTargetInfo();
		
		for(Target target : list){
			
			if(logger.isDebugEnabled()){
				logger.debug("\n" + target.toString());
			}
			
			if("dir".equals(target.getType())){				
				backup.folderToZip(target.getPath(), "");
				
			}else if("file".equals(target.getType())){
				backup.fileToZip(target.getPath(), "");				
			}
		}
	}
}
