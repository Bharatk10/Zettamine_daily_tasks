package com.zettamine.day4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NITStudent {
	
	 protected int studentId;
     protected String name;
     protected int departmentId;
     protected String gender;
     protected String phone;
     private Hosteller hostler;

}
