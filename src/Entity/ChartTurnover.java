/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author KietHV
 */
public class ChartTurnover {
    private String month;
    private Double totalTurnoverMonth;

    public ChartTurnover() {
    }

    public ChartTurnover(String month, Double totalTurnoverMonth) {
        this.month = month;
        this.totalTurnoverMonth = totalTurnoverMonth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getTotalTurnoverMonth() {
        return totalTurnoverMonth;
    }

    public void setTotalTurnoverMonth(Double totalTurnoverMonth) {
        this.totalTurnoverMonth = totalTurnoverMonth;
    }
    
    
}
