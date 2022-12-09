/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author dantr
 */
public class BillPay {

    String IDBillPay;
    double  pay, readyCash, payMents;

    public BillPay() {
    }

    public BillPay(String IDBillPay, double toTal, double pay, double readyCash, double payMents) {
        this.IDBillPay = IDBillPay;      
        this.pay = pay;
        this.readyCash = readyCash;
        this.payMents = payMents;
    }

    public String getIDBillPay() {
        return IDBillPay;
    }

    public void setIDBillPay(String IDBillPay) {
        this.IDBillPay = IDBillPay;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getReadyCash() {
        return readyCash;
    }

    public void setReadyCash(double readyCash) {
        this.readyCash = readyCash;
    }

    public double getPayMents() {
        return payMents;
    }

    public void setPayMents(double payMents) {
        this.payMents = payMents;
    }

}
