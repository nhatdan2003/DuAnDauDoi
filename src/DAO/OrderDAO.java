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
	String INSERT_SQL = "INSERT INTO [Order](IDOrder,DateOrder,TimeOrder,IDPromo,TotalPrice,Username)VALUES(?,?,?,?,?,?)";
	String UPDATE_SQL = "UPDATE [Order] SET DateOrder = ?,TimeOrder =?,IDPromo = ?,Image =?,Description = ? where IDOrder = ?";
	String DELETE_SQL = "DELETE FROM [Order] WHERE IDOrder =?";
	String SELECT_ORDER_ALL_SQL = "SELECT * FROM [Order]";
	String SELETE_BY_ID_SQL = "SELECT * FROM [Order] WHERE IDOrder = ?";
	@Override
	public void insert(Order model) {
		XJDBC.update(INSERT_SQL, new Object[]{
			model.getIdOrder(),
			model.getDateOrder(),
			model.getTimeOrder(),
			model.getIdPromo(),
			Double.valueOf(model.getTotalPrice()),
			model.getUserName()});
	}

	@Override
	public void update(Order entity) {
		
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
					entity.setDateOrder(XDate.toDate(rs.getString("DateOrder"), "yyyy-dd-MM"));
					entity.setTimeOrder(rs.getString("TimeOrder"));
					entity.setIdPromo(rs.getString("IDPromo"));
					entity.setTotalPrice(rs.getDouble("TotalPrice"));
					entity.setUserName(rs.getString("Username"));
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
