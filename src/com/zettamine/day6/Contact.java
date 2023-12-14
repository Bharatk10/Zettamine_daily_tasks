package com.zettamine.day6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	
	private String firstName;
	private String lastName;
	private long  phoneNumber;
	private String emailId;

	public void getDetails() {
		System.out.printf("First Nmae: %-10s | Last Name: %-10s | Phone number: %-10d | "
				+ "EmailId: %-18s\n",firstName,lastName,phoneNumber,emailId);
	}
	
}
