package com.zettamine.day6;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentReport {
	
	
	
	static HashMap<String,Integer> getReport(ArrayList<Student>  studentlist) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for (Student student : studentlist) {
			map.put(student.getLocation(), map.getOrDefault(student.getLocation(), 0)+1);
		}
		return map;
		
	} 

}
