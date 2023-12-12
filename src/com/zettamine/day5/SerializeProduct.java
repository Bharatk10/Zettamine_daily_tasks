package com.zettamine.day5;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerializeProduct {

	static List<Product> products = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String fileName = "C:\\Users\\Bharat Kumar\\Desktop\\Stocks.ser";
		
		
		
		System.out.print("How many products to be saved: ");
		int noOfProducts = sc.nextInt();
		sc.nextLine();
		if(noOfProducts<=0) {
			System.out.println("The number Products can't be negative or Zero");
			System.err.println("---\tTry Again\t---");
			System.exit(0);
		}
		
		int num =(noOfProducts - noOfProducts)+1;
		while(noOfProducts!=0) {
			
			System.out.println("enter product id & product name of Product-"+num+" :");
			String prod = sc.nextLine();
			String[] productArr = prod.split(" ");
			//System.out.println(Arrays.toString(productArr));
			try {
				products.add(new Product(Integer.parseInt(productArr[0]),productArr[1]));
				noOfProducts--;
				num++;
			}catch(Exception e) {
				System.err.println("Enter the products in this order [int String] ---> Try again");
			}
			
		}
		
		 try {
			serializeProduct(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	private static void serializeProduct(String fileName) throws FileNotFoundException {
		
		final FileOutputStream fos = new FileOutputStream(fileName);
		try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(products);
			System.out.println("---\tSerialization completed\t---");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
