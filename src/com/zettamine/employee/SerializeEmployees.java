package com.zettamine.employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class SerializeEmployees {
	
	static Map<Employee,HashSet<Certification>> employeeMap;
	
	static {

		employeeMap = new HashMap<>();
		
		RegularEmployee regEmp1= new  RegularEmployee(101,"Bharat",10,"BHA0001");
		RegularEmployee regEmp2 = new RegularEmployee(102,"Kumar",20,"KUM0002");
		RegularEmployee regEmp3 = new RegularEmployee(103,"Naresh",10,"NAR0003");
		
		
		ContractEmployee contEmp1 = new ContractEmployee(201,"Vikas",20,1001);
		ContractEmployee contEmp2 = new ContractEmployee(202,"Seth",20,10002);
		ContractEmployee contEmp3 = new ContractEmployee(203,"Vikram",10,1003);
		
		Certification javaDeveloper = new Certification(1211,"Java Developer",1);
		Certification javaArchitect = new Certification(1890,"Java Architect",3);
		Certification clodPractionerAWS = new Certification(1699,"AWS Cloud Practioner",1);
		Certification solutionArchitectAWS = new Certification(1934,"AWS Solution Architect",2);
				
        addEmployee(regEmp1,javaDeveloper,clodPractionerAWS,solutionArchitectAWS);
        addEmployee(regEmp2,javaDeveloper);
        addEmployee(regEmp3);
        addEmployee(contEmp1,javaArchitect);
        addEmployee(contEmp2,javaDeveloper,clodPractionerAWS);
        addEmployee(contEmp3);
	 
	}
	
	private static void addEmployee( Employee emp, Certification... certificates) {
        HashSet<Certification> certifications = new HashSet<>(Arrays.asList(certificates));
        employeeMap.put(emp, certifications);
    }
	
	private static void serializeEmloyees(String filePath) throws FileNotFoundException {
		
		final FileOutputStream fos = new FileOutputStream(filePath);
		try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(employeeMap);
			System.out.println("Serialization completed");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		 String fileName = "C:\\Users\\Bharat Kumar\\Desktop\\SampleData.txt";
		 
		 try {
			serializeEmloyees(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

