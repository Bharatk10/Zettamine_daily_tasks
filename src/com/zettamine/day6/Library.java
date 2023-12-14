package com.zettamine.day6;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	List<Book> bookList = new ArrayList<>();
	
	public void addBook(Book bobj) {
		System.out.println(bobj);
		bookList.add(bobj);
		System.out.println("---\tThe Book is added to the Library\t---");
	}
	List<Book> viewAllBooks() {
		return bookList;
	}
	public ArrayList<Book> viewBooksByAuthor(String author ){
		ArrayList<Book> books = new ArrayList<>();
		 for (Book book : bookList) {
				if(book.getBookAuthor().equalsIgnoreCase(author)) {
					books.add(book);
				}
			}
		return books;
	}
	public int countNoOfBook(String bname) {
		int count = 0;
		for (Book book : bookList) {
			if(book.getBookTitle().equalsIgnoreCase(bname)) {
				count++;
			}
		}
		
		return count;
		
	}
	
}
