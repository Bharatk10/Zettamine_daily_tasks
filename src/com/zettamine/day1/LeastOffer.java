package com.zettamine.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeastOffer {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of items:");
		int noOfitems = sc.nextInt();
		int idx=0;
		
		List<Item> items = new ArrayList<>();
		
		while(idx<noOfitems) {
			System.out.println("Enter the Data of an item:");
			String data= sc.next();
			String[] itemArray =data.split(",");
			
			try {
				String productName= itemArray[0];
				int price =Integer.parseInt(itemArray[1]);
				int discount=Integer.parseInt(itemArray[2]);
				validatePrice(price);
				validateDiscount(discount);
				items.add(new Item(productName,price,discount));
				idx++;
			}
			catch(NegativeOrZeroPriceException e) {
				System.err.println(e.getMessage());
				System.out.println("Try Again!!!");
			}
			catch(NegativeDiscountException e) {
				System.err.println(e.getMessage());
				System.out.println("Try Again!!!");
			}
			catch(Exception e) {
				System.err.println("Enter the data in this format:(String,int,int)");
				System.out.println("Try Again!!!");
			}
			
		}
		sc.close();
		
		List<String> minDiscountItems = checkMinDiscountItems(items);
	
		
		if(minDiscountItems.size()>1) {
			 System.out.println("Items with Minimum Discount:" + String.join(" ",minDiscountItems));
	    } else {
	      System.out.println("Item with Minimum Discount:" + minDiscountItems.get(0));
	    }
		
	}

	//it validates discount if discount is negative it throws custom exception
	private static void validateDiscount(int discount) throws NegativeDiscountException {
		
		if(discount<0) {
			
			throw new NegativeDiscountException("Discount can't be in Negative");
			
		}
		
	}
	//it check price.If price is negative or zero it throw exception
	private static void validatePrice(int price) throws NegativeOrZeroPriceException {
		
		if(price<=0) {
			throw new NegativeOrZeroPriceException("Price can't be Negative or Zero");
		}
		
	}

	private static List<String> checkMinDiscountItems(List<Item> items) {
		 List<String> minDiscountItems = new ArrayList<>();
		float minDiscount=100;
		for (Item item : items) {
			float discount=((item.getPrice()*item.getDiscount())/100f);
			if (discount < minDiscount) {
		        minDiscount =  discount;
		        minDiscountItems.clear();
		        minDiscountItems.add(item.getProductName());
		      } else if (discount == minDiscount) {
		        minDiscountItems.add(item.getProductName());
		      }
		}
		return minDiscountItems;
	}

}
