package com.zettamine.day6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class NumberOfNewWords {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's Article:");
		String article = sc.nextLine();
		
		article = article.toLowerCase();
		
		String[] words = article.split("[.,;:!? ]+");
		
		System.out.println("Number of words:"+words.length);
		
		
		TreeSet<String> wordCountSet = new TreeSet<>();
		
		for (String word : words) {
			wordCountSet.add(word);
        }
		
		 System.out.println("Number of unique words: " + wordCountSet.size());
		 
		 System.out.println("The words are:");
		 
		 int count=1;
		 
		 Iterator<String> iterator = wordCountSet.iterator();
		 
		 while(iterator.hasNext()) {
			 System.out.println(count+". "+iterator.next());
			 count++;
		 }
		
		
		
		
	}

}
