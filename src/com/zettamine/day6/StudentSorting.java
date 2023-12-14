package com.zettamine.day6;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class StudentSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        TreeSet<String> students = new TreeSet<>(new StudentLengthComparator());

        System.out.print("how many students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= numStudents; i++) {
            System.out.print("enter student-" + i + " name: ");
            String name = sc.nextLine();

            if (students.contains(name)) {
                System.out.println("Duplicate name entered! try again ...");
                i--;
                continue;
            }

            students.add(name); 
        }
        sc.close();
        int count = 1;
        for (String student : students) {
            System.out.println(count++ + ". " + student);
        }
	}
	static class StudentLengthComparator implements Comparator<String> {
        @Override 
		public int compare(String o1, String o2){
            int lengthComparison = Integer.compare(o1.length(), o2.length());
            if (lengthComparison == 0) {
                return o1.compareTo(o2);
            }
            return lengthComparison;
        }
    }

}
