package com.zettamine.day4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Shape {
	
	private String color;
	
	abstract double area();
	abstract double volume();
	
	public Shape(String color) {
		super();
		this.color = color;
	}
	
	

}
