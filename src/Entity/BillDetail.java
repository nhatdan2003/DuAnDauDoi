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

    String IDorder,  DateOrder, TimeOrder, Username;
    double SubTotal,DiscountPromo, Total;

    public BillDetail() {
    }

    public BillDetail(String IDorder, String DateOrder, String TimeOrder, String Username, double SubTotal, double DiscountPromo, double Total) {
        this.IDorder = IDorder;
        this.DateOrder = DateOrder;
        this.TimeOrder = TimeOrder;
        this.Username = Username;
        this.SubTotal = SubTotal;
        this.DiscountPromo = DiscountPromo;
        this.Total = Total;
    }

    public String getIDorder() {
        return IDorder;
    }

    public void setIDorder(String IDorder) {
        this.IDorder = IDorder;
    }

    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String DateOrder) {
        this.DateOrder = DateOrder;
    }

    public String getTimeOrder() {
        return TimeOrder;
    }

    public void setTimeOrder(String TimeOrder) {
        this.TimeOrder = TimeOrder;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getDiscountPromo() {
        return DiscountPromo;
    }

    public void setDiscountPromo(double DiscountPromo) {
        this.DiscountPromo = DiscountPromo;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

  
    
}// end class
