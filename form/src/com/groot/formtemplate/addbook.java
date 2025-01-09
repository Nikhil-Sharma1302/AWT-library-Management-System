package com.groot.formtemplate;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class addbook {
public static void main(String[] args) {
	new mainpanel();
}
addbook(){
	JFrame f = new JFrame("Add Book");

//  name text field 

	Label namelabel = new Label("Book Name");
	namelabel.setBounds(50, 40, 150, 50);
	namelabel.setForeground(Color.BLACK);
	namelabel.setFont(new Font("Aerial", Font.BOLD, 20));
	f.add(namelabel);
	JTextField firstNameTextField = new JTextField();
	firstNameTextField.setBounds(50, 100, 250, 30);
	firstNameTextField.setFont(new Font("Aerial", Font.PLAIN, 16));
	f.add(firstNameTextField);
//Email Text Field

	JLabel emaillabel = new JLabel("Book Type");
	emaillabel.setBounds(50, 140, 200, 50);
	emaillabel.setForeground(Color.BLACK);
	emaillabel.setFont(new Font("Aerial", Font.BOLD, 20));
	f.add(emaillabel);
	JTextField emailtf = new JTextField();
	emailtf.setFont(new Font("Aerial", Font.PLAIN, 16));
	emailtf.setBounds(50, 200, 400, 30);
	f.add(emailtf);

//enter Mobile Number

	JLabel Mobilelabel = new JLabel("Author Name");
	Mobilelabel.setBounds(50, 240, 200, 50);
	Mobilelabel.setForeground(Color.BLACK);
	Mobilelabel.setFont(new Font("Aerial", Font.BOLD, 20));
	f.add(Mobilelabel);
	JTextField mobiletf = new JTextField();
	mobiletf.setBounds(250, 250, 300, 30);
	mobiletf.setFont(new Font("Aerial", Font.PLAIN, 16));
	f.add(mobiletf);

//        comments

	Label commentlabel = new Label("Book Description");
	commentlabel.setBounds(50, 300, 200, 50);
	commentlabel.setForeground(Color.BLACK);
	commentlabel.setFont(new Font("Aerial", Font.BOLD, 20));
	f.add(commentlabel);
	TextArea comment = new TextArea();
	comment.setBounds(250, 300, 350, 200);
	comment.setFont(new Font("Aerial", Font.PLAIN, 16));
	f.add(comment);

//          Submit Button

	Button submit = new Button("Add Book");
	submit.setBackground(Color.GREEN);
	submit.setFont(new Font("Aerial", Font.BOLD, 20));
	submit.setBounds(200, 530, 100, 50);
	ActionListener ac=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String a = firstNameTextField.getText();
			String  b= emailtf.getText();
			String c=mobiletf.getText();
			String d = comment.getText();
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("class loaded");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Nikhil@45");
				System.out.println("Connection done");
				System.out.println(conn);
				Statement stmt= conn.createStatement();
				System.out.println(stmt);
//				String.format("", a,b,c,d);
				int i=stmt.executeUpdate("insert into book (BookName,BookType,AuthorName,BookDescription) values('"+a+"','"+b+"','"+c+"','"+d+"')");
				System.out.println(i);
			} catch (Exception e2) {
//			      System.out.println("Something went wrong.");
				e2.printStackTrace();
		    }
			// TODO Auto-generated method stub
			System.out.println("Book Name = "+firstNameTextField.getText());
			System.out.println("Book Type = "+ emailtf.getText());
			System.out.println("Author Name = "+mobiletf.getText());
			System.out.println("Book Description = "+comment.getText());
			f.dispose();
			new librarianlogin();
		}
	};
	submit.addActionListener(ac);
	f.add(submit);
	f.setLayout(null);
	f.setVisible(true);
	f.setSize(650, 750);
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			f.dispose();
		}});
};

};
