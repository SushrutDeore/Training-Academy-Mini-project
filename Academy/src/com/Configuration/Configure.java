package com.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Configure {
	
	public  final static String url="jdbc:mysql://localhost:3306/academy";
	public static  Connection con=null;
	
	
	//Making Connection with database.
	public static Connection  connect()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
		
		System.out.println("Enter the user id");
		String id=sc.next();
		System.out.println("Enter the Password:");
		String psw=sc.next();
		
		con=DriverManager.getConnection(url,id,psw);
		System.out.println("Connected successfully to Academy database....");
		System.out.println("<<<<< WELCOME TO ACADEMY >>>>>");
		}
		catch (Exception e)
		{
		System.out.println("Error in Connection");
		System.out.println("Id or Password is Wrong \n Try Again.");
		connect();
		}
		
		return con;
		
		}
	
	// Closing connection from database
	public  static void closeConnection() 
	{
		try
		{
		con.close();
		
		
		System.out.println("Connection closed.....");
		}
		catch (Exception e) {
			System.out.println("Error while closing the connection");
			
			e.printStackTrace();
		}		
		
	}


}
