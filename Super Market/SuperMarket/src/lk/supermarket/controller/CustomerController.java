/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.supermarket.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.supermarket.model.Customer;
import lk.supermarket.db.DBConnection;

/**
 *
 * @author Gebruiker
 */
public class CustomerController {
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Customer Values(?,?,?,?,?,?,?)");
        stm.setObject(1, customer.getCustID());
        stm.setObject(2, customer.getCustTitle());
        stm.setObject(3, customer.getCustName());
        stm.setObject(4, customer.getCustAddress());
        stm.setObject(5, customer.getCity());
        stm.setObject(6, customer.getProvince());
        stm.setObject(7, customer.getPostalCode());
        int res = stm.executeUpdate();
        return res>0;
    }
    public static ArrayList<Customer>getAllCustomers() throws ClassNotFoundException, SQLException{
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Customer");
        ArrayList <Customer>customerList=new ArrayList<>();
        while(rst.next()){
            Customer customer=new Customer(rst.getString("CustID"), rst.getString("CustTitle"), rst.getString("CustName"), rst.getString("CustAddress"),rst.getString("City"),rst.getString("Province"),rst.getString("PostalCode"));
            customerList.add(customer);
        }
        return customerList;
    }
    public static Customer searchCustomer(String CustID) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Customer where CustID=?");
        stm.setObject(1, CustID);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
           Customer customer=new Customer(rst.getString("CustID"), rst.getString("CustTitle"), rst.getString("CustName"), rst.getString("CustAddress"),rst.getString("City"),rst.getString("Province"),rst.getString("PostalCode"));
            return customer;
        }
        return null;
    }
    
}
