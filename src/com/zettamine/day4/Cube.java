package com.zettamine.day4;

public class Cube extends Shape implements Spatial {
	
	private double length;
    private double width;
    private double height;
    
	public Cube(String color, double length, double width, double height) {
		super(color);
		this.length = length;
		this.width = width;
		this.height = height;
	}

	@Override
	double area() {
		return (float) (2*(length*width) + 2*(length*height)+ 2*(width*height));
	}

	@Override
	double volume() {
		return length*width*height;
	}

}
