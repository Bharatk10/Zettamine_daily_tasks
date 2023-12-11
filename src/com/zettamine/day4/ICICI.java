package com.zettamine.day4;

public class ICICI implements Bank {
	
	private float  balance;
	
	public ICICI(float balance) {
		super();
		this.balance = balance;
	}

	@Override
	public void deposit(float amount) {
		this.balance+=amount;
		System.out.printf("The deposited amount is %.2f and the total balance is %.2f\n",amount,this.balance);
	}

	@Override
	public void withdraw(float amount) {
		if(amount<=this.balance) {
			this.balance-=amount;
			System.out.printf("The debited amount is %.2f and the total balance is %.2f\n",amount,this.balance);
		}
		else {
			System.out.println("---\tInsufficient Balance\t---");
		}
		
	}
	@Override
	public float getBalance() {
		
		return this.balance;
	}

}
