package com.groot.formtemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConectionData {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("class loaded");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Nikhil@45");
		System.out.println("Connection done");
		Statement stmt= conn.createStatement();
		int i=stmt.executeUpdate("insert into student (name,fee) values('jai',4343)");
		stmt.executeUpdate("insert into student (name,fee) values('nikh',4345)");
		System.out.println(i);
	}
}
