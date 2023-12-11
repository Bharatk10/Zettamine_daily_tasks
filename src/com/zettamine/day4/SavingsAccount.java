package com.zettamine.day4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	
	private double minimumBalance;

	public SavingsAccount(int accountNumber, Customer customerObsj, double balance,double minimumBalance) {
		super(accountNumber, customerObsj, balance);
		this.minimumBalance = minimumBalance;
		
	}

	@Override
	public boolean withdraw(double amount) {
		
		if (this.balance - amount >= this.minimumBalance) {
            this.balance -= amount;
            System.out.printf("Rs.%.2f Debited | Balance: %.2f Rs.", amount,this.balance);
            return true;
        } else {
            System.out.println("--\tWithdrawal failed. Insufficient balance.\t--");
            return false;
        }
	}

}
