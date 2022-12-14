/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.XJDBC;
import java.util.List;
import Entity.BillProduct;
import Entity.OrderDetails;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dantr
 */
public class BillProductDAO extends DAO<BillProduct, String> {

    String INSERT_SQL = "INSERT INTO BillProduct (IDOrder,ProductName,Quantity,Price,IntoMoney)VALUES(?,?,?,?,?)"; // sql thêm dữ liệu
    String SELECT_ALL_SQL = "SELECT * FROM BillProduct ";// sql tìm tất cả sản phẩm theo mã hóa đơn
    String SELETE_BY_ID_SQL = "SELECT * FROM BillProduct WHERE IDOrder like ?"; // sql tìm theo mã

    public void insertLIST(List<BillProduct> list) {
        for (BillProduct model : list) {
            XJDBC.update(INSERT_SQL,
                    model.getIDOrder(),
                    model.getProductName(),
                    Double.valueOf(model.getQuantity()),
                    Double.valueOf(model.getPrice()),
                    Double.valueOf(model.getIntoMoney())
            );
        }
    }

    @Override
    public void insert(BillProduct model) {

    }

    @Override
    public void update(BillProduct entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<BillProduct> selectByIdList(String id) {
        List<BillProduct> list = selectBySql(SELETE_BY_ID_SQL, id);
        return list;
    }

    @Override
    public BillProduct selectById(String id) {
        List<BillProduct> list = selectBySql(SELETE_BY_ID_SQL, id);
        return (list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public List<BillProduct> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BillProduct> selectBySql(String sql, Object... args) {
        List<BillProduct> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {

                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    BillProduct Bpro = new BillProduct();
                    Bpro.setIDBillProduct(rs.getString("IDBillProduct"));
                    Bpro.setIDOrder(rs.getString("IDOrder"));
                    Bpro.setProductName(rs.getString("ProductName"));
                    Bpro.setQuantity(rs.getInt("Quantity"));
                    Bpro.setPrice(rs.getDouble("Price"));
                    Bpro.setIntoMoney(rs.getDouble("IntoMoney"));
                    list.add(Bpro);
                }
            } catch (Exception e) {
            }// end try trong
        } catch (Exception e) {
        }// end try ngoài 
//        System.out.println(list);
        return list;
    }// end

    public static void main(String[] args) {
        BillProductDAO billProDAO = new BillProductDAO();
        List<BillProduct> list = billProDAO.selectAll();
        System.out.println(list);
    }
}// end class
