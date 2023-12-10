package com.zettamine.day3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class Student {
	
	static int count=100;
	private String studentId;
	private String studentName;
	private String studentEmail;
	static String CollegeName="Zettamine";
	
	public Student(String studentName, String studentEmail) {
		super();
		this.studentId="Zetta_"+(++count);
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}

	public void  getDetatils() {
		
		System.out.printf("%-10s | %-15s | %-30s | %-9s",studentId,studentName,studentEmail,CollegeName);
		System.out.println();
	}
	
	
	
}
