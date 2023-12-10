package com.zettamine.day2;

public class SavingsAccount extends Account {
	
	private static String accountType="Savings";
	
	private static float roi=3.75f;

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(long accountId, String accountName, float balance) {
		super(accountId, accountName, balance);
	}
	
	public String getAccountType() {
		return accountType;
	}
	//Calculate the Intrest
	public float calculateIntrest() {
		
		float balance = SavingsAccount.super.getBalance();
		
		return  (balance*this.roi)/100f;
		
	}
	//It override the getDetails in Account class and includes the accountType
	@Override
	public String getDetails() {
		
		String result = super.getDetails();
		return result+" | ACCOUNT TYPE: "+accountType;
		
	}
	
	
	
	
}
