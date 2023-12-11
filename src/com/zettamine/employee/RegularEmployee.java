package com.zettamine.employee;

import java.util.Objects;

public class RegularEmployee extends Employee {
	
	private String pfNumber;
	public RegularEmployee() {
		// TODO Auyrtto-generated constructor stub
	}

	public String getPfNumber() {
		return pfNumber;
	}
	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public RegularEmployee(int empId, String empName, int dno,String pfNumber) {
		super(empId, empName, dno);
		this.pfNumber=pfNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pfNumber);
		return result;
	}
	
	@Override
	public String toString() {
		return "RegularEmployee [pfNumber=" + pfNumber + " " +  super.toString() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegularEmployee other = (RegularEmployee) obj;
		return Objects.equals(pfNumber, other.pfNumber);
	}
	
	
}
