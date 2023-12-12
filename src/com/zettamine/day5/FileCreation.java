package com.zettamine.day5;

import java.io.File;
import java.io.IOException;

public class FileCreation {

	public static void main(String[] args) {
		
		File dir = new File("C:/CJava/Java");
		
		if(!dir.exists()) {
			dir.mkdirs();
			System.out.println("CJava Directory Created");
		}
		else {
			System.out.println("Directory already existed");
		}
			File file = new File("C:/CJava/Java/Java.txt");
			if(file.exists()) {
				System.out.println("File Java.txt already exists");
			}
			else {
				try {
					file.createNewFile();
					System.out.println("File Java.txt Created");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Catch block");
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		

		
		
	}

