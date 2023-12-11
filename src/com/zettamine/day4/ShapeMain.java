package com.zettamine.day4;

import java.util.Scanner;

public class ShapeMain {

	public static void main(String[] args) {
		
		Shape shape = null;
		String color;
		Scanner sc = new Scanner(System.in);
		double length,breadth,height,radius;
		
		while(true) {
			System.out.print("Which shape do you want to work with?"
					+ "[1.Rectangle | 2.Circle | 3.Triangle | 4.Sphere 5.Cube | 6.To Exit] : ");
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1: System.out.print("Enter color of Rectangle: ");
		    color = sc.nextLine();
			System.out.print("Enter the length of Rectangle: ");
			length = sc.nextFloat();
			System.out.print("Enter the breadth of Rectangle: ");
			breadth = sc.nextFloat();
			sc.nextLine();
			shape = new Rectangle(color,length,breadth);
			getdetails(shape);
			break;
	case 2: System.out.print("Enter color of Circle: ");
		    color = sc.nextLine();
			System.out.print("Enter the radius of circle: ");
			radius = sc.nextFloat();
			sc.nextLine();
			shape = new Circle(color,radius);
			getdetails(shape);
		    break;
	case 3: System.out.print("Enter color of Triangle: ");
		    color = sc.nextLine();
			System.out.print("Enter the height of Triangle: ");
			height = sc.nextFloat();
			System.out.print("Enter the base of Triangle: ");
			double base = sc.nextFloat();
			sc.nextLine();
			shape = new Triangle(color,base,height);
			getdetails(shape);
			break;
	case 4: System.out.print("Enter color of Sphere: ");
		    color = sc.nextLine();
			System.out.print("Enter the radius of Sphere: ");
			radius = sc.nextFloat();
			sc.nextLine();
			shape = new Sphere(color,radius);
			getdetails(shape);
		    break;
	case 5: System.out.print("Enter color of Cube: ");
			color = sc.nextLine();
			System.out.print("Enter the length of Cube: ");
			length = sc.nextFloat();
			System.out.print("Enter the breadth of Cube: ");
			breadth = sc.nextFloat();
			System.out.print("Enter the height of Cube: ");
			height = sc.nextFloat();
			sc.nextLine();
			shape = new Cube(color,length,breadth,height);
			getdetails(shape);
			break;
	case 6 : System.out.println("---\tThank You\t---");
			 System.exit(0);
			 
	default:System.out.println("\nInvalid shape slection :: try again ---\t close the app"); 
			System.out.println();
			break;
			}
		}
		
	}
	private static void getdetails(Shape shape) {
		
		String className = shape.getClass().getSimpleName();
		
		System.out.println();
		System.out.println("=".repeat(20)+"SHAPE SELECTED : "+className.toUpperCase()+"=".repeat(20));
		System.out.println("Color of " +className+" is "+shape.getColor());
		System.out.println("Area of "+className+" = "+shape.area());
		if(shape instanceof Spatial) {
			System.out.println("Volume of a "+className+" = "+shape.volume());
		}
		System.out.println();
		
	}


}
