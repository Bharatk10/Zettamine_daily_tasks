package com.zettamine.day2;

public class CurrentAccount extends Account {
	
	private static String  accountType="Current";
	private final static int TRANSACTIONS=2;
	private int transactionsCount;
	
	public static String getAccountType() {
		return accountType;
	}
	
	public CurrentAccount() {
		super();
	}
	
	//It increment the transaction count when amount deposit
	@Override
	public void deposit(float amount) {
		this.transactionsCount++;
		super.deposit(amount);
	}
	//It increment the transaction count when amount withdraw 
	@Override
	public Boolean withdraw(float amount) {
		this.transactionsCount++;
		return super.withdraw(amount);
	}
	public CurrentAccount(long accountId, String accountName, float balance) {
		super(accountId, accountName, balance);
	}
	
	//It calculate the charges if transaction count exceeds the Transactions
	public float charges() {
		if(this.transactionsCount>TRANSACTIONS) {
			
			float charges = (this.transactionsCount-TRANSACTIONS)*15.5f;
			
			this.transactionsCount=0;
			
			return charges;
			
		}

		return 0f;
	}
	//It override the getDetails in Account class and includes the accountType
	@Override
	public String getDetails() {
		
		String result = super.getDetails();
		return result+" | ACCOUNT TYPE: "+accountType;
		
	}
	
}
