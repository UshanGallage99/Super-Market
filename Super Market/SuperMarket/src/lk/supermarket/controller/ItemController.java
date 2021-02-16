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
import java.util.ArrayList;
import lk.supermarket.db.DBConnection;
import lk.supermarket.model.Item;
import lk.supermarket.model.OrderDetails;

/**
 *
 * @author Gebruiker
 */
public class ItemController {
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Item Values(?,?,?,?,?)");
        stm.setObject(1, item.getItemCode());
        stm.setObject(2, item.getDiscription());
        stm.setObject(3, item.getPackSize());
        stm.setObject(4, item.getUnitPrice());
        stm.setObject(5, item.getQtyOnHand());
        int res = stm.executeUpdate();
        return res>0;
    }
     public static Item searchItem(String ItemCode) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Item where ItemCode=?");
        stm.setObject(1, ItemCode);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            Item item=new Item(rst.getString("ItemCode"), rst.getString("Discription"),rst.getString("PackSize"),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            return item;
        }
        return null;
     }
     public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Item set Discription=?, PackSize=?, UnitPrice=?, QtyOnHand=? where ItemCode=?");
        stm.setObject(1, item.getDiscription());
        stm.setObject(2, item.getPackSize());
        stm.setObject(3, item.getUnitPrice());
        stm.setObject(4, item.getQtyOnHand());
        stm.setObject(5, item.getItemCode());
        return stm.executeUpdate()>0;
    }
    public static boolean removeItem(String ItemCode) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Item where ItemCode='"+ItemCode+"'")>0;
    }
    public static ArrayList<Item> loadAllItems() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * From Item");
        ArrayList<Item> alItems = new ArrayList<>();
        while (rst.next()) {

            Item item = new Item();
            item.setItemCode(rst.getString(1));
            item.setDiscription(rst.getString(2));
            item.setPackSize(rst.getString(3));
            item.setUnitPrice(rst.getDouble(4));
            item.setQtyOnHand(rst.getInt(5));

            alItems.add(item);
        }
        return alItems;

    }
    public static boolean updateStock(ArrayList<OrderDetails> orderDetailList) throws ClassNotFoundException, SQLException{
        for (OrderDetails orderDetails : orderDetailList) {
            boolean isUpdate=updateStock(orderDetails);
            if(!isUpdate){
                return false;
            }
        }
        return true;
    }
    public static boolean updateStock(OrderDetails orderDetails) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("update Item set QtyOnHand=QtyOnHand-? where ItemCode=?");
        stm.setObject(1, orderDetails.getOrderQty());
        stm.setObject(2, orderDetails.getItemCode());
        return stm.executeUpdate()>0;
    }
}
