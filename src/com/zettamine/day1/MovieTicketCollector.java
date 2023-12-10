package com.zettamine.day1;

import java.util.Scanner;

public class MovieTicketCollector {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no of ticket:");
		int numberOFTickets=sc.nextInt();
		if(checkNoOFTickets(numberOFTickets)) {
			System.out.print("Do you want refreshment:");
			char refreshments=sc.next().charAt(0);
			System.out.print("Do you have coupon code:");
			char coupon =sc.next().charAt(0);
			System.out.print("Enter the circle:");
			char circle =sc.next().charAt(0);
			if(checkCircle(circle)) {
				System.out.printf("Ticket cost: %.2f", calculateTotalCost(numberOFTickets, refreshments, coupon, circle));
			}
			else {
				System.err.print("Invalid Input");
				
			}
		}
		else {
			System.err.print("Minimum of 5 and Maximum of 40 Tickets");
		}
	}
	
	//it checks the tickets are in the given range(5,40)
	private static boolean checkNoOFTickets(int numberOFTickets) {
		
		if(numberOFTickets>=5 && numberOFTickets<=40)
			return true;
		return false;
	}
	//It checks whether we enter correct options.
	private static boolean checkCircle(char ch) {
			
		if(ch == 'K' || ch == 'Q')
			return true;
		return false;
	}
	//calculate price based on the NoOfTickets,refreshments,circle and the coupon.
	private static float calculateTotalCost(int numberOFTickets, char refreshments, 
			char coupon, char circle) {
		float total;
		
		total=(circle == 'K')?numberOFTickets*75:numberOFTickets*150;
		
		if(numberOFTickets > 20) {
			total=(float) (total-(total*0.10));
		}
		if(coupon == 'Y') {
			total=(float)(total-(total*0.02));
		}
		if(refreshments == 'Y') {
			total=(float)(total+(50*numberOFTickets));
		}
		
		return total;
	}
}
