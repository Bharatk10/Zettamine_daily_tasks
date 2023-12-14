package com.zettamine.day6;


import java.util.List;
import java.util.Scanner;

public class PhoneBookManipulation {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		PhoneBook phoneBook = new PhoneBook();
		List<Contact> contacts = phoneBook.viewAllBooks();
		
		long number;
		
		while(true) {
			System.out.println("Menu\r\n"
					+ "1. Add Contact\r\n"
					+ "2. Display all Contacts\r\n"
					+ "3. Search Contact by phone \r\n"
					+ "4. Remove Contact\r\n"
					+ "5. Exit\r\n"
					+ "");
			System.out.print("Enter your choice: ");
			int noOfContacts = sc.nextInt();
			System.out.println("~".repeat(30));
			switch(noOfContacts) {
				case 1 :sc.nextLine();
					    System.out.print("Enter the First Name: "); 
					    String fName = sc.nextLine();
					    System.out.print("Enter the Last Name: ");
					    String lName = sc.nextLine();
					    System.out.print("Enter the Phone No.: ");
					    long phoneNo = sc.nextLong();
					    sc.nextLine();
					    System.out.print("Enter the Email: ");
					    String email = sc.nextLine();
					    phoneBook.addBook(new Contact(fName,lName,phoneNo,email));
					    break;
				case 2 : for(Contact contact : contacts) {
							 contact.getDetails();
						 }
				         break;
				case 3 : System.out.print("Enter the Phone number to search contact: ");
						 number = sc.nextLong();
						 Contact contact = phoneBook.viewContactByPhoneNo(number);
						 if(contact == null) {
							 System.out.println("There is no contact details with "+number+"\n");
						 }
						 else
						 {
							 contact.getDetails();
						 }
				         break;
				case 4 : System.out.print("Enter the Phone number to remove: ");
						 number = sc.nextLong();
						 sc.nextLine();
						 char check = readData();
						 if(check == 'n' || check == 'N') {
							System.out.println("The contact is not deleted");
							break;
						 }
						 Boolean status = phoneBook.removeContact(number);
						 if(status) {
							 System.out.println("The contact is successfully deleted.");
						 }
						 else {
							 System.out.println("The contact you entered is not in the PhoneBook");
						 }
				         break;
				case 5 : System.out.println("---\tThe application was developed by Team Zettamine\t---");
						 System.out.println("--\t\t\tThank You\t\t\t---");
				         break;
				default : System.out.println("Please choose the options below");
				          System.out.println("---\tTry Again\t---");break;
			}
		}
		

	}
	private static char readData() {
		System.out.print("Do you want to add more students[Y/N]: ");
		String option = sc.nextLine();
		if(option.equalsIgnoreCase("y")|option.equalsIgnoreCase("n")) {
			return option.charAt(0);
		}
		System.err.println("Enter only Y or N");
		return readData();
	}

}
