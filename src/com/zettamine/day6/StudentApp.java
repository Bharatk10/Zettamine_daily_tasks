package com.zettamine.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentApp {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Student> students = new ArrayList<>();
		String details;
		while(true) {
			
			System.out.println("Enter Student’s Name, Location, Email and Mobile:  ");
			details = sc.nextLine();
			
		
	   
		String[] detailsArr = details.split(" ");
		
		try{
			students.add(new Student(detailsArr[0],detailsArr[1],detailsArr[2],
					Long.parseLong(detailsArr[3])));
		}catch(Exception e){
			System.out.println("Enter the Data in this format [String String String Long]");
		}
		char check = readData();
		if(check == 'n' || check == 'N') {
			break;
		}
		}
		HashMap<String,Integer> result = StudentReport.getReport(students);
		
		System.out.printf("\n%-15s %s\n","Location","Count");
		System.out.println("~".repeat(30));
		for(Entry<String,Integer> entry : result.entrySet()) {
			System.out.printf("%-20s %d\n",entry.getKey(),entry.getValue());
		}
		
	}

	private static char readData() {
		System.out.print("Do you want to add more students[Y/N]: ");
		String option = sc.nextLine();
		if(option.equalsIgnoreCase("y")|option.equalsIgnoreCase("n")) {
			return option.charAt(0);
		}
		System.err.println("Enter only Y or N");
		return readData();
	}

}
