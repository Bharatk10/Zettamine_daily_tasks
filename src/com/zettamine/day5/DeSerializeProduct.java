package com.zettamine.day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class DeSerializeProduct {
	
	static Scanner sc = new Scanner(System.in);
	
	static List<Product> products = new ArrayList<>();

	public static void main(String[] args) {
		String fileName = "C:\\Users\\Bharat Kumar\\Desktop\\Stocks.ser";
		try {
			deSerializeProducts(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Please enter Stock Details");
			return;
		}
		
		if(products.isEmpty()) {
			System.err.println("No Products are available in the File");
			return;
		}
		System.out.print("Enter product Id: ");
		int productId = sc.nextInt();
		sc.nextLine();
		
		boolean check = checkProductName(productId);
		if(check) {
			for(Product product : products) {
				if(product.getProductId()==productId) {
					System.out.println("Product Name is: "+product.getProductName());
				}
			}
		}
		else {
			System.err.println("Enetered Product is not in the list\n---\tTry again\t---");
		}
		
		
	}
	private static boolean checkProductName(int productId) {
		
		for(Product product : products) {
			if(product.getProductId()==productId) {
				return true;
			}
		}
		return false;
	}
	public static void deSerializeProducts(String filePath) throws FileNotFoundException {
		
		final FileInputStream fis = new FileInputStream(filePath);
		try(ObjectInputStream ois = new ObjectInputStream(fis)){
			
			 products = (List<Product>) ois.readObject();
			System.out.println("Deserialization completed");
			System.out.println("~".repeat(20));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
