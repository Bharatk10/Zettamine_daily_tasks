package com.zettamine.day4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	
	private int customerId;
    private String customerName;
    private String emailId;

}
