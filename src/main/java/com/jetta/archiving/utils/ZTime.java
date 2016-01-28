package com.jetta.archiving.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ZTime {

	public static void main(String[] args){
		
		System.out.println(ZTime.getCurrentDateTime());		
	}
	
	public static String getCurrentDateTime(){
		
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		return format.format(date);
	}
}
