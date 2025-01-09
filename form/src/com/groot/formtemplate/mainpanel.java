package com.groot.formtemplate;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.groot.formtemplate.libraian.NewFrame;

public class mainpanel {
 public static void main(String[] args) {
	new mainpanel();
}
 public mainpanel() {
 	JFrame f=new JFrame();
 	Label Adminlabel = new Label("Library Management");
		Adminlabel.setBounds(120, 140, 400, 100);
		Adminlabel.setForeground(Color.BLACK);
		Adminlabel.setFont(new Font("Aerial", Font.BOLD, 40));
		f.add(Adminlabel);
 	// admin login
		Button submit = new Button("Admin Login");
		submit.setBackground(Color.GREEN);
		submit.setFont(new Font("Aerial", Font.BOLD, 30));
		submit.setBounds(150, 260, 250, 70);
		ActionListener ac=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new NewFrame();
			}
		};
		submit.addActionListener(ac);
		f.add(submit);
		//librabian login
		Button ll = new Button("Librarian Login");
		ll.setBackground(Color.GREEN);
		ll.setFont(new Font("Aerial", Font.BOLD, 30));
		ll.setBounds(150, 350, 250, 70);
		ActionListener lla=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new librarianlogin();
			}
		};
		
		ll.addActionListener(lla);
		f.add(ll);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(650, 750);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}});
}
	};
