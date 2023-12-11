package com.zettamine.day4;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VehicleType vehicleType;
		
		System.out.println("To check the Loan Amount and Insurace Amount");
		
		System.out.print("Enter the Vehicle Number: ");
		String number = sc.nextLine();
		
		System.out.print("Enter the Model Name: ");
		String name = sc.nextLine();
		
		
		while(true) {
			System.out.print("Select the Vehicle Type [1.4 Wheeler |"
					+ " 2.3 Wheeler | 3.2 wheeler]: ");
			int option = sc.nextInt();
			if(option == 1) {
				vehicleType= VehicleType.FOUR_WHEELER;
				break;
			}
			else if(option == 2) {
				vehicleType= VehicleType.THREE_WHEELER;
				break;
			}
			else if(option ==3) {
				vehicleType= VehicleType.TWO_WHEELER;
				break;
			}
			else {
				System.out.println("Enter a Valid Input\nTry Again");
			}
			
		}
		System.out.print("Enter a price of a Vehicle: ");
		Double price = sc.nextDouble();
		
		
		Vehicle vehicle = new Vehicle(number,name, vehicleType, price);

        System.out.println("Loan Amount: " + vehicle.issueLoan());
        System.out.println("Insurance Amount: " + vehicle.takeInsurance());

	}

}
