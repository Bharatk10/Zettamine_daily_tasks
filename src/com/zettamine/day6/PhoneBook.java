package com.zettamine.day6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBook {
	
List<Contact> phoneBook = new ArrayList<>();
	
	public void addBook(Contact contact) {
		System.out.println(contact);
		phoneBook.add(contact);
		System.out.println("---\tThe contact is added to the PhoneBook\t---");
	}
	List<Contact> viewAllBooks() {
		return phoneBook;
	}
	
	public Contact viewContactByPhoneNo(long phoneNo) {
		Contact cont=null;
		for (Contact contact : phoneBook) {
			if(contact.getPhoneNumber() == phoneNo) {
				return contact;
			}
		}
		return cont;
		
	}
	public boolean removeContact(long phoneNumber) {
		long phoneNo;
		Iterator<Contact> iterator = phoneBook.iterator();
		while(iterator.hasNext()) {
			phoneNo = iterator.next().getPhoneNumber();
			if(phoneNo == phoneNumber) {
				iterator.remove();
				return true;
			}
		}
		
		return false;
		
	}
	
	

}
