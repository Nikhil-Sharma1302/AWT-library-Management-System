package com.groot.test;

import javax.swing.JButton;

public class MyButton extends JButton{
	public static void main(String[] args) {
		MyButton b= new MyButton("Hello");
		System.out.println(b);
	}
	public MyButton(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}