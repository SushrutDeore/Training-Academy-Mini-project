package com.Bean;

import java.util.Scanner;

public class Result {
	private int resultId;
	private int studentId;
	private int marks;
	public Scanner  sc=new Scanner(System.in);
	
	public Result()
	{
		
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public void setResult()
	{
//		System.out.println("Enter Result id:");
//		this.setStudentId(sc.nextInt());
		System.out.println("Enter Student id:");
		this.setStudentId(sc.nextInt());
		validateMarks();
		
	}
	
	public void getResult()
	{
		System.out.println("Result id: "+this.getResultId());
		System.out.println("Student Id: "+this.getStudentId());
		System.out.println("Marks:"+this.getMarks());
	}
	
	public void validateMarks()
	{
		System.out.println("Enter the Marks:");
		{
			int score=sc.nextInt();
			if(score<=50)
				this.setMarks(marks);
			else
			{
				System.out.println("Maximum Score : 50");
				validateMarks();
			}
		}
	}
	
	public boolean isPass()
	{
		if(this.getMarks()>=25)
			return true;
		else
			return false;
			
	}

}
