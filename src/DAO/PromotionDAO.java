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
public class PromotionDAO extends DAO<Promotions, String> {

    String INSERT_SQL = "INSERT INTO Promotions(IDPromo,NamePromo,DiscountPromo,Description)VALUES(?,?,?,?)"; // sql thêm dữ liệu
    String UPDATE_SQL = "UPDATE Promotions SET NamePromo = ?,DiscountPromo =?,Description = ? where IDPromo = ?"; // sql cập nhập dữ liệu
    String DELETE_SQL = "DELETE FROM Promotions WHERE IDPromo =?";// sql xóa dữ liệu
    String SELECT_ALL_SQL = "SELECT * FROM Promotions";// sql tìm tất cả
    String SELETE_BY_ID_SQL = "SELECT * FROM Promotions WHERE IDPromo = ?"; // sql tìm theo mã
    String SEARCH_BY_SQL = "SELECT * FROM Promotions WHERE IDProduct LIKE ? OR ProductName LIKE ? OR Price = ?";// sql tìm nhiều thành phần

    @Override
    public void insert(Promotions model) {
        XJDBC.update(INSERT_SQL, 
            model.getIdPromo(),
            model.getNamePromo(),
            Double.valueOf(model.getDiscountPromo()),
            model.getDescription()
        );
    }

    @Override
    public void update(Promotions model) {
        XJDBC.update(UPDATE_SQL, new Object[]{
            model.getIdPromo(),
            model.getNamePromo(),
            Double.valueOf(model.getDiscountPromo()),
            model.getDescription()
        });

    }

    @Override
    public void delete(String id) {
        XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public Promotions selectById(String id) {
      List<Promotions> list = selectBySql(SELETE_BY_ID_SQL, id);
		return (list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public List<Promotions> selectAll() { // tìm tất cả
        return selectBySql(SELECT_ALL_SQL);
    }

    // txt tìm kiếm tham khảo
//public List<Product> searchSQL(String key, double num){
//		return selectBySql(SEARCH_BY_SQL, new Object[]{
//			"%"+key+"%",
//			"%"+key+"%",
//			
//			num
//
//		});
//	}
    @Override
    protected List<Promotions> selectBySql(String sql, Object... args) {
        List<Promotions> list = new ArrayList<>();
        try {
                    ResultSet rs = null;
                    try {
                            rs = XJDBC.query(sql, args);
                            while(rs.next()){
                                Promotions pro = new Promotions();
                                pro.setIdPromo(rs.getString("IDPromo"));
                                pro.setNamePromo(rs.getString("NamePromo"));
                                pro.setDiscountPromo(Double.valueOf(rs.getString("DiscountPromo")));
                                pro.setDescription(rs.getString("Description"));
                                list.add(pro);
                            }
                    } finally{
                        rs.getStatement().getConnection().close();
                    }// end try trong

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
            
        }// end try ngoài
        return list;
    }

}// end class
