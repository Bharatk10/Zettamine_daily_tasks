package com.zettamine.day4;

public class Triangle extends Shape {
	
	private double base;
	private double height;

	@Override
	double area() {
		return (0.5f)*base*height;
	}

	public Triangle(String color, double base, double height) {
		super(color);
		this.base = base;
		this.height = height;
	}

	@Override
	double volume() {
		return -1;
	}

	

}
