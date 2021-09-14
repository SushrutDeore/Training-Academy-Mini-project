package com.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.Bean.Batch;
import com.Bean.Result;
import com.Bean.Student;
import com.Configuration.Configure;

public class DAOClass implements DAOInterface{
	
	private Connection con=Configure.connect();
	public Scanner  sc=new Scanner(System.in);

	@Override
	public void addStudent() 
	{
		String sql="insert into student(student_name,phoneno,batch_id,status) values(?,?,?,?)";
		Student student=new Student();
		student.setStudent();
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getPhoneNo());
			ps.setInt(3, student.getBatchId());
			ps.setString(4, student.getStatus());
			
			 boolean flag=ps.execute();
			 if(flag==false)
				 System.out.println("Record added Successfully...");
			 else
				 System.out.println("Unable to Add Record....");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while adding record");
			e.printStackTrace();
		}

		
	}

	@Override
	public void modifyStatus() {
		String sql="update student set status=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the StudentId");
			int id=sc.nextInt();
			ps.setInt(2, id);
			System.out.println("Status :\n 1.Active \n 2.Inactive");
			int ch=sc.nextInt();
			if(ch==1)
				ps.setString(1, "Active");
			else
				ps.setString(1, "Inactive");
			
			int row=ps.executeUpdate();
			System.out.println(row+" rows updated.");
				
		}
		catch (Exception e) {
			System.out.println("Unable to Update");
			// TODO: handle exception
		}
		
	}

	

	@Override
	public void addResult() {
		String sql="insert into result (student_id,marks)values(?,?)";
		Result result=new Result();
		result.setResult();
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, result.getResultId());
			ps.setInt(1, result.getStudentId());
			ps.setInt(2, result.getMarks());
			
			boolean row=ps.execute();
			if(row==false)
				System.out.println("Marks Entered Successfully.");
			else
				System.out.println("Unable to Insert data");
			
		}
		catch (Exception e) {
			System.out.println("Unable to Proceed.");
			// TODO: handle exception
		}
		
	}

	@Override
	public void deleteRecord() {
		String sql="delete s,r from student s inner join result r on s.student_id=r.student_id where s.student_id=?";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student ID:");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Rows Deleted.");
		}
		catch (Exception e) {
			System.out.println("Unable to delete data");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public void updatePhoneNumber() {
		String sql="update student set phoneno=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter Student id:");
			ps.setInt(2, sc.nextInt());
			System.out.println("Enter New Phone Number:");
			ps.setString(1, sc.next());
			
			int row=ps.executeUpdate();
			System.out.println(row+" row Updated");
		}
		catch (Exception e) {
			
			// TODO: handle exception
			System.out.println("Unable to update");
			e.printStackTrace();
		}
	}

	@Override
	public void changeBatch() {
		String sql="update student set batch_id=? where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Student id.");
			ps.setInt(2, sc.nextInt());
			this.getBatchFromDatabase();
			System.out.println("Enter Batch id.");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Updated.");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to update.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMarks() {
		String sql="update result set marks=20 where student_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Studentid: ");
			ps.setInt(1, sc.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+" Updated.");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to update.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void getBatchFromDatabase() {
		ArrayList<Batch> list=new ArrayList<Batch>();
		
		try
		{
			String sql="SELECT * FROM batch_details";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Batch temp=new Batch();
				temp.setBatch(rs.getInt(1), rs.getString(2));
				list.add(temp);
			}
			
			Iterator<Batch> itr=list.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void topFiveMerit() {
		try
		{
			String sql="select s.student_id,s.student_name,r.marks from student s inner join result r on s.student_id=r.student_id where batch_id=? && marks>24 order by marks desc limit 5";
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Enter the Department id");
			int id=sc.nextInt();
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			System.out.println("Top 5 Students from ");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to get list");
			e.printStackTrace();
		}
		
	}

	@Override
	public void topTenAcademy() {
		String sql="select s.student_id,s.student_name,r.marks,bd.batch_name from student s inner join result r on s.student_id=r.student_id inner join batch_details bd on bd.batch_id=s.batch_id where marks>24 order by marks desc limit 10";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("***Top 10 Students From Academy***");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to Fetch list.");
		}
	}
	
	public void maxFail()
	{
		String sql="select bd.batch_name,count(*) from student s inner join result r on s.student_id=r.student_id inner join batch_details bd on bd.batch_id=s.batch_id where marks<25";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("Batch Name  \t| No. Of Failed Students");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t\t|"+rs.getInt(2));
			}
					
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to Fetch record.");
		}
	}
	
	
	

}
