package com.zettamine.day4;

import java.util.Scanner;

public class DrawingApp {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Shape shape = null;
		String color;

		System.out.print("Which shape do you want to work with?"
					+ "[1.Rectangle | 2.Circle | 3.Triangle]: ");
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
			case 1: System.out.print("Enter color of Rectangle: ");
				    color = sc.nextLine();
					System.out.print("Enter the length of Rectangle: ");
					float length = sc.nextFloat();
					System.out.print("Enter the breadth of Rectangle: ");
					float breadth = sc.nextFloat();
					sc.nextLine();
					shape = new Rectangle(color,length,breadth);
					getdetails(shape);
					break;
			case 2: System.out.print("Enter color of Circle: ");
				    color = sc.nextLine();
					System.out.print("Enter the radius of circle: ");
					float radius = sc.nextFloat();
					sc.nextLine();
					shape = new Circle(color,radius);
					getdetails(shape);
				    break;
			case 3: System.out.print("Enter color of Triangle: ");
				    color = sc.nextLine();
					System.out.print("Enter the height of Triangle: ");
					float height = sc.nextFloat();
					System.out.print("Enter the base of Triangle: ");
					float base = sc.nextFloat();
					sc.nextLine();
					shape = new Triangle(color,base,height);
					getdetails(shape);
					break;
			default:System.out.println("Invalid shape slection :: try again ---\t close the app"); 
					System.exit(0);
					//return --> It returns to main method;
					break;
		}
	}
	
	//get details of the shape
	private static void getdetails(Shape shape) {
		
		String className = shape.getClass().getSimpleName();
		
		System.out.println("=".repeat(20)+"SHAPE SELECTED : "+className.toUpperCase()+"=".repeat(20));
		System.out.println("Color of " +className+" is "+shape.getColor());
		System.out.print("Do you want to change the color[Y/N]: ");
		char ch = sc.nextLine().charAt(0);
		if(ch == 'Y' || ch == 'y') {
			System.out.print("Change the color: ");
			String color = sc.nextLine();
			shape.setColor(color);
			System.out.println("updated color of "+className+" is "+shape.getColor());
		}
		
		System.out.println("Area of "+className+" = "+shape.area());
		
	}

}
