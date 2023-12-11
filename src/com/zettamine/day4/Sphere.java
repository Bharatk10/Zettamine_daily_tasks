package com.zettamine.day4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Sphere extends Shape implements Spatial {
	
    private double radius;


    @Override
    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4 * Math.PI * radius * radius * radius) / 3;
    }

	public Sphere(String color, double radius) {
		super(color);
		this.radius = radius;
	}
    
}