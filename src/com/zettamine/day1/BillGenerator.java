package com.zettamine.day1;

import java.util.Scanner;

public class BillGenerator {
	
	
	static Scanner sc = new Scanner(System.in);
	
	static final String[] ITEMS = {"Pizzas","Puffs","Cool Drinks"};
	static final int[] PRICES = {100,20,10};
	
	
	public static void main(String[] args) {
		 
		int[] quantity =readItems();
		generateBill(quantity);
	}
	
	//read the items
	public static int[] readItems(){
		int[] quantity=new int[3];
		for(int i=0;i<quantity.length;i++) {
			System.out.print("Enter the No of "+ITEMS[i]+" bought: ");
			quantity[i]=sc.nextInt();
		}
		return quantity; 
	}
	//prints the bill
	private static void generateBill(int[] quantity) {
		
		System.out.println("Bill Details");
		int totalPrice=0;
		for(int i=0;i<quantity.length;i++) {
			System.out.printf("No of %-16s %-6d Cost: %-4d\n", 
					ITEMS[i] + ":", quantity[i], quantity[i] * PRICES[i]);
			
			totalPrice+=quantity[i]*PRICES[i];
		}
		
		System.out.println("Total price = "+totalPrice);
		System.out.println("ENJOY THE SHOW!!!");
	}

}

