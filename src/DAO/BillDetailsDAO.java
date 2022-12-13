/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.*;
import Utils.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dantr
 */
public class BillDetailsDAO extends DAO<BillDetail, String> {
    String INSERT_SQL = "INSERT INTO BillDetail(IDOrder,DateOrder,TimeOrder,Username,SubTotal,DiscountPromo,Total,Pay,ReadyCash,PayMents)VALUES(?,?,?,?,?,?,?,?,?,?)"; // sql thêm dữ liệu
//    String UPDATE_SQL = "UPDATE BillDetail SET IDBillDetail = ?,IDOrder =?,DateOrder = ?,TimeOrder = ?,Username = ?,SubTotal = ?,DiscountPromotion = ?,Total = ? where IDOrder = ?"; // sql cập nhập dữ liệu
//    String DELETE_SQL = "DELETE FROM BillDetail WHERE IDOrder =?";// sql xóa dữ liệu
    String SELECT_ALL_SQL = "SELECT * FROM BillDetail";// sql tìm tất cả
    String SELETE_BY_ID_SQL = "SELECT * FROM BillDetail WHERE IDOrder = ?"; // sql tìm theo mã
//    String SEARCH_BY_SQL = "SELECT * FROM Promotions WHERE IDProduct LIKE ? OR ProductName LIKE ? OR Price = ?";// sql tìm nhiều thành phần
    
    // thêm dữ liệu vào bảng qua bảng oderDetail
    @Override
    public void insert(BillDetail model) {
        XJDBC.update(INSERT_SQL, 
                    model.getIDorder(),
                    model.getDateOrder(),
                    model.getTimeOrder(),
                    model.getUsername(),
                    Double.valueOf(model.getSubTotal()),
                    Double.valueOf(model.getDiscountPromo()),
                    Double.valueOf(model.getTotal()),
                    Double.valueOf(model.getTotal()),
                    Double.valueOf(model.getTotal()),
                    Double.valueOf(model.getTotal())
                    
        );

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
        List<BillDetail> list = selectBySql(SELECT_ALL_SQL, id);
        return (list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public List<BillDetail> selectAll() {
        return selectBySql(SELECT_ALL_SQL, new Object[0]);
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
                    bill.setIDBillDetail(rs.getString("IDBillDetail"));
                    bill.setIDorder(rs.getString("IDOrder"));
                    bill.setDateOrder(XDate.toDate(rs.getString("DateOrder"), "yyyy-dd-MM"));
                    bill.setTimeOrder(rs.getString("TimeOrder"));
                    bill.setUsername(rs.getString("UserName"));
                    bill.setSubTotal(Double.parseDouble(rs.getString("SubTotal")));
                    bill.setDiscountPromo(Double.valueOf(rs.getString("DiscountPromo")));
                    bill.setTotal(Double.valueOf(rs.getString("Total")));
                    bill.setPay(Double.valueOf(rs.getString("Pay")));
                    bill.setReadyCash(Double.valueOf(rs.getString("ReadyCash")));
                    bill.setPayMent(Double.valueOf(rs.getString("PayMent")));
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
