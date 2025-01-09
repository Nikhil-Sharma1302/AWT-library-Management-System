package com.groot.formtemplate;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.groot.formtemplate.libraian.NewFrame;

public class ViewBook {
	public static void main(String[] args) {
		new ViewBook();
	}
    public ViewBook() {
    	JFrame f=new JFrame();
    	JPanel l= new JPanel();
    	DefaultTableModel tableModel = new DefaultTableModel();
    	JTable table = new JTable(tableModel);
    	JScrollPane scrollPane = new JScrollPane(table);
    	l.add(scrollPane);
    	tableModel.addColumn("Name");
    	tableModel.addColumn("Email");
    	tableModel.addColumn("Mobile Number");
    	tableModel.addColumn("Comments");
    	tableModel.addColumn("Action");
    	try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Nikhil@45");
			System.out.println("Connection done");
			Statement stmt= conn.createStatement();
//			String.format("", a,b,c,d);
			  String query = "SELECT BookName, BookType, AuthorName, BookDescription FROM Book";
	            ResultSet rs = stmt.executeQuery(query);
	            while(rs.next()) {
	            	String n = rs.getString("BookName");
	            	String e = rs.getString("BookType"); 
	            	String m = rs.getString("AuthorName");
	            	String c = rs.getString("BookDescription"); 
	            	Button edit = new Button("Edit");
	            	edit.setBackground(Color.GREEN);
	            	edit.setFont(new Font("Aerial", Font.BOLD, 20));
	            	tableModel.addRow(new Object[]{n, e, m,c,edit});
	            	f.add(l);
	            	
	            }
		} catch (Exception e2) {
//		      System.out.println("Something went wrong.");
			e2.printStackTrace();
	    }
//      Submit Button

Button submit = new Button("Go Back");
submit.setBackground(Color.GREEN);
submit.setFont(new Font("Aerial", Font.BOLD, 20));
ActionListener ac=new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			f.dispose();
			new librarianlogin();
		}
	};
submit.addActionListener(ac);
JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout centers the button
buttonPanel.add(submit);

f.add(buttonPanel);
		f.setLayout(new GridLayout(0,1));
		f.setVisible(true);
		f.setSize(650, 700);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}});
}
};
