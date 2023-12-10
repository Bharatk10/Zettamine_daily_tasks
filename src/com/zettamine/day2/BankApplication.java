package com.zettamine.day2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankApplication {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	 
	static Scanner sc = new Scanner(System.in);
	
	static Account account = null;

	public static void main(String[] args) {
		
		System.out.println(ANSI_GREEN+"---\tWelcome to State Bank of India\t---"+ANSI_RESET);
		
		while(true) {
			
			System.out.println("1.Create Account");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Details");
			System.out.println("5.Calculate Intrest");
			System.out.println("6.Calculate Transaction Charges");
			System.out.println("7.Exit");
			
			System.out.print("Enter an option to Proceed:");
			int option = sc.nextInt();
			
			switch(option){
				case 1 : if(account==null) {
							createAccount();
						 }else {
							System.out.println(ANSI_RED+"--\tAccount is already opened\t--\n--\tPlease choose an option\t--"+ANSI_RESET); 
						 }
						 break;
				case 2 : try{
							depositMoney();
						 }catch(NullPointerException e){
							System.out.println(ANSI_RED+"--\tAccount is not opened yet\tPlease open an Account\t--"+ANSI_RESET);
						 }
						 break;
				case 3 : try{
							withdrawMoney();
						 }catch(NullPointerException e) {
							 System.out.println(ANSI_RED+"--\tAccount is not opened yet\t Please open an Account\t--"+ANSI_RESET);
						 }break;
				case 4 : try{
							System.out.println(accountDetails());
						 }catch(NullPointerException e){
							 System.out.println(ANSI_RED+"--\tAccount is not opened yet\t Please open an Account\t--"+ANSI_RESET);
						 }
					     break;
				case 5 : try{
							if(account instanceof SavingsAccount) {
								SavingsAccount sAccount = (SavingsAccount) account;
								float intrest = sAccount.calculateIntrest();
								account.deposit(intrest);
								System.out.printf("The calculated Intrest %.2f",intrest);
								System.out.printf(ANSI_GREEN+"%.2fRs Credited | Balance: %.2fRs."+ANSI_RESET,intrest,account.getBalance());
								System.out.println();
							}
							else {
								System.out.print(ANSI_RED+"--\tThis feature is not available with your Account\t--\n");
								System.out.println("--\tPlease contact our Bank administration\t--"+ANSI_RESET);
							}
						 }catch(NullPointerException e){
							 System.out.println(ANSI_RED+"--\tAccount is not opened yet\t Please open an Account\t--"+ANSI_RESET);
						 }break;
				case 6 : try{
							if(account instanceof CurrentAccount) {
								CurrentAccount cAccount = (CurrentAccount) account;
								float charges = cAccount.charges();
								if(charges>0) {
									account.withdraw(charges);
									System.out.printf(ANSI_GREEN+"%.2fRs Debited | Balance: %.2fRs."+ANSI_RESET,charges,account.getBalance());
									System.out.println();
								}
								else {
									System.out.println(ANSI_GREEN+"--\tThe Transaction limit is not reached yet\t--"+ANSI_RESET);
								}
								
							}
							else {
								System.out.print(ANSI_RED+"--\tThis feature is not available with your Account\t--\n");
								System.out.println("--\tPlease contact our Bank administration\t--"+ANSI_RESET);
							}	
						}catch(NullPointerException e){
							 System.out.println(ANSI_RED+"--\tAccount is not opened yet\t Please open an Account\t--"+ANSI_RESET);
						 }break;
				case 7 :System.out.print(ANSI_RED+"--\tTHNAK YOU\t--\n");
						System.out.print("--\tApplication was Developed by Zetta Team\t --"+ANSI_RESET);
				 		System.exit(0); 
						break;
				default: System.out.print(ANSI_RED+"--\tInvalid Option ... Please Try again\t--\n"+ANSI_RESET);
						 break;
			}
			
		}
		
	}
	//Withdraw money
	private static void withdrawMoney(){
		
		float amount = readAmount();
		if(account.withdraw(amount)) {
			System.out.printf(ANSI_GREEN+"--\t%.2fRs Debited | Balance: %.2fRs.\t--"+ANSI_RESET,amount,account.getBalance());
			System.out.println();
		}
		else {
			System.err.println(ANSI_RED+"--\tERROR --> Insufficient Balance\t--"+ANSI_RESET);
		}
	}
	//It prints the details of the account holder
	private static String accountDetails() {
		account.getAccountId();
		if(account instanceof SavingsAccount) {
			SavingsAccount sAccount = (SavingsAccount) account;
			return sAccount.getDetails();
		}
		else {
			CurrentAccount cAccount = (CurrentAccount) account;
			return cAccount.getDetails();
		}
	}
	//To create account in the bank
	private static void createAccount() {
		
		int select=selectAccountType();
		if(select == 1) {
			
			long accountNo =readAccountNo();
			sc.nextLine();
			String name = readName();
			float amount = readInitialAmount();
			account = new SavingsAccount(accountNo,name,amount);
			System.out.println(ANSI_GREEN+"--\tA/C Opened\t--"+ANSI_RESET);
			
		}
		else{
			
			long accountNo =readAccountNo();
			sc.nextLine();
			String name = readName();
			float amount = readInitialAmount();
			account = new CurrentAccount(accountNo,name,amount);
			System.out.println(ANSI_GREEN+"--\tA/C Opened\t--"+ANSI_RESET);
		}
	}
	
	//it read the account no from user and it make sure to enter 
	//only digits and minimum of 6 digits.
	private static long readAccountNo() {
		
		System.out.print("Enter Account Number:");
		
		String numberRegex = "^[0-9]{6,}$";
		String accountNo = sc.next();
		if (accountNo.matches(numberRegex)) {
		   return Long.parseLong(accountNo);
		} else {
			System.out.println(ANSI_RED+"--\tIt should accpts only numbers and minium of 6 digits\t--"+ANSI_RESET);
		    return readAccountNo();
		}
        
	}
	//It read the account name from user and it takes only alphabets.
	private static String readName() {
		
		System.out.print("Enter Account Holder Name:");
		
		String nameRegex = "^(?:[A-Za-z]+\\s?){3,}$";
		String accountName = sc.nextLine();
		if (accountName.matches(nameRegex)) {
		   return accountName;
		} else {
			System.out.println(ANSI_RED+"--\tPlease Enter a valid proper name\t--"+ANSI_RESET);
		    return readName();
		}
        
	}
	//To deposit money
	private static void depositMoney() {
		account.getAccountId();
		float amount = readAmount();
		
		account.deposit(amount);
		System.out.printf(ANSI_GREEN+"%.2fRs Credited | Balance: %.2fRs."+ANSI_RESET,amount,account.getBalance());
		System.out.println();
	}
	//To read the amount from user for deposit and withdraw operations
	private static float readAmount()  {
		account.getAccountId();
		System.out.print("Enter Amount:");
		float amount = sc.nextFloat();
		if(amount<=0) {
			System.out.println(ANSI_RED+"--\tAmount can't be Negative or Zero\t--"+ANSI_RESET);
			return readAmount();
		}
		return amount;
	}
	//TO select which account Savings or Current
	private static int selectAccountType() {
		
		System.out.print("Enter an Option for choosing Account Type\n"
				+ "1.Savings Acount\n2.Current Acount\n");
		int number = sc.nextInt();
		
		if(number == 1 || number ==2 )
			return number;
		else {
			System.out.println(ANSI_RED+"--\tPlease choose 1 or 2\t--"+ANSI_RESET);
		}
		return selectAccountType();
		
	}
	//It read the initial amount when user opens an Account.
	private static float readInitialAmount(){
		
		System.out.print("Enter Initial Deposit:");
		float amount = sc.nextFloat();
		if(amount<0) {
			System.out.println(ANSI_RED+"--\tAmount can't be Negative.\t--"+ANSI_RESET);
			return readInitialAmount();
		}
		return amount;
	}
}
