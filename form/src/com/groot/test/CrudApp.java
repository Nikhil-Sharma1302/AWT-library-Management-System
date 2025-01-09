package com.groot.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class CrudApp extends JFrame {
    // Components of the Form 
    private JTextField nameField, ageField; 
    private JButton addButton, updateButton, deleteButton, clearButton; 
    private JTable table;
    private DefaultTableModel model;
    private int selectedRowIndex = -1;

    public CrudApp() {
        // Frame settings
        setTitle("CRUD Operations in Swing");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating the form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        add(formPanel, BorderLayout.NORTH);

        // Table for displaying records
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Name");
        model.addColumn("Age");
        
        JScrollPane tablePane = new JScrollPane(table);
        add(tablePane, BorderLayout.CENTER);

        // Buttons for CRUD operations
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners for Buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                if (!name.isEmpty() && !age.isEmpty()) {
                    model.addRow(new Object[]{name, age});
                    clearFields();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRowIndex != -1) {
                    model.setValueAt(nameField.getText(), selectedRowIndex, 0);
                    model.setValueAt(ageField.getText(), selectedRowIndex, 1);
                    clearFields();
                    selectedRowIndex = -1;
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    clearFields();
                    selectedRowIndex = -1;
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Mouse listener to select row for update
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRowIndex = table.getSelectedRow();
                if (selectedRowIndex != -1) {
                    nameField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    ageField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                }
            }
        });

        setVisible(true);
    }

    // Clear form fields
    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
    }

    public static void main(String[] args) {
        new CrudApp();
    }
}
