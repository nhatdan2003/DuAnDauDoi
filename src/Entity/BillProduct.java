/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author dantr
 */
public class BillProduct {
     String IDBillProduct, IDOrder, ProductName;
     double Quantity,Price,IntoMoney;

    public BillProduct() {
    }

    public BillProduct(String IDBillProduct, String IDOrder, String ProductName, double Quantity, double Price, double IntoMoney) {
        this.IDBillProduct = IDBillProduct;
        this.IDOrder = IDOrder;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.IntoMoney = IntoMoney;
    }

    public String getIDBillProduct() {
        return IDBillProduct;
    }

    public void setIDBillProduct(String IDBillProduct) {
        this.IDBillProduct = IDBillProduct;
    }

    public String getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(String IDOrder) {
        this.IDOrder = IDOrder;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getIntoMoney() {
        return IntoMoney;
    }

    public void setIntoMoney(double IntoMoney) {
        this.IntoMoney = IntoMoney;
    }
     
}
