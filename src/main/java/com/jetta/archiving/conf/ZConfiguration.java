package com.jetta.archiving.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ZConfiguration {

	final static Logger logger = Logger.getLogger(ZConfiguration.class);
	
	private static Properties prop = null;
	private static InputStream input = null;
	
	public static Properties getProp(){
		
		// static 함수안에 객체 생성하는 부분은 프로세스를 수정할 필요가 있을 것 같음.
		prop = new Properties();
		
		try {
			input = new FileInputStream(Conf.propertiesDir);
			prop.load(input); // load a properties file
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			
		} catch (IOException e) {
			logger.error(e);
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e);
					
				}
			}
		}	
		
		return prop;		
	}
}
