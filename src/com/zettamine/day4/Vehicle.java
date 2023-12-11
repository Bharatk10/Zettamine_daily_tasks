package com.zettamine.day4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle implements Loan,Insurance {
	
	private String vehicleNumber;
	private String modelName;
	private VehicleType vehicleType;
	private double price;
	
	@Override
	public double takeInsurance() {
		
		if(this.vehicleType.equals("FOUR_WHEELER")) {
			return price*0.8;
		}
		if(this.vehicleType.equals("THREE_WHEELER")) {
			
			return price*0.75;
		}
		else {
			return price*0.5;
		}
		
	}
	@Override
	public double issueLoan() {
		
		if(this.price<=150000) {
			return 3500;
		}
		else if(this.price>150000 && this.price<=300000) {
			return 4000;
		}
		else {
			return 5000;
		}
	}

}
