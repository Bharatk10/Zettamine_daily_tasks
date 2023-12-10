package com.zettamine.day1;

import java.util.Scanner;

public class DisplayCharacters {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 4 Numbers:");
		int[] num=new int[4];
		
		for(int i=0;i<4;i++) {
			num[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
		
			System.out.println(num[i]+"-"+(char)num[i]);
		}
		
	}

}
