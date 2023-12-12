package com.zettamine.day5;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements Serializable {
	
	private int productId;
	private String productName;
	
	
	

}
