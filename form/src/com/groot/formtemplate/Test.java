package com.groot.formtemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		String a = "";
		String  b="";
		int c=8;
		String d = "";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarians", "root", "Nikhil@45");
			System.out.println("Connection done");
			Statement stmt= conn.createStatement();
//			String.format("", a,b,c,d);
			int i=stmt.executeUpdate("insert into librarian (Name,Email,MobileNumber,Comments) values('"+a+"','"+b+"','"+c+"','"+d+"')");
			System.out.println(i);
		} catch (Exception e2) {
//		      System.out.println("Something went wrong.");
			e2.printStackTrace();
	    }
	}
}
