package com.zettamine.day6;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberOfWords {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's Article:");
		String article = sc.nextLine();
	
		article = article.toLowerCase();
		
		String[] words = article.split("[.,;:!? ]+");
		
		System.out.println("Number of words:"+words.length);
		
		
		TreeMap<String,Integer> wordCountMap = new TreeMap<>();
		
		for (String word : words) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
		

		 
		 System.out.println("words with count:");
		 
		 String string = "Words";
		 String count = "No of pointed word in the article";
		 
		 System.out.printf("%-10s : %-10s\n",string,count);
		 System.out.println("~".repeat(30));
		 
		for (Entry<String, Integer> entry : wordCountMap.entrySet()) {
	    	 System.out.printf("%-10s : %-10d\n",entry.getKey(),entry.getValue());
			
		}
		
		
	}

}
