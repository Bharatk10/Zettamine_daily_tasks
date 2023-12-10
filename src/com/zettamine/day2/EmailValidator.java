package com.zettamine.day2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zettamine.day3.Student;

public class EmailValidator {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.print("Enter an email to check:");
			String email = sc.nextLine();
			if(checkEmail(email)) {
				String check = tocheckExtraEmails();
				if(check.equals("N")) {
					System.out.println("--\tBYE\t--");
					break;
				}
			}
			else {
				System.err.println("--\tInvalid Email\t--\n--\tPlease try again\t--");
				continue;
			}
		}
		

	}
	private static String tocheckExtraEmails() {
		System.out.print("do you want to check more emails?[Y/N]:");
		String check = sc.nextLine();
		if(check.equals("Y") || check.equals("N")) {
			return check;
		}
		else {
			System.err.println("--\tEnter Only Y or N:\t--\n~~~~\t Try again\t~~~~");
		}
		
		return tocheckExtraEmails();
	}
	//It checks the email is valid or not
	private static boolean checkEmail(String email) {
		
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}

}
