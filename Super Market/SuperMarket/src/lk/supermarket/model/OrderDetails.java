/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.supermarket.model;

/**
 *
 * @author Gebruiker
 */
public class OrderDetails {
    private int OrderID;
    private String ItemCode;
    private int OrderQty;
    private Double Discount;
    
     public OrderDetails() {
    }
    public OrderDetails(int OrderID,String ItemCode,int OrderQty) {
        this.OrderID=OrderID;
        this.ItemCode=ItemCode;
        this.OrderQty=OrderQty;
    }
    
    public int getOrderID() {
        return OrderID;
    }

    public void setCustID(int OrderID) {
        this.OrderID=OrderID;
    }
    
     public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode=ItemCode;
    }
    
    public int getOrderQty() {
        return  OrderQty;
    }

    public void setOrderQty(int OrderQty) {
        this. OrderQty=OrderQty;
    }
    
    public Double  getDiscount() {
        return Discount;
    }

    public void setDiscount(Double Discount) {
        this.Discount=Discount;
    }
    }
    
      