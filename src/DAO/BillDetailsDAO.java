/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.BillDetail;
import Entity.Promotions;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dantr
 */
public class BillDetailsDAO extends DAO<BillDetail, String> {
    String SELETE_BY_IDOrder_SQL = "SELECT * FROM [Order] WHERE IDOrder = ?";
    String SELETE_BY_ID_SQL = "SELECT * FROM BillDetail WHERE IDOrder like ?"; // sql tìm tất cả cá sp
   String SELECT_ALL_properties_SQL = "SELECT * FROM BillDetail";
    @Override
    public void insert(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BillDetail selectById(String id) {
        List<BillDetail> list = selectBySql(SELETE_BY_IDOrder_SQL, id);
        return (list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public List<BillDetail> selectAll() {
        return selectBySql(SELECT_ALL_properties_SQL, new Object[0]);
    }

    @Override
    protected List<BillDetail> selectBySql(String sql, Object... args) {
        List<BillDetail> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    BillDetail bill = new BillDetail();
                    bill.setIDorder(rs.getString("IDOrder"));
                    bill.setDateOrder(rs.getString("DateOrder"));
                    bill.setTimeOrder(rs.getString("TimeOrder"));
                    bill.setUsername(rs.getString("UserName"));
                    bill.setSubTotal(Double.parseDouble(rs.getString("SubTotal")));
                    bill.setDiscountPromo(Double.valueOf(rs.getString("DiscountPromo")));
                    bill.setTotal(Double.valueOf(rs.getString("Total")));
                    list.add(bill);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }// end try ngoài

        return list;
    }

}// end class
