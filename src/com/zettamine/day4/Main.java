package com.zettamine.day4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		 NITStudent student = getStudentDetails();

         System.out.println("The Student Details are as follows:");
         System.out.println("~".repeat(40));
         System.out.println("Student ID: " + student.getStudentId());
         System.out.println("Student Name: " + student.getName());
         System.out.println("Department ID: " + student.getDepartmentId());
         System.out.println("Student Gender: " + student.getGender());
         System.out.println("Student Phone No: " + student.getPhone());
         System.out.println("Hostel Name: " + student.getHostler().getHostelName());
         System.out.println("Room No: " + student.getHostler().getRoomNumber());
	}
	
	
	public static NITStudent getStudentDetails() {
       
        System.out.println("Enter the Student Details & Hostel Details:");

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();
        String name = readName();

        System.out.print("Department ID: ");
        int departmentId = sc.nextInt();

        sc.nextLine();   
        String gender = checkGender();
        
        String phone = readPhoneNo();

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
            sc.nextLine();
            roomNumber = newRoomNumber;
        }
        
        char modifyPhone = checkChangePhoneNo().charAt(0);

        if (modifyPhone == 'Y' || modifyPhone == 'y') {
            String newPhoneNumber = readPhoneNo();
            phone = newPhoneNumber;
        }
        
        Hosteller hosteller = new Hosteller(hostelName, roomNumber);
        
        System.out.println();
        
        return new NITStudent(studentId, name, departmentId, gender, phone,hosteller);
    }
	
	public static String checkChangeRoomNo() {
		System.out.print("Modify Room Number?[Y/N]:");
		
		String check = sc.nextLine();
		if(check.equals("Y") || check.equals("N")) {
			return check;
		}
		else {
			System.out.println("Enter Only Y or N:\n~~~~ Try again ~~~~");
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
			System.out.println("Enter Only Y or N:\n~~~~ Try again ~~~~");
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
			System.out.println("Enter Only M or F:\n~~~~ Try again ~~~~");
		}
		
		return checkGender();
	}
	private static String readName() {
		System.out.print("Student Name: ");
        String name = sc.nextLine();
        if(checkStudentName(name)) {
        	return name;
        }
        System.out.println("Invalid Name Entered\nPlease Try Again.");
		return readName();
	}
	private static String readPhoneNo() {
		 System.out.print("Phone Number: ");
	     String phone = sc.next();
        if(validateNumber(phone)) {
        	return phone;
        }
        System.out.println("Invalid Name Entered\nPlease Try Again.");
		return readPhoneNo();
	}
	
	
	private static boolean checkStudentName(String name) {
		
		String nameRegex = "^(?:[A-Za-z]+\\s?){3,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
	}
	
	private static boolean validateNumber(String number) {
	
		boolean checkStatus = number.matches("^[6-9][0-9]{9}");
		
		return checkStatus;
	}
	

}
