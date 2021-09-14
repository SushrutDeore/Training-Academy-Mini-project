package com.DAO;

public interface DAOInterface {
	
	public void addStudent();//Add record to Student's table.
	
	public void modifyStatus();//Modify status of student.
	
	public void addResult();//Add record to result table.
	
	public void deleteRecord();//Delete students all information from database.
	
	public void updatePhoneNumber();//Update phone no. to student.
	
	public void changeBatch();//Change batch of student.
	
	public void updateMarks();//Update the marks .
	
	public void getBatchFromDatabase();//get batch details from database.
	
	public void topFiveMerit();//get top five students from each batch.
	
	public void topTenAcademy();//get top ten students from academy.
	
	public void maxFail();//get batch details where maximum students are fail.
	
	public void bestBatch();//Display batch with best result.
	
	public void studentInfo();//Get students information.
	
	

}
