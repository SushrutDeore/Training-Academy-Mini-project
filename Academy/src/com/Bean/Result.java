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
			if(score<=50 && score>=0)
				this.setMarks(marks);
			else
			{
				System.out.println("Score must be between 0 to 50");
				validateMarks();
			}
		}
	}
	

}
