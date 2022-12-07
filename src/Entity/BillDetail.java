/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author dantr
 */
public class BillDetail {
    String IDPayDetails,IDOrderDetails,Fullname,TableDetail,TimeNow,ProductName,ProductPrice,Quantity,IntoMoney;
    double Promotion;

    public BillDetail() {
    }

    public BillDetail(String IDPayDetails, String IDOrderDetails, String Fullname, String TableDetail, String TimeNow, String ProductName, String ProductPrice, String Quantity, String IntoMoney, double Promotion) {
        this.IDPayDetails = IDPayDetails;
        this.IDOrderDetails = IDOrderDetails;
        this.Fullname = Fullname;
        this.TableDetail = TableDetail;
        this.TimeNow = TimeNow;
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.Quantity = Quantity;
        this.IntoMoney = IntoMoney;
        this.Promotion = Promotion;
    }

    public String getIDPayDetails() {
        return IDPayDetails;
    }

    public void setIDPayDetails(String IDPayDetails) {
        this.IDPayDetails = IDPayDetails;
    }

    public String getIDOrderDetails() {
        return IDOrderDetails;
    }

    public void setIDOrderDetails(String IDOrderDetails) {
        this.IDOrderDetails = IDOrderDetails;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getTableDetail() {
        return TableDetail;
    }

    public void setTableDetail(String TableDetail) {
        this.TableDetail = TableDetail;
    }

    public String getTimeNow() {
        return TimeNow;
    }

    public void setTimeNow(String TimeNow) {
        this.TimeNow = TimeNow;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getIntoMoney() {
        return IntoMoney;
    }

    public void setIntoMoney(String IntoMoney) {
        this.IntoMoney = IntoMoney;
    }

    public double getPromotion() {
        return Promotion;
    }

    public void setPromotion(double Promotion) {
        this.Promotion = Promotion;
    }

    
   
    
}
