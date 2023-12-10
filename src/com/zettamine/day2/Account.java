package com.zettamine.day2;



public class Account {

	private long accountId;
	private String accountName;
	private float balance;
	
	public Account() {
		super();
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Account(long accountId, String accountName, float balance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
	}
	public void deposit(float amount) {
		
		this.setBalance(this.getBalance()+amount);
		
	}
	public Boolean withdraw(float amount) {
		
		float balance=this.getBalance();
		
		if(amount<=balance) {
			this.setBalance(balance-amount);
			return true;
		}
		return false;
	}
	
	public String getDetails() {
		String result="A/C NO: "+this.getAccountId()+" | NAME: "+
				this.getAccountName()+" | BALANCE: "+this.getBalance();
		return result;
		
	}
}
 