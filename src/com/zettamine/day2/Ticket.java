package com.zettamine.day2;

public class Ticket {
	
	private int ticketId;
	private int price;
	private static int availableTickets;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getAvailableTickets() {
		return availableTickets;
	}
	public static boolean setAvailableTickets(int availableTickets) {
		if(availableTickets>=0) {
			Ticket.availableTickets = availableTickets;
			return true;
		}
		return false;
		
	}
	public int calculateTicketCost(int noOfTickets,int price) {
		
		if(noOfTickets<=availableTickets)
			return noOfTickets*price;
		
		return -1;
		
	}
	public Ticket(int ticketId, int price) {
		super();
		this.ticketId = ticketId;
		this.price = price;
	}
}
