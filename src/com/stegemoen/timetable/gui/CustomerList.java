/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.gui;
import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.data.Customers;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class CustomerList extends JFrame implements ActionListener, ListSelectionListener{
    JFrame frame;
    JButton jbtn_AddCustomers;
    JList<String> jl_Customers;
    JScrollPane jScrollPane;
    
    public CustomerList(){
        ArrayList<Customer> c = new Customers().getItems();
        String customers[] = new String[c.size()];
        for(int i=0; i < c.size(); i++){
            customers[i] = c.get(i).getCompanyName();
        }
        
        setLayout(new FlowLayout());
        setSize(300, 340);
        jl_Customers = new JList<String>(customers);
        jl_Customers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane = new JScrollPane(jl_Customers);
        jScrollPane.setPreferredSize(new Dimension(260, 90));
        add(jScrollPane);
        jbtn_AddCustomers = new JButton("Add Customers");
        jbtn_AddCustomers.addActionListener(this);
        add(jbtn_AddCustomers);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Customers")){
            dispose();
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    new AddCustomer().setVisible(true);
                }
            });
            
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new CustomerList().setVisible(true);
            }
        });
    }
    
}
