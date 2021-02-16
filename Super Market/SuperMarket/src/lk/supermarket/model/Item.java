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
public class Item {
    private String ItemCode;
    private String Discription;
    private String PackSize;
    private Double UnitPrice;
    private int QtyOnHand;
    
     public Item() {
    }
    public Item(String ItemCode,String Discription,String PackSize,Double UnitPrice,int QtyOnHand){
        this.ItemCode= ItemCode;
        this.Discription=Discription;
        this.PackSize=PackSize;
        this.QtyOnHand=QtyOnHand;
        this.UnitPrice=UnitPrice;
    }
    
    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode=ItemCode;
    }
    
     public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription=Discription;
    }
    
    public String getPackSize() {
        return PackSize;
    }

    public void setPackSize(String PackSize) {
        this.PackSize=PackSize;
    }
    
    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double UnitPrice) {
        this.UnitPrice=UnitPrice;
    }
    
     public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int QtyOnHand) {
        this.QtyOnHand=QtyOnHand;
    }
    @Override
    public String toString() {
        return "Item{" + "ItemCode=" + ItemCode + ", Discription=" + Discription + ",PackSize=" + PackSize + ", UnitPrice=" + UnitPrice + ", QtyOnHand=" + QtyOnHand + '}';
    }   
 
}
