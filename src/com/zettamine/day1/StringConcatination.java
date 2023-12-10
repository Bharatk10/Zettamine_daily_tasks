package com.zettamine.day1;

import java.util.Scanner;

public class StringConcatination {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Inmate's name:");
		String name = sc.nextLine();
		
		System.out.print("Inmate's father's name:");
		String fName = sc.nextLine();
		
		if(checkString(name) && checkString(fName)) {
			name=name.toUpperCase();
			fName=fName.toUpperCase();
			System.out.println(name+" "+fName);
		}
		else
			System.err.println("Invalid name");
		

	}
	
	//it checks whether the word contains letters or not.
	private static boolean checkString(String name) {
		
		name=name.replace(" ","");
		
		char[] charArray = name.toCharArray();
		for (char c : charArray) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
		
	}

}
