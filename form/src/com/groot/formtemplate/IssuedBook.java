package com.groot.formtemplate;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class IssuedBook {
    public IssuedBook() {
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