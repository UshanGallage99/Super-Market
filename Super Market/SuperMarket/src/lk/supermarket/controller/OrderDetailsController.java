/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.supermarket.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.supermarket.db.DBConnection;
import lk.supermarket.model.OrderDetails;
/**
 *
 * @author Gebruiker
 */
public class OrderDetailsController {
    public static boolean addOrderDetails(ArrayList<OrderDetails> orderDetailList) throws ClassNotFoundException, SQLException{
        for (OrderDetails orderDetails : orderDetailList) {
            boolean isAdded=addOrderDetails(orderDetails);
            if(!isAdded){
                return false;
            }
        }
        return true;
    }
    public static boolean addOrderDetails(OrderDetails orderDetail) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into OrderDetails values(?,?,?)");
        stm.setObject(1, orderDetail.getOrderID());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getOrderQty());
        return stm.executeUpdate()>0;
    }
   
}
