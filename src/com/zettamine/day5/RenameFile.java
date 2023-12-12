package com.zettamine.day5;

import java.io.File;

public class RenameFile {

	public static void main(String[] args) {
		
		String fileName = args[0];
		
		String newFileName = args[1];
		
		File newFile = new File("C:/CJava/Java/"+newFileName);
		
		File dir = new File("C:/CJava/Java");
	
		File[] files = dir.listFiles();
		
		boolean result = true;
		
		for (File file : files) {
			if(file.getName().equals(fileName)) {
				file.renameTo(newFile);
				System.out.println("File name Changed");
				result=false;
			}
		}
		if(result) {
			System.err.println("The given "+fileName+" is not present in the  directory");
		}
		

	}

}
