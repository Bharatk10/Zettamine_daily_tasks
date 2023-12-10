package com.zettamine.day2;

public class LoanCalculator {

	public static void main(String[] args) {

		PermanentEmployee permanentEmployee = new PermanentEmployee(1, "Bharat", 500000.0);
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(2, "Kumar", 200, 1000);
        System.out.println("Loan Amount for Permanent Employee: "+calculateLoanAmount(permanentEmployee));
        System.out.println("Loan Amount for Temporary Employee: "+calculateLoanAmount(temporaryEmployee));
	}
	//Calculate the Loan based upon PermanentEmployee or TemporaryEmployee
	public static double calculateLoanAmount(Employee employee) {
        if (employee instanceof PermanentEmployee) {
            return 0.15 * employee.getSalary();
        } else if (employee instanceof TemporaryEmployee) {
            return 0.10 * employee.getSalary();
        }
        return 0.0;

    }

}
