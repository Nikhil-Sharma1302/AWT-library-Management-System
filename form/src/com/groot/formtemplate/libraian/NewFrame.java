package com.groot.formtemplate.libraian;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.groot.formtemplate.mainpanel;

public class NewFrame {
	public static void main(String[] args) {
		new mainpanel();
	}
    public NewFrame() {
    	JFrame f=new JFrame();
     	Label Adminlabel = new Label("Admin Section");
    		Adminlabel.setBounds(170, 100, 400, 70);
    		Adminlabel.setForeground(Color.BLACK);
    		Adminlabel.setFont(new Font("Aerial", Font.BOLD, 40));
    		f.add(Adminlabel);
     	// add librarian
    		Button submit = new Button("Add Librarian");
    		submit.setBackground(Color.YELLOW);
    		submit.setFont(new Font("Aerial", Font.BOLD, 30));
    		submit.setBounds(200, 200, 250, 70);
    		ActionListener ac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new AddLibrarian();
    			}
    		};
    		submit.addActionListener(ac);
    		f.add(submit);
    		//view librarian
    		Button view = new Button("View Librarian");
    		view.setBackground(Color.YELLOW);
    		view.setFont(new Font("Aerial", Font.BOLD, 30));
    		view.setBounds(200, 290, 250, 70);
    		ActionListener veiwac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new ViewLibrarian();
    			}
    		};
    		
    		view.addActionListener(veiwac);
    		f.add(view);
    		
    		// delete librarian;
    		Button delete = new Button("Delete Librarian");
    		delete.setBackground(Color.YELLOW);
    		delete.setFont(new Font("Aerial", Font.BOLD, 30));
    		delete.setBounds(200, 380, 250, 70);
    		ActionListener deleteac=new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				f.dispose();
    				new DeleteLibrarian();
    			}
    		};
    		
    		delete.addActionListener(deleteac);
    		f.add(delete);
    		
    		// logout
    		Button logout = new Button("Logout");
    		logout.setBackground(Color.YELLOW);
    		logout.setFont(new Font("Aerial", Font.BOLD, 30));
    		logout.setBounds(200, 470, 250, 70);
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
}};






