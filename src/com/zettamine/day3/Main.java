package com.zettamine.day3;

import java.util.Scanner;

public class Main {
	
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		 Hosteller hosteller = getHostellerDetails();

         System.out.println("The Student Details are as follows:");
         System.out.println("Student ID: " + hosteller.getStudentId());
         System.out.println("Student Name: " + hosteller.getName());
         System.out.println("Department ID: " + hosteller.getDepartmentId());
         System.out.println("Student Gender: " + hosteller.getGender());
         System.out.println("Student Phone No: " + hosteller.getPhone());
         System.out.println("Hostel Name: " + hosteller.getHostelName());
         System.out.println("Room No: " + hosteller.getRoomNumber());
	}
	
	
	public static Hosteller getHostellerDetails() {
       
        System.out.println("Enter the Student Details & Hostel Details:");

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Student Name: ");
        sc.nextLine(); 
        String name = sc.nextLine();

        System.out.print("Department ID: ");
        int departmentId = sc.nextInt();

        sc.nextLine();   
        String gender = checkGender();

        System.out.print("Phone Number: ");
        String phone = sc.next();

        System.out.print("Hostel Name: ");
        sc.nextLine(); 
        String hostelName = sc.nextLine();

        System.out.print("Room Number: ");
        int roomNumber = sc.nextInt();
        
        sc.nextLine();
        char modifyRoom = checkChangeRoomNo().charAt(0);

        if (modifyRoom == 'Y' || modifyRoom == 'y') {
            System.out.print("New Room Number: ");
            int newRoomNumber = sc.nextInt();
            roomNumber = newRoomNumber;
            sc.nextLine();
        }
        
        char modifyPhone = checkChangePhoneNo().charAt(0);

        if (modifyPhone == 'Y' || modifyPhone == 'y') {
            System.out.print("New Phone Number: ");
            String newPhoneNumber = sc.next();
            phone = newPhoneNumber;
        }
        
        return new Hosteller(studentId, name, departmentId, gender, phone, hostelName, roomNumber);
    }
	
	public static String checkChangeRoomNo() {
		System.out.print("Modify Room Number?[Y/N]:");
		
		String check = sc.nextLine();
		if(check.equals("Y") || check.equals("N")) {
			return check;
		}
		else {
			System.err.println("Enter Only Y or N:\n~~~~ Try again ~~~~");
		}
		
		return checkChangeRoomNo();
	}
	public static String checkChangePhoneNo() {
		System.out.print("Modify Phone Number?[Y/N]:");
		String check = sc.nextLine();
		if(check.equals("Y") || check.equals("N")) {
			return check;
		}
		else {
			System.err.println("Enter Only Y or N:\n~~~~ Try again ~~~~");
		}
		
		return checkChangePhoneNo();
	}
	//It checks whether we enter correct input or not for gender
	public static String checkGender() {
		System.out.print("Gender?[M/F]:");
		String check = sc.nextLine();
		if(check.equals("M") || check.equals("m")) {
			return "Male";
		}
		else if(check.equals("F") || check.equals("f")) {
			return "Female";
		}
		
		else {
			System.err.println("Enter Only M or F:\n~~~~ Try again ~~~~");
		}
		
		return checkGender();
	}
	

}
