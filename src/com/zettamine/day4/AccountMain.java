package com.zettamine.day4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountMain {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

        int accountNumber = readNumber();
        
        System.out.print("Enter customer id: ");
        int customerId = sc.nextInt();
        sc.nextLine();
        
        String customerName = readName();
        
        String emailId = readEmail();
        
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        
        System.out.print("Enter minimum balance: ");
        double minimumBalance = sc.nextDouble();
        sc.nextLine();
        Customer customer = new Customer(customerId, customerName, emailId);
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, customer, balance, minimumBalance);

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        savingsAccount.withdraw(amount);
        
	}
	private static String readName() {
		
		System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        if(checkCustomerName(name)) {
        	return name;
        }
        System.out.println("Invalid Name Entered\nPlease Try Again.");
		return readName();
	}
	private static String readEmail() {
		
	   System.out.print("Enter customer email: ");
       String email = sc.nextLine();
       if(checkCustomerEmail(email)) {
       	return email;
       }
       System.out.println("Invalid email Entered\nPlease Try Again.");
		return readEmail();
	}
	private static int readNumber() {
		
		   System.out.print("Enter A/C number: ");
	       String number = sc.nextLine();
	       if(checkNumber(number)) {
	       	return Integer.parseInt(number);
	       }
	       System.out.println("Invalid A/C number Entered\nPlease Try Again.");
			return readNumber();
		}
	private static boolean checkCustomerName(String name) {
		
		String nameRegex = "^(?:[A-Za-z]+\\s?){3,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
	}
	private static boolean checkCustomerEmail(String email) {
		
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}
	private static boolean checkNumber(String number) {
		
		
		if(number.matches("^[0-9]+$")) {
			return true;
		}
		return false;
	}

}
