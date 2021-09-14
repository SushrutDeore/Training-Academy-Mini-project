package com.Controller;

import java.util.Scanner;

import com.Configuration.Configure;
import com.DAO.DAOClass;

public class MainClass {
	
	public static void main(String[] args) {
		
	
	
	DAOClass obj=new DAOClass();
	Scanner sc=new Scanner(System.in);
	while(true) {
	
	System.out.println("1.Add Data.");
	System.out.println("2.Update Data.");
	System.out.println("3.Delete data.");
	System.out.println("4.Change Students Batch.");
	System.out.println("5.Get merit list of Top 5 Students of batch.");
	System.out.println("6.Get Top 10 Student List from Academy.");
	System.out.println("7.Maximum failed Student");
	System.out.println("8.Display Records");
	System.out.println("9.Display Student Information.");
	System.out.println("10.Display batch name and trainer name having bestresult is best");
	System.out.println("11.Exit.");
	System.out.println("Enter the Choice...");
	int choice=sc.nextInt();
	
	switch(choice)
	{
	case 1:
		System.out.println("1.Add Student Record.");
		System.out.println("2.Add Marks.");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Adding Record to database");
			System.out.println();
			obj.addStudent();
			System.out.println();
			break;
		case 2:
			System.out.println("Add marks");
			System.out.println();
			obj.addResult();
			System.out.println();
			break;
		}
		break;
		
	case 2:
			System.out.println("1.Update Status of student.");
			System.out.println("2.Update Student Phone number.");
			System.out.println("3.Update student's Marks.");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				System.out.println("Updating status of Student");
				System.out.println();
				obj.modifyStatus();
				System.out.println();
				
				break;
				
			case 2:
				System.out.println("Updating Student Phone Number");
				System.out.println();
				obj.updatePhoneNumber();
				System.out.println();
				
				break;
				
			case 3:
				System.out.println("Updating marks.");
				 System.out.println();
				 obj.updateMarks();
				 System.out.println();
				break;
			}
		break;
		
	case 3:
		System.out.println("Deleting Record.");
		System.out.println();
		obj.deleteRecord();
		System.out.println();
		break;
		
	case 4:
		System.out.println("Changing Batch Of Student.");
		System.out.println();
		obj.changeBatch();
		System.out.println();
		break;
		
	case 5:
		System.out.println();
		System.out.println();
		obj.topFiveMerit();
		System.out.println();
		break;
		
		
	case 6:
		
		System.out.println();
		obj.topTenAcademy();
		System.out.println();
		break;
		
	case 7:
		System.out.println();
		obj.maxFail();
		System.out.println();
		break;
		
	case 8:
		System.out.println("Batch Details");
		System.out.println();
		obj.getBatchFromDatabase();
		System.out.println();
		break;
	
	case 10:
		System.out.println("Batch with best result");
		System.out.println();
		obj.bestBatch();
		System.out.println();
		
		break;
		
	case 9:
		System.out.println("Displaying Student Information");
		System.out.println();
		obj.studentInfo();
		System.out.println();
		
		break;
	case 11:
		Configure.closeConnection();
		System.out.println("---- Thank you ----");
		System.exit(0);
		break;	
		
	default:
		System.out.println("Invalid Choice.... Try Again.");
	}
	}

}
}