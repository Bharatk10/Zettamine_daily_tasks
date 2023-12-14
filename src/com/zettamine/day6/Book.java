package com.zettamine.day6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
public class Book {
	
	private long isbnNo;
	private String bookTitle;
	private String bookAuthor;
	
	
	public void getDetails() {
		System.out.printf("ISBN no: %-10d | Book name: %-20s | Author name: %-15s\n",isbnNo,bookTitle,bookAuthor);
	}
	
	


}
