package DAO;

import Entity.*;
import Utils.XDate;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haoireal
 */
public class OrderDetailDAO extends DAO<OrderDetails, String> {

	String INSERT_SQL = "INSERT INTO OrderDetails(IDProduct,IDOrder,Quantity,TotalPrice,Timeod)VALUES(?,?,?,?,?)";
	String UPDATE_SQL = "UPDATE Product SET ProductName = ?,IDType =?,Price = ?,Image =?,Description = ? where IDProduct = ?";
	String DELETE_SQL = "DELETE FROM Product WHERE IDProduct =?";
	String SELECT_ALL_ORDERDETAILS_SQL = "SELECT * FROM OrderDetails";
	String SELETE_BY_ID_SQL = "SELECT * FROM Product WHERE IDProduct = ?";
	String SELETE_BY_NAME_SQL = "SELECT * FROM Product WHERE ProductName = ?";
	String SELETE_BY_TYPE = "SELECT * FROM Product WHERE IDType = ?";
	String SEARCH_BY_SQL = "SELECT * FROM Product WHERE IDProduct LIKE ? OR ProductName LIKE ? OR Price = ?";

	public void insertLIST(List<OrderDetails> list) {
		for (OrderDetails model : list) {
			XJDBC.update(INSERT_SQL, new Object[]{
				model.getIdProduct(),
				model.getIdOrder(),
				Integer.valueOf(model.getQuantity()),
				Double.valueOf(model.getTotalPrice()),
				model.getTimeOD()});
		}
	}

	@Override
	public void update(OrderDetails entity) {
	
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public OrderDetails selectById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<OrderDetails> selectAll() {
		return selectBySql(SELECT_ALL_ORDERDETAILS_SQL, new Object[0]);
	}

	@Override
	protected List<OrderDetails> selectBySql(String sql, Object... args) {
		List<OrderDetails> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJDBC.query(sql, args);
				while (rs.next()) {
					OrderDetails entity = new OrderDetails();
					entity.setIdOrderDetails(rs.getInt("IDOrderDetails"));
					entity.setIdProduct(rs.getString("IDProduct"));
					entity.setIdOrder(rs.getString("IDOrder"));
					entity.setQuantity(rs.getInt("Quantity"));
					entity.setTotalPrice(rs.getDouble("TotalPrice"));
					entity.setTimeOD(XDate.toDate(rs.getString("Timeod"), "yyyy-MM-dd"));
					list.add(entity);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException(ex);
		}
		return list;
	}

	@Override
	public void insert(OrderDetails entity) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
