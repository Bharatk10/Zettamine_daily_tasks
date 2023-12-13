package com.zettamine.day5;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements Serializable {
	
	private static final long serialVersionUID = 8037099817277177103L;
	private int productId;
	private String productName;
	
	
	

}
