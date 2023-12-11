package com.zettamine.day4;

import lombok.Getter;


@Getter
public class Rectangle extends Shape {
	
	private double length;
	private double breadth;

	@Override
	double area() {
		
		return length * breadth;
	}

	public Rectangle(String color, double length, double breadth) {
		super(color);
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	double volume() {
		// TODO Auto-generated method stub
		return -1;
	}

	
}
