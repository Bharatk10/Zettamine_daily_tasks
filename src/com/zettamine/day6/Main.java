package com.zettamine.day6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static List<StudentMarks> studentData = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("Enter the no of students: ");
		int noOfStudents = sc.nextInt();
		
		System.out.printf("Accepting %d studnet details:\n",noOfStudents);
		while(noOfStudents!=0) {
			sc.nextLine();
			System.out.println("Enter the name of the Student:");
			String name = sc.nextLine();
			System.out.println("Enter the rool no.: ");
			String rollNo = sc.nextLine();
			System.out.println("Enter the no of subjects: ");
			int noOfSubjects = sc.nextInt();
			List<Integer> marks = new ArrayList<>();
			for(int i=1;i<=noOfSubjects;i++) {
				System.out.println("Enter marks of subject "+i);
				int num = sc.nextInt();
				if(marks.contains(num)) {
					 System.out.println("Duplicate marks entered! Try again ...");
		                i--;
		                continue;
				}	
				marks.add(num);
			}//end of for
			HashSet<Integer> subjectMarksHS = new HashSet<>(marks);
			TreeSet<Integer> subjectMarksTS = new TreeSet<>(marks);
			studentData.add(new StudentMarks(rollNo,name,subjectMarksHS,subjectMarksTS));
			noOfStudents--;
		}//end of while
//		for (StudentMarks student  : studentData) {
//			System.out.println(student);
//			
//		}
		displayData();
		studentDataSave();
	}
	private static void displayData() {
		
		System.out.println("Displaying "+studentData.size()+" student Details:");
		for (StudentMarks studentDetails : studentData) {
			System.out.println("Student Name: "+studentDetails.getStdName());
			System.out.println("Roll No.: "+studentDetails.getRoolNo());
			System.out.println("Student Marks:");
			HashSet<Integer> subjectMarksHS = studentDetails.getSubjectMarksHS();
			Iterator<Integer> iteratorHS = subjectMarksHS.iterator();
			while(iteratorHS.hasNext()) {
				System.out.println(iteratorHS.next());
			}
			System.out.println("Student Marks in Sorted Manner:");
			TreeSet<Integer> subjectMarksTS = studentDetails.getSubjectMarksTS();
			Iterator<Integer> iteratorTS = subjectMarksTS.iterator();
			while(iteratorTS.hasNext()) {
				System.out.println(iteratorTS.next());
			}
		}
		
	}
	private static void studentDataSave() {
		
		
		try (FileWriter fw = new FileWriter("studentData.txt",true)) {
			for (StudentMarks studentMarks : studentData) {
				
				fw.write(studentMarks.toString());
				fw.write("\n");
			}
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
