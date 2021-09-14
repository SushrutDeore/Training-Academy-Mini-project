package com.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Configure {
	
	public  final static String url="jdbc:mysql://localhost:3306/academy";
	public static  Connection con=null;
	
	public static Connection  connect()
	{
		
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		String id=sc.next();
		System.out.println("Enter the Password:");
		String psw=sc.next();
		
		con=DriverManager.getConnection(url,id,psw);
		System.out.println("Connected successfully to Academy database....");
		}
		catch (Exception e)
		{
		System.out.println("Error in Connection");
		System.out.println("Id or Password is Wrong \n Try Again.");
		connect();
		}	
		return con;
		
		}
	
	public  static void closeConnection() // Closing connection from database.
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
