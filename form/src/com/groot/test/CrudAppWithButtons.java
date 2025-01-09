package com.groot.test;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class CrudAppWithButtons extends JFrame {
    private JTextField nameField, ageField;
    private JTable table;
    private DefaultTableModel model;

    public CrudAppWithButtons() {
        setTitle("CRUD with Buttons in JTable");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        add(formPanel, BorderLayout.NORTH);

        // Creating table with model
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Edit");
        model.addColumn("Delete");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Custom renderer and editor for buttons
        table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        table.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox(), "Edit"));

        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox(), "Delete"));

        // Add new row button
        JButton addButton = new JButton("Add New Row");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                if (!name.isEmpty() && !age.isEmpty()) {
                    model.addRow(new Object[]{name, age, "Edit", "Delete"});
                    clearFields();
                }
            }
        });

        add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Clear input fields
    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
    }

    // Renderer for JTable buttons
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Editor for JTable buttons
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

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // You can define what happens when "Edit" or "Delete" is clicked
                if (label.equals("Edit")) {
                    String name = table.getValueAt(table.getSelectedRow(), 0).toString();
                    String age = table.getValueAt(table.getSelectedRow(), 1).toString();
                    JOptionPane.showMessageDialog(button, "Editing row: Name = " + name + ", Age = " + age);
                } else if (label.equals("Delete")) {
                    ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
                }
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public static void main(String[] args) {
        new CrudAppWithButtons();
    }
}
