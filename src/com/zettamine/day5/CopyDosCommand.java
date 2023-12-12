package com.zettamine.day5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class CopyDosCommand {

	public static void main(String[] args) throws IOException {
		
		File dir1 = new File("C:/CJava");
        File dir2 = new File("C:/DJava/FJava");

        if (!dir2.exists()) {
            dir2.mkdirs();
        }

        File[] files = dir1.listFiles();

        if (files != null) {
            for (File file : files) {
            	if(file.isDirectory()) {
            		//System.out.println("File is a Directory"+file.getName());
            		File dir = new File(dir2+"/"+file.getName());
            		if(!dir.exists()) {
            			dir.mkdir();
            		}
            		File[] subFile = file.listFiles();
            		for(File f:subFile) {
            			
            			if (f.isFile()) {
                            Path sourcePath = f.toPath();
                            Path destinationPath = new File(dir, f.getName()).toPath();

                            try {
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("Copied: " + f.getName());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
            		}	
            	}
            	if (file.isFile()) {
                    Path sourcePath = file.toPath();
                    Path destinationPath = new File(dir2, file.getName()).toPath();

                    try {
                        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }

        System.out.println("Files Copied");
		
	}
}
