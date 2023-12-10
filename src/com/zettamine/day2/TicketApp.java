package com.zettamine.day2;

import java.util.Scanner;

public class TicketApp {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Enter the No. Of Bookings: ");
		int n = sc.nextInt();
		int availableTickets=readAvilableTickets();
		while(n!=0) {
			
			if(Ticket.setAvailableTickets(availableTickets)) {
				System.out.print("Enter the Ticket Id:");
				int id = sc.nextInt();
				
				int price = readPrice();
				
				System.out.print("Enter the No Of Tickets:");
				int noOfTickets = sc.nextInt();
				Ticket ticket = new Ticket(id,price);
				System.out.println();
				System.out.println("Available tickets:"+Ticket.getAvailableTickets());
				int amount = ticket.calculateTicketCost(noOfTickets, price);
				if(amount>0) {
					System.out.println("Total amount:"+amount);
					Ticket.setAvailableTickets(availableTickets-noOfTickets);
					System.out.println("Available tickets after Booking:"
							+Ticket.getAvailableTickets());
					if(Ticket.getAvailableTickets()==0 && n!=1) {
						System.err.println("-- All tickets are sold -- ");
						n=1;
					}
					availableTickets=Ticket.getAvailableTickets();
				}
				else {
					System.out.print("---Please enter tickets less than Available tickets and try again\n");
					n++;
				}
			
				n--;
			}
			else {
				System.err.println("Enter a Positive number");
			}
		}
	}
	
	//It reads the price 
	private static int readPrice() {
		System.out.print("Enter the price:");
		int price = sc.nextInt();
		if(price<=0) {
			System.out.print("-- Price can't be Negative nor Zero\n");
			return readPrice();
		}
		
		return price;
	}
	//It read Available Tickets
	private static int  readAvilableTickets() {
		System.out.print("Enter the Availale tickets:");
		int availableTickets = sc.nextInt();
		
		return availableTickets;
	}
	

}
