package com.groot.formtemplate;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.groot.formtemplate.libraian.NewFrame;

public class librarianlogin {
	public static void main(String[] args) {
		new mainpanel();
	}
    public librarianlogin() {
    	JFrame f=new JFrame();
     	Label Adminlabel = new Label("Librarian Section");
    		Adminlabel.setBounds(170, 50, 400, 70);
    		Adminlabel.setForeground(Color.BLACK);
    		Adminlabel.setFont(new Font("Aerial", Font.BOLD, 40));
    		f.add(Adminlabel);
     	// add book
    		Button submit = new Button("Add Book");
    		submit.setBackground(Color.BLUE);
    		submit.setFont(new Font("Aerial", Font.BOLD, 30));
    		submit.setBounds(200, 150, 300, 70);
    		ActionListener ac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new addbook();
    			}
    		};
    		submit.addActionListener(ac);
    		f.add(submit);
    		//view book
    		Button view = new Button("View Book");
    		view.setBackground(Color.BLUE);
    		view.setFont(new Font("Aerial", Font.BOLD, 30));
    		view.setBounds(200, 240, 300, 70);
    		ActionListener veiwac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new ViewBook();
    			}
    		};
    		
    		view.addActionListener(veiwac);
    		f.add(view);
    		
    		// issue book;
    		Button issue = new Button("View Issued Book");
    		issue.setBackground(Color.BLUE);
    		issue.setFont(new Font("Aerial", Font.BOLD, 30));
    		issue.setBounds(200, 330, 300, 70);
    		ActionListener issueac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new issuebook();
    			}
    		};
    		
    		issue.addActionListener(issueac);
    		f.add(issue);
    		
    		// issued book
    		Button issuedbook = new Button("View Issued Book");
    		issuedbook.setBackground(Color.BLUE);
    		issuedbook.setFont(new Font("Aerial", Font.BOLD, 30));
    		issuedbook.setBounds(200, 420, 300, 70);
    		ActionListener issuedbookac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new IssuedBook();
    			}
    		};
    		
    		issuedbook.addActionListener(issuedbookac);
    		f.add(issuedbook);
    		
    		// return book
    		Button returnbook = new Button("Return Book");
    		returnbook.setBackground(Color.BLUE);
    		returnbook.setFont(new Font("Aerial", Font.BOLD, 30));
    		returnbook.setBounds(200, 510, 300, 70);
    		ActionListener returnbookac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new returnbook();
    			}
    		};
    		
    		returnbook.addActionListener(returnbookac);
    		f.add(returnbook);
    		// logout 
    		Button logout = new Button("Logout");
    		logout.setBackground(Color.BLUE);
    		logout.setFont(new Font("Aerial", Font.BOLD, 30));
    		logout.setBounds(200, 600, 300, 70);
    		ActionListener logoutac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new mainpanel();
    			}
    		};
    		
    		logout.addActionListener(logoutac);
    		f.add(logout);
    		
    		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(650, 750);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}});

}
}





class issuebook {
    public issuebook() {
    	JFrame f=new JFrame();
    	
    	
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(650, 750);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}});
}
}

class returnbook {
    public returnbook() {
    	JFrame f=new JFrame();
    	
    	
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(650, 750);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}});
}
}

