/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.supermarket.model;

import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class Orders {
    private int OrderID;
    private String OrderDate;
    private String CustID;
     private ArrayList<OrderDetails>orderDetailList;
     
     public Orders() {
    }
     public Orders(int OrderID,String OrderDate,String CustID) {
        this.OrderID=OrderID;
        this.OrderDate=OrderDate;
        this.CustID=CustID;
       
    }
     public Orders(int OrderID,String OrderDate,String CustID, ArrayList<OrderDetails> orderDetailList) {
        this.OrderID=OrderID;
        this.OrderDate=OrderDate;
        this.CustID=CustID;
        this.orderDetailList = orderDetailList;
    }
    public Orders(String OrderDate,String CustID) {
        //this.OrderID=OrderID;
        this.OrderDate=OrderDate;
        this.CustID=CustID;
    }
    
    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID=OrderID;
    }
    
     public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate=OrderDate;
    }
    
    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID=CustID;
    }
    public ArrayList<OrderDetails> getOrderDetailList() {
        return orderDetailList;
    }

        
    public void setOrderDetailList(ArrayList<OrderDetails> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
