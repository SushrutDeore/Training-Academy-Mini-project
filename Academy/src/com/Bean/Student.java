package com.Bean;

import java.util.Scanner;

public class Student {
	
	private int studentId;
	private String studentName;
	private String phoneNo;
	private int batchId;
	private String status;
	public Scanner  sc=new Scanner(System.in);
	
	public Student()
	{
		
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public int getBatchId() {
		return batchId;
	}


	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setStudent()
	{
//		System.out.println("Enter Student Id:");
//		this.setStudentId(sc.nextInt());
//		sc.nextLine();
		System.out.println("Enter Student Name:");
		this.setStudentName(sc.next());
		sc.nextLine();
		System.out.println("Enter Phone Number:");
		this.setPhoneNo(sc.next());
		sc.nextLine();
		System.out.println("Enter Batch ID:");
		this.setBatchId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the Status:");
		this.setStatus(sc.next());
		
	}
	
	public void getStudent()
	{
		System.out.println("Student Id : "+this.studentId);
		System.out.println(" Name : "+this.studentName);
		System.out.println("Phone Number : "+this.phoneNo);
		System.out.println("Batch Id : "+this.batchId);
		System.out.println(" Status : "+this.status);
	}
	
}
