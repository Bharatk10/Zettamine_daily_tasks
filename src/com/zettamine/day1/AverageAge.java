package com.zettamine.day1;

import java.util.Scanner;

public class AverageAge {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Enter no of Employee:");
		int noOfEmployee = sc.nextInt();
		if(noOfEmployee<=1) {
			System.err.println("Please enter a valid employee count");
		}
		else {
			
			System.out.printf("Enter the age of %d Employee:\n",noOfEmployee);
			
			int[] ages = readEmployees(noOfEmployee);
			
			try{
				checkEmployeeAge(ages);
				
				
				float average=calculateAverage(ages);
				
				System.out.printf("The average age is:%.2f",average);
				}catch(InvalidAgeException e){
					System.err.println(e.getMessage());
			}
			
				
		}
		
	}
	
	//calculate average age 
	private static float calculateAverage(int[] ages) {
		float total=0;
		for (int i : ages) {
			total+=i;
		}
		return (float)(total/ages.length);
		
	}
	
	//checks the age of the employee is valid or not
	private static void checkEmployeeAge(int[] ages) throws InvalidAgeException{
		for (int i : ages) {
			if(i<=28 || i>=40) {
				throw new InvalidAgeException("Invalid Age Encountered");
			}
				
		}
		
	}
	
	//Read the employees
	private static int[] readEmployees(int noOfEmployee) {
		int[] ages = new int[noOfEmployee];
		for(int i=0;i<noOfEmployee;i++) {
			ages[i]=sc.nextInt();
		}
		return ages;
	}

}
