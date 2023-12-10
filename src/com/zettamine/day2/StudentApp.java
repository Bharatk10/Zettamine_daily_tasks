package com.zettamine.day2;

import java.util.Scanner;

public class StudentApp {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter Student's Id:");
		int id = sc.nextInt();
		System.out.print("Enter Student's Name:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Enter Student's address:");
		String address = sc.nextLine();
		
		String collegeName = selectCollege();
		
		Student student = new Student(id,name,address,collegeName);
		
		printData(student);
		
	}

	private static void printData(Student student) {
		
		System.out.println("Student id: "+student.getStudentId());
		System.out.println("Student name: "+student.getStudentName());
		System.out.println("Address: "+student.getStudentAddress());
		System.out.println("College: "+student.getCollegeName());
		
	}
	//Selects the College
	private static String selectCollege() {
		System.out.print("Whether the student is from NIT(Yes/No): ");
		String res=sc.nextLine();
		if(res.equals("Yes") || res.equals("No")) {
			if(res.equals("Yes")) {
				return "NIT";
			}
			System.out.print("Enter College Name:");
			//sc.nextLine();
			res=sc.nextLine();
			return res;
		}
		else {
			System.err.print("Wrong Input\n");
			return selectCollege();
		}
	}

}
