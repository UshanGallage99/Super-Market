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
import java.sql.Statement;
import lk.supermarket.db.DBConnection;
import lk.supermarket.model.Orders;

/**
 *
 * @author Gebruiker
 */
public class OrderController {
    /*public static boolean addOrders(Orders orders) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Orders (OrderDate,CustId)Values(?,?)");
        //stm.setObject(1, orders. getOrderID());
        stm.setObject(1, orders.getOrderDate());
        stm.setObject(2, orders.getCustID());
         
        int res = stm.executeUpdate();
        return res>0;
    }*/
    /*public static Orders searchOrders(int OrderID) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Orders where OrderID=?");
        stm.setObject(1,OrderID);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            Orders orders=new Orders(rst.getInt("OrderID"), rst.getString("OrderDate"),rst.getString("CustID"));
            return orders;
        }
        return null;
    }*/
    /*public static boolean removeOrder(int OrderID) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Orders where OrderID='"+OrderID+"'")>0;
    }*/
    public static int getLastOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1");
        return rst.next() ? rst.getInt("OrderID") : 0;
    }
     public static boolean addOrder(Orders orders) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("Insert into Orders values(?,?,?)");
            stm.setObject(1, orders.getOrderID());
            stm.setObject(2, orders.getOrderDate());
            stm.setObject(3, orders.getCustID());
            boolean isAdded = stm.executeUpdate() > 0;
            if (isAdded) {
                boolean isAddedDetails = OrderDetailsController.addOrderDetails(orders.getOrderDetailList());
                if (isAddedDetails) {
                    boolean isUpdateStock = ItemController.updateStock(orders.getOrderDetailList());
                    if (isUpdateStock) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
        
    }
}
