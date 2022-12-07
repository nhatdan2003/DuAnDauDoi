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

    String INSERT_SQL = "INSERT INTO PayDetails(IDPayDetails,IDOrderDetails,Fullname,TableDetail,TimeNow,ProductName,ProductPrice,Quantity,Promotion,IntoMoney)VALUES(?,?,?,?,?,?,?,?,?,?)"; // sql thêm dữ liệu
//    String UPDATE_SQL = "UPDATE PayDetails SET IDPayDetails = ?,IDOrderDetails =?,Fullname = ?, TableDetail =? ,TimeNow = ?,Total = ?,  ProductName =?, ProductPrice = ?, Quantity = ?, Promotion = ? , IntoMoney = ?  where IDOrder= ?"; // sql cập nhập dữ liệu
    String DELETE_SQL = "DELETE FROM PayDetails WHERE IDOrder =?";// sql xóa dữ liệu
    String SELECT_ALL_SQL = "SELECT * FROM PayDetails ";// sql tìm tất cả 
    String SELETE_BY_ID_SQL = "SELECT * FROM PayDetails WHERE IDOrder = ?"; // sql hóa đơn qua ID Order
//    String SEARCH_BY_SQL = "SELECT * FROM PayDetails WHERE IDProduct LIKE ? OR ProductName LIKE ? OR Price = ?";// sql tìm nhiều thành phần
    String SELECT_FULLNAME = " select FullName from Account where  Username like ? ";
    
    String SELECT_IDTABLE = "select IDTable , NameTable From [Table] where NameTable like ?"; // Truyền vào test của button
    
    String SELECT_IDORDER_BY_IDTABLE = "SELECT IDOrder from [Order] where IDTable like ? ";
     
    String SELECT_IDPROMOTION = "select DiscountPromo from [OrderDetails] odrt join Promotions promo on odrt.IDPromo = promo.IDPromo where IDOrder like ? group by DiscountPromo" ;
    
    String SELECT_PRODUCT = "select ProductName,Quantity ,Price ,Quantity * Price as'Total' from [OrderDetails] odrt join Product pro on  odrt.IDProduct = pro.IDProduct where IDOrder like ? ";
    
    String SELECT_ALLPRODUCT_iN_ODER = "select * from OrderDetails where IDOrder like ? '";
    
    @Override
    public void insert(BillDetail model) {
            XJDBC.update(INSERT_SQL, model.getIDPayDetails(), model.getIDOrderDetails(),model.getFullname(), model.getTableDetail(), model.getTimeNow(), model.getProductName(), model.getProductPrice(), model.getQuantity(), model.getPromotion(),model.getIntoMoney());

    }

    @Override
    public void update(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
          XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public BillDetail selectById(String id) {
       List<BillDetail> list = selectBySql(SELETE_BY_ID_SQL, id);
		return (list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public List<BillDetail> selectAll() {
        return selectBySql(SELECT_ALL_SQL); // truy vấn toàn bộ sp vào oder
    }

    @Override
    protected List<BillDetail> selectBySql(String sql, Object... args) {
         List<BillDetail> list = new ArrayList<>();
        try {
                    ResultSet rs = null;
                    try {
                            rs = XJDBC.query(sql, args);
                            while(rs.next()){
                                BillDetail bill = new BillDetail();
                                bill.setIDPayDetails(rs.getString(""));
//                                list.add(pro);
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

}
