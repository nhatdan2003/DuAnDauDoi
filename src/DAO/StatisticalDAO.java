/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.ChartTurnover;
import Entity.Order;
import Entity.Turnover;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KietHV
 */
//Thong ke DAO
public class StatisticalDAO {

    String Select_all = "	select \n"
            + "		pro.IDProduct,\n"
            + "		pro.ProductName,\n"
            + "		SUM(oddt.Quantity) as 'Soluong',\n"
            + "		(SUM(oddt.Quantity * pro.Price)) - (SUM(oddt.Quantity * pro.Price) - SUM(oddt.TotalPrice)) as 'DoanhThu'\n"
            + "	from Product pro\n"
            + "		join OrderDetails oddt on oddt.IDProduct = pro.IDProduct\n"
            + "		join [Order] od on od.IDOrder = oddt.IDOrder\n"
            + "\n"
            + "	group by pro.IDProduct,pro.ProductName";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>(); //tao doi tuong object de luu du lieu
            ResultSet rs = XJDBC.query(sql, args); //thuc hien cau lenh
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]); //add du lieu voi so dong tuong ung
                }
                list.add(vals);// add doi tuong vals vao list
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //get doanh thu
    public List<Turnover> getTurnover(int Month, int years) {
        String sql = "{CALL sp_DoanhThu(?,?)}"; //cau lenh sql
//        String[] cols = {"IDProduct","ProductName","Soluong","DoanhThu"};
        return this.selectBySQL(sql, Month, years);
    }

    protected List<Turnover> selectBySQL(String sql, Object... args) {
        List<Turnover> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {
                Turnover entity = new Turnover();
                entity.setIDProduct(rs.getString("IDProduct"));
                entity.setProductName(rs.getString("ProductName"));
                entity.setQuantitySold(rs.getInt("Soluong"));
                entity.setTurnover(rs.getDouble("DoanhThu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Turnover> selectALL() {
        return this.selectBySQL(Select_all);
    }

    public List<ChartTurnover> getTurnoverChart(String years) {
        String sql = "select Month(Timeod) as 'Month_Order', sum(TotalPrice) as 'Turnover_Order' from OrderDetails\n"
                + "where year(Timeod) = ?\n"
                + "group by Month(Timeod)"; //cau lenh sql
//        String[] cols = {"IDProduct","ProductName","Soluong","DoanhThu"};
        return this.selectBySQLChart(sql, years);
    }

    protected List<ChartTurnover> selectBySQLChart(String sql, Object... args) {
        List<ChartTurnover> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {
                ChartTurnover entity = new ChartTurnover();
                entity.setMonth(rs.getString("Month_Order"));
                entity.setTotalTurnoverMonth(rs.getDouble("Turnover_Order"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Order> selectALLOrder() {
        return this.selectBySQLOrder("select * from [order]");
    }
    
    public List<Order> getTurnoverorder(int Month, int years) {
        String sql = "select IDorder, DateOrder,TimeOrder,IDPromo,TotalPrice,Username from [order] where month(DateOrder) = ? and year(DateOrder) = ?"; //cau lenh sql
//        String[] cols = {"IDProduct","ProductName","Soluong","DoanhThu"};
        return this.selectBySQLOrder(sql, Month, years);
    }

    protected List<Order> selectBySQLOrder(String sql, Object... args) {
        List<Order> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {
                Order entity = new Order();
                entity.setIdOrder(rs.getString("IDOrder"));
                entity.setDateOrder(rs.getDate("DateOrder"));
                entity.setTimeOrder(rs.getString("TimeOrder"));
                entity.setIdPromo(rs.getString("IDPromo"));
                entity.setTotalPrice(rs.getDouble("TotalPrice"));
                entity.setUserName(rs.getString("Username"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

}
