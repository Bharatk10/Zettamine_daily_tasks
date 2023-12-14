package com.zettamine.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManipulation {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Library library = new Library();
		List<Book> bookList = library.viewAllBooks();
		
		while(true) {
			System.out.println("1. Add Book\r\n"
					+ "2. Display all Book Details\r\n"
					+ "3. Search Book by Author \r\n"
					+ "4. Count Number of books - by book name\r\n"
					+ "5. Exit\r\n"
					+ "");
			System.out.print("Enter your choice: ");
			
			int option = sc.nextInt();
			System.out.println("~".repeat(30));
			switch(option) {
				case 1 : System.out.print("Enter the isbNo: ");
						 long isbNo = sc.nextLong();
						 sc.nextLine();
						 System.out.print("Enter the book name: ");
						 String bName = sc.nextLine();
						 System.out.print("Enter the author name: ");
						 String author = sc.nextLine();
						 library.addBook(new Book(isbNo,bName,author));
						 break;
				case 2 : for (Book book : bookList) {
								book.getDetails();
						 }
						 System.out.println("~".repeat(30));
						break;
				case 3 : sc.nextLine();
					     System.out.print("Enter the author name: ");
						 String authorName = sc.nextLine();
						 System.out.println();
						 ArrayList<Book> books = library.viewBooksByAuthor(authorName);
						 if(books.size()>0) {
							 for (Book book : books) {
									book.getDetails();
							 }
							 System.out.println("~".repeat(30));
						 }
						 else {
							 System.out.println("None of the book published by the author: "+authorName); 
						 }
						 System.out.println();
						 break;
				case 4 : sc.nextLine();
					     System.out.print("Count number of books - by book name: ");
				 		 String bookName = sc.nextLine();
				 		 int count = library.countNoOfBook(bookName);
				 		 if(count>0) {
				 			 System.out.println("The No of "+bookName+" books available are: "+count);
				 			 System.out.println();
				 			 break;
				 		 }
						 System.out.println("None of the books are  available by the book name "+bookName);
				 		 break;
				case 5 : System.out.println("---\tApplication was Developed by Team Zettamine\t---");
						 System.out.println("---\t\t\tThank You\t\t\t---");
						 System.exit(0);
				         break;
				default : System.err.println("Invalid Option Please try again");
						  System.out.println();
				          break;
			}
			
		}
	}

}
