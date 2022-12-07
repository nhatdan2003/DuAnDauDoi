package DAO;

import Entity.*;
import Utils.*;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haoireal
 */
public class OrderDAO extends DAO<Order, String>{
	String INSERT_SQL = "INSERT INTO [Order](IDOrder,DateOrder,TimeOrder,Username,IDTable,StatusTable)VALUES(?,?,?,?,?,?)";
	String UPDATE_SQL = "UPDATE [Order] SET OrderName = ?,IDType =?,Price = ?,Image =?,Description = ? where IDOrder = ?";
	String DELETE_SQL = "DELETE FROM [Order] WHERE IDOrder =?";
	String SELECT_ORDER_ALL_SQL = "SELECT * FROM [Order]";
	String SELETE_BY_ID_SQL = "SELECT * FROM [Order] WHERE IDOrder = ?";
	@Override
	public void insert(Order entity) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void update(Order entity) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Order selectById(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<Order> selectAll() {
		return selectBySql(SELECT_ORDER_ALL_SQL, new Object[0]);
	}

	@Override
	protected List<Order> selectBySql(String sql, Object... args) {
		List<Order> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJDBC.query(sql, args);
				while (rs.next()) {
					Order entity = new Order();
					entity.setIdOrder(rs.getString("IDOrder"));
					
					entity.setDateOrder(XDate.toDate(rs.getString("DateOrder"), "yyyy-DD-mm"));
					entity.setTimeOrder(XDate.toDate(rs.getString("TimeOrder"), "HH:mm"));
					entity.setUserName(rs.getString("Username"));
					entity.setIdTable(rs.getString("IDTable"));
					entity.setStatusTable(rs.getBoolean("StatusTable"));
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
	
}
