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
public class Customer {
    private String CustID;
    private String CustTitle;
    private String CustName;
    private String CustAddress;
    private String City;
    private String Province;
    private String PostalCode;
    
     public Customer() {
    }
    
      public Customer(String CustID,String CustTitle,String CustName,String CustAddress,String City,String Province,String PostalCode) {
          this.CustID=CustID;
          this.CustTitle=CustTitle;
          this.CustName=CustName;
          this.CustAddress=CustAddress;
          this.City=City;
          this.Province=Province;
          this.PostalCode=PostalCode;
    }
    
    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID =CustID;
    }
    
     public String getCustTitle() {
        return CustTitle;
    }

    public void setCustTitle(String CustTitle) {
        this.CustTitle=CustTitle;
    }
    
    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName=CustName;
    }
    
    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String CustAddress) {
        this.CustAddress=CustAddress;
    }
    
     public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City=City;
    }
    
     public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province=Province;
    }
    
     public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode=PostalCode;
    }
}
