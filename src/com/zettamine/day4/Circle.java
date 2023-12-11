package com.zettamine.day4;

import lombok.Getter;

@Getter
public class Circle extends Shape{
	
	private double radius;
	
	@Override
	double area() {
		return Math.PI*Math.pow(radius, radius);
	}

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	@Override
	double volume() {
		// TODO Auto-generated method stub
		return -1;
	}

	

}
