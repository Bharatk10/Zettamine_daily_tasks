package com.zettamine.day6.productmanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	
	private String prodCode;
	private String prodName;
	private int availability;
	private double price;
	
	public void getDetails() {
		System.out.printf("%-5s | %-10s | %d | %.2f",prodCode,prodName,availability,price);
	}

}
