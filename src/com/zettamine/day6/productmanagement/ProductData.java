package com.zettamine.day6.productmanagement;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
	
	List<Product> productData = new ArrayList<>();
	
	public void  addProduct(Product product) {
		productData.add(product);
		System.out.println("Product added");
	}
	public List<Product> getAllProducts(){
		return productData;
	}
	public List<Product> searchProduct(double lowerLimit,double upperLimit) {
		List<Product> products = new ArrayList<>();
		for (Product product : productData) {
			if(product.getPrice()>=lowerLimit && product.getPrice()>=lowerLimit) {
				products.add(product);
			}
		}
		
		return products;
		
	}
	

}
