package DAO;

import Entity.*;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haoireal
 */
public class TypeProductDAO extends DAO<ProductType, String> {

	String INSERT_SQL = "INSERT INTO ProductType(IDType,NameType)VALUES(?,?)";
	String UPDATE_SQL = "UPDATE ProductType SET NameType = ? where IDType = ?";
	String DELETE_SQL = "DELETE FROM ProductType WHERE IDProduct =?";
	String SELECT_ALL_SQL = "SELECT * FROM ProductType";
	String SELETE_BY_ID_SQL = "SELECT * FROM ProductType WHERE IDType = ?";

	@Override
	public void insert(ProductType entity) {
	}

	@Override
	public void update(ProductType entity) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ProductType selectById(String id) {
		List<ProductType> list = selectBySql(SELETE_BY_ID_SQL, new Object[]{id});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<ProductType> selectAll() {
		return selectBySql(SELECT_ALL_SQL);
	}

	@Override
	protected List<ProductType> selectBySql(String sql, Object... args) {
		List<ProductType> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJDBC.query(sql, args);
				while (rs.next()) {
					ProductType entity = new ProductType();
					entity.setIDType(rs.getString("IDType"));
					entity.setNameType(rs.getString("NameType"));
					list.add(entity);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return list;
	}
}


