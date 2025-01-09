package com.groot.formtemplate;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
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

import com.groot.formtemplate.libraian.NewFrame;

public class formproject {
	public static void main(String[] args) {
		new mainpanel();

	}
};

class addlibrarian {
	public addlibrarian() {
		JFrame f = new JFrame("My first frame");

//        name text field 

		Label namelabel = new Label("Full Name");
		namelabel.setBounds(50, 40, 100, 50);
		namelabel.setForeground(Color.BLACK);
		namelabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(namelabel);
		JTextField firstNameTextField = new JTextField("First Name");
		firstNameTextField.setBounds(50, 100, 250, 30);
		firstNameTextField.setFont(new Font("Aerial", Font.PLAIN, 16));
		f.add(firstNameTextField);
		test(firstNameTextField);
		JTextField lasttf = new JTextField("Last");
		lasttf.setFont(new Font("Aerial", Font.PLAIN, 16));
		lasttf.setBounds(350, 100, 250, 30);
		f.add(lasttf);
		test(lasttf);
//     Email Text Field

		JLabel emaillabel = new JLabel("Email Address");
		emaillabel.setBounds(50, 140, 200, 50);
		emaillabel.setForeground(Color.BLACK);
		emaillabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(emaillabel);
		JTextField emailtf = new JTextField();
		emailtf.setFont(new Font("Aerial", Font.PLAIN, 16));
		emailtf.setBounds(50, 200, 400, 30);
		f.add(emailtf);

//gender chose

		JLabel genderlabel = new JLabel("Gender ");
		genderlabel.setBounds(50, 240, 100, 50);
		genderlabel.setForeground(Color.BLACK);
		genderlabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(genderlabel);
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox male = new Checkbox("Male", cbg, true);
		male.setFont(new Font("Aerial", Font.PLAIN, 16));
		male.setBounds(250, 250, 100, 30);
		f.add(male);
		Checkbox female = new Checkbox("Female", cbg, false);
		female.setFont(new Font("Aerial", Font.PLAIN, 16));
		female.setBounds(400, 250, 100, 30);
		f.add(female);

//        state chose

		JLabel Statelabel = new JLabel("Chose State");
		Statelabel.setBounds(50, 300, 150, 50);
		Statelabel.setForeground(Color.BLACK);
		Statelabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(Statelabel);
		Choice State = new Choice();
		State.setFont(new Font("Aerial", Font.PLAIN, 16));
		State.add("Rajasthan");
		State.add("Maharashtra");
		State.add("Haryana");
		State.add("Telangana");
		State.add("Madhya Pradesh");
		State.add("Karnataka");
		State.add("Andhra Pradesh");
		State.setBounds(250, 310, 100, 50);
		f.add(State);

//city chose

		JLabel citylabel = new JLabel("Chose City");
		citylabel.setBounds(50, 370, 150, 50);
		citylabel.setForeground(Color.BLACK);
		citylabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(citylabel);
		Choice city = new Choice();
		city.setFont(new Font("Aerial", Font.PLAIN, 16));
		city.add("Jaipur");
		city.add("Jodhpur");
		city.add("Banglore");
		city.add("Gurgaon");
		city.add("Delhi");
		city.add("Mumbai");
		city.add("Indore");
		city.setBounds(250, 380, 100, 50);
		f.add(city);

//enter Mobile Number

		JLabel Mobilelabel = new JLabel("Mobile Number");
		Mobilelabel.setBounds(50, 440, 150, 50);
		Mobilelabel.setForeground(Color.BLACK);
		Mobilelabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(Mobilelabel);
		JTextField mobiletf = new JTextField();
		mobiletf.setBounds(250, 450, 200, 30);
		mobiletf.setFont(new Font("Aerial", Font.PLAIN, 16));
		f.add(mobiletf);

//              comments

		Label commentlabel = new Label("Comments");
		commentlabel.setBounds(50, 500, 150, 50);
		commentlabel.setForeground(Color.BLACK);
		commentlabel.setFont(new Font("Aerial", Font.BOLD, 20));
		f.add(commentlabel);
		TextArea comment = new TextArea();
		comment.setBounds(250, 500, 350, 100);
		comment.setFont(new Font("Aerial", Font.PLAIN, 16));
		f.add(comment);

//                Submit Button

		Button submit = new Button("Add Librarian");
		submit.setBackground(Color.GREEN);
		submit.setFont(new Font("Aerial", Font.BOLD, 20));
		submit.setBounds(200, 630, 150, 50);
		ActionListener ac = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String a = firstNameTextField.getText() + " " + lasttf.getText();
				String b = emailtf.getText();
				String c = mobiletf.getText();
				String d = comment.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("class loaded");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarians", "root",
							"Nikhil@45");
					System.out.println("Connection done");
					Statement stmt = conn.createStatement();
//					String.format("", a,b,c,d);
					int i = stmt.executeUpdate("insert into librarian (Name,Email,MobileNumber,Comments) values('" + a
							+ "','" + b + "','" + c + "','" + d + "')");
					System.out.println(i);
				} catch (Exception e2) {
//				      System.out.println("Something went wrong.");
					e2.printStackTrace();
				}
				// TODO Auto-generated method stub
				System.out.println("Name = " + a);
				System.out.println("Email = " + b);
				System.out.println("Mobile Number = " + c);
				System.out.println("Comments = " + d);
				f.dispose();
				new NewFrame();
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
			}
		});
	}

	public static void test(JTextField textField) {
		textField.getDocument().addDocumentListener(new DocumentListener() {
			private boolean firstTyped = true; // To track the first typing event

			@Override
			public void insertUpdate(DocumentEvent e) {
				clearText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			private void clearText() {
				if (firstTyped) {
					// Clear text on first input and set flag to false
					SwingUtilities.invokeLater(() -> textField.setText(""));
					firstTyped = false;
				}
			}
		});
	};
};
