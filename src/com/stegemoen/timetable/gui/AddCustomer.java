/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.gui;
import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.data.Customers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author hsteg
 */
public class AddCustomer extends JFrame implements ActionListener {
    JLabel jl_CompanyName;
    JLabel jl_ShortName;
    JLabel jl_ContactName;
    JLabel jl_Email;
    JLabel jl_Phone;
    JTextField jtf_CompanyName;
    JTextField jtf_ShortName;
    JTextField jtf_ContactName;
    JTextField jtf_ContactEmail;
    JTextField jtf_ContactPhone;
    JButton btn_CustomerList;
    JButton btn_Submit;
    
    public AddCustomer(){
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 340);
        setPreferredSize(new Dimension(250, 340));
        setLayout(new FlowLayout());
        jl_CompanyName = new JLabel("Company Name: ");
        jl_CompanyName.setPreferredSize(new Dimension(100, 16));
        jl_ShortName = new JLabel("Short Name: ");
        jl_ShortName.setPreferredSize(new Dimension(100, 16));
        jl_ContactName = new JLabel("Contact Name: ");
        jl_ContactName.setPreferredSize(new Dimension(100, 16));
        jl_Email = new JLabel("Contact Email: ");
        jl_Email.setPreferredSize(new Dimension(100, 16));
        jl_Phone = new JLabel("Contact Phone: ");
        jl_Phone.setPreferredSize(new Dimension(100, 16));
        jtf_CompanyName = new JTextField();
        jtf_CompanyName.setPreferredSize(new Dimension(100, 16));
        jtf_ShortName = new JTextField();
        jtf_ShortName.setPreferredSize(new Dimension(100, 16));
        jtf_ContactName = new JTextField();
        jtf_ContactName.setPreferredSize(new Dimension(100, 16));
        jtf_ContactEmail = new JTextField();
        jtf_ContactEmail.setPreferredSize(new Dimension(100, 16));
        jtf_ContactPhone = new JTextField();
        jtf_ContactPhone.setPreferredSize(new Dimension(100, 16));
        btn_CustomerList = new JButton("List");
        btn_CustomerList.setPreferredSize(new Dimension(100, 16));
        btn_CustomerList.addActionListener(this);
        btn_Submit = new JButton("Submit");
        btn_Submit.setPreferredSize(new Dimension(100, 16));
        btn_Submit.addActionListener(this);
        
        add(jl_CompanyName);
        add(jtf_CompanyName);
        add(jl_ShortName);
        add(jtf_ShortName);
        add(jl_ContactName);
        add(jtf_ContactName);
        add(jl_Email);
        add(jtf_ContactEmail);
        add(jl_Phone);
        add(jtf_ContactPhone);
        add(btn_CustomerList);
        add(btn_Submit);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Submit")){
            String companyName = jtf_CompanyName.getText();
            String shortName = jtf_ShortName.getText();
            String contactName = jtf_ContactName.getText();
            String contactEmail = jtf_ContactEmail.getText();
            String contactPhone = jtf_ContactPhone.getText();
            new Customers().addItem(new Customer(companyName, shortName, contactName,
                contactEmail, contactPhone));
            jtf_CompanyName.setText("");
            jtf_ShortName.setText("");
            jtf_ContactName.setText("");
            jtf_ContactEmail.setText("");
            jtf_ContactPhone.setText("");
            
        } else if(ae.getActionCommand().equals("List")){
            dispose();
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    new CustomerList().setVisible(true);
                }
            });
            
        }
    }
}
