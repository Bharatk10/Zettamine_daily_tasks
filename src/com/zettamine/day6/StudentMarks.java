package com.zettamine.day6;

import java.util.HashSet;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentMarks {
	
	private String roolNo;
	private String stdName;
	private HashSet<Integer> subjectMarksHS;
	private TreeSet<Integer> subjectMarksTS;

}
