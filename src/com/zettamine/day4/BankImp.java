package com.zettamine.day4;

import java.util.Scanner;

class BankImp {
	
	public static void main(String[] args) {
		
		Bank bank = null;
		float amount;

		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an option to choose [1.SBI,2.ICICI]: ");
		int option = sc.nextInt();
		
		switch(option) {
			
			case 1: System.out.print("Enter an Initial Amount: ");
					amount = sc.nextFloat();
					sc.nextLine();
					bank = new SBI(amount);
					break;
			
			case 2: System.out.print("Enter an Initial Amount: ");
					amount = sc.nextFloat();
					sc.nextLine();
					bank = new ICICI(amount);
					break;
			default:System.out.println("---\tInvalid Options.---Please Enter Correct Oprions."
					+ "Try Again\t--");;
					return;
		}
		String className = bank.getClass().getSimpleName();
		System.out.println("~".repeat(30)+" Welcome to "+className+" "+"~".repeat(30));
		while(true) {
			System.out.println("1.To Deposit\n2.To Withdraw\n3.Get Balance\n4.To exit");
			System.out.print("Choose one option:");
			int select = sc.nextInt();
			if(select ==1) {
				System.out.print("Enter an Amount to Deposit: ");
				amount = sc.nextFloat();
				sc.nextLine();
				bank.deposit(amount);
			}
			else if(select ==2) {
				System.out.print("Enter an Initial Amount to Withdraw: ");
				amount = sc.nextFloat();
				sc.nextLine();
				bank.withdraw(amount);
			}
			else if(select ==3) {
				System.out.printf("The current balance is %.2f\n",bank.getBalance());
			}
			else if(select == 4) {
				System.out.println("---\tThank you\t---");
				System.exit(0);
			}
			else {
				System.out.println("Please Enter a Valid Option\n--\tTry again\t--");
			}
		}
		
	}

}
