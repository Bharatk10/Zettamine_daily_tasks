package com.zettamine.day1;

public class Item {
	
	private String productName;
	private int price;
	private int discount;
	
	public Item() {
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Item(String productName, int price, int discount) {
		
		this.productName = productName;
		this.price = price;
		this.discount = discount;
	}

}
