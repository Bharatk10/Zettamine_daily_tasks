package com.zettamine.employee;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeSerializeEmployees {
	
	static Map<Employee,HashSet<Certification>> employeeMap ;
	
	
	
	public static void deSerializeEmloyees(String filePath) throws FileNotFoundException {
		
		final FileInputStream fis = new FileInputStream(filePath);
		try(ObjectInputStream ois = new ObjectInputStream(fis)){
			
			employeeMap = (Map<Employee,HashSet<Certification>>) ois.readObject();
			System.out.println("Deserialization completed");
			System.out.println("~".repeat(20));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		 String fileName = "C:\\Users\\Bharat Kumar\\Desktop\\SampleData.txt";
		
		try {
			deSerializeEmloyees(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Entry<Employee, HashSet<Certification>> entry : employeeMap.entrySet()) {
	        Employee employee = entry.getKey();
	        HashSet<Certification> certifications = entry.getValue();

	        System.out.println("Employee: " + employee);
	        System.out.println("Certifications: " + certifications);
	        System.out.println("~".repeat(20));
	    }
		
	}

}
