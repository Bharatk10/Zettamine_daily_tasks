package com.zettamine.day6;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class InsuranceBazar {

	static Scanner sc = new Scanner(System.in); 
	static HashMap<Integer,String> policyMap = new HashMap<>();
	
	public static void main(String[] args) {

		System.out.print("Enter the no of Policy names you want to store: ");
		int num = sc.nextInt();

		while(num!=0) {
			System.out.print("Enter the Policy ID : ");
			int policyId = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the Policy Name : ");
			String policyName = sc.nextLine();
			addPolicyDetails(policyId,policyName);
			num--;
		}
		System.out.print("Enter the policy type to be searched : ");
		String searchPolicyId = sc.nextLine();
		searchBasedOnPolicyType(searchPolicyId);
	}
	private static void searchBasedOnPolicyType(String searchPolicyId) {
		
		for(Entry<Integer,String> entry : policyMap.entrySet()) {
			String value = entry.getValue();
			if(value.contains(searchPolicyId)) {
				System.out.println(entry.getKey());
			}
			
		}
	}
	private static void addPolicyDetails(int policyId, String policyName) {
		
		policyMap.put(policyId, policyName);
		
	}

}
