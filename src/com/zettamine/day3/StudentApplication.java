package com.zettamine.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentApplication {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		
		String id="StudentId";
		String sname = "StudentName";
		String smail = "StudnetMail";
		String college = "CollegeName";
		
		while(true) {
			
			System.out.println("Enter Student Name and Email:");
			String name = sc.nextLine();
			String email = sc.nextLine();
			if(checkStudent(name) && checkEmail(email)) {
				String check = checkAddStudent();
				students.add(new Student(name,email));
				if(check.equals("N")) {
					break;
				}
			}
			else {
				System.err.println("--\tInvalid Name or Email\t--\n--\tPlease try again\t--");
				continue;
			}
			
		}
		System.out.println("~".repeat(75));
		System.out.printf("%-10s | %-15s | %-30s | %-9s\n",id,sname,smail,college);
		System.out.println("~".repeat(75));
		for(Student stu:students) {
			stu.getDetatils();
		}
	
	}
	//It checks the student name valid or not
	private static boolean checkStudent(String name) {
		
		String nameRegex = "^(?:[A-Za-z]+\\s?){3,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
	}
	//It checks the student email valid or not
	private static boolean checkEmail(String email) {
		
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}
	public static String checkAddStudent() {
		System.out.print("do you want to want add more students?[Y/N]:");
		String check = sc.nextLine();
		if(check.equals("Y") || check.equals("N")) {
			return check;
		}
		else {
			System.err.println("Enter Only Y or N:\n~~~~ Try again ~~~~");
		}
		
		return checkAddStudent();
	}
	
	

}
