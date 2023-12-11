package com.zettamine.employee;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable,Comparable<Employee> {
	
	private int empId;
	private String empName;
	private int dno;
	
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public Employee(int empId, String empName, int dno) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dno = dno;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dno, empId, empName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return dno == other.dno && empId == other.empId && Objects.equals(empName, other.empName);
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dno=" + dno + "]";
	}
	

}
