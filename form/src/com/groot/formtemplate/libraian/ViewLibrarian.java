package com.groot.formtemplate.libraian;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
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

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.groot.formtemplate.librarianlogin;

public class ViewLibrarian {
	public static void main(String[] args) {
		new ViewLibrarian();
	}
    public ViewLibrarian() {
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
    	tableModel.addColumn("Edit");
    	   table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
           table.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox(), "Edit"));
         
    	try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarians", "root", "Nikhil@45");
			System.out.println("Connection done");
			Statement stmt= conn.createStatement();
//			String.format("", a,b,c,d);
			  String query = "SELECT Name, Email, MobileNumber, Comments FROM librarian";
	            ResultSet rs = stmt.executeQuery(query);
	            while(rs.next()) {
	            	String n = rs.getString("Name");
	            	String e = rs.getString("Email"); 
	            	String m = rs.getString("MobileNumber");
	            	String c = rs.getString("Comments"); 
	            	JButton edit = new JButton("Edit");
	            	edit.setBackground(Color.GREEN);
	            	edit.setFont(new Font("Aerial", Font.BOLD, 20));
	            	tableModel.addRow(new Object[]{n, e, m,c,edit});
	            	
	            	
	            }
	            f.add(l);
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
		new NewFrame();
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
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
    
}
class ButtonEditor extends DefaultCellEditor {
    private String label;
    private JButton button;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox, String label) {
        super(checkBox);
        this.label = label;
        this.button = new JButton();
        this.button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        isPushed = true;
        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return button.getText();
    }};

