package com.zettamine.day6.productmanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductApplication {

	static Scanner sc = new Scanner(System.in);
	
	static Product product;

	public static void main(String[] args) {
		
		ProductData productData = new ProductData();
		
		List<Product> products = productData.getAllProducts();
		
		
		
		while(true) {
			System.out.println("1. Add Product Details\n2. Search product based on price range\n3. "
					+ "Close");
			System.out.println("Enter choice:");
			
			int option = sc.nextInt();
			
			switch(option) {
				
				case 1  : System.out.println("How many records you want to store");
						  int noOfProducts = sc.nextInt();
						  sc.nextLine();
						  while(noOfProducts!=0) {
							  System.out.println("Enter Laptop Details");
							  System.out.println("Enter Product Code");
							  String pCode = sc.nextLine();
							  System.out.println("Enter Product Name:");
							  String pName = sc.nextLine();
							  System.out.println("Pieces Avilable");
							  int count = sc.nextInt();
							  System.out.println("Enter Product Price");
							  double price = sc.nextDouble();
							  sc.nextLine();
							  product = new Product(pCode,pName,count,price);
							  productData.addProduct(product);
							  studentDataSave(product);
							  noOfProducts--;
						  }
						  System.out.println("All Products details accepted");
						  System.out.println("Products are added into file for future retrieval");
				          break;
				case 2  : System.out.println("Enter Upper price value");
						  double upperPrice = sc.nextDouble();
						  sc.nextLine();
						  System.out.println("Enter Lower price value");
						  double lowerPrice = sc.nextDouble();
						  sc.nextLine();
						  List<Product> prod = productData.searchProduct(lowerPrice, upperPrice);
						  for (Product product : prod) {
							product.getDetails();
						}
						  break;
				case 3  : System.out.println("This application was developed by Team Zettamine");
						  System.out.println("--\tThank Tou\t---");
						  System.exit(0);
						  break;
			    default : System.out.println("Please enter valid option");
			              break;
			}
			
		}
		
	}
	
	private static void studentDataSave(Product product) {
		
		
		try (FileWriter fw = new FileWriter("productData.txt",true)){ 
		
				fw.write(product.toString());
				fw.write("\n");
			}catch (IOException e) {
				e.printStackTrace();
			}
			 
		} 
		
		
}
	
