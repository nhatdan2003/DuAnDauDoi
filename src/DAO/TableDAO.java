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
public class TableDAO extends DAO<Table, String>{

	
	String SELECT_ALL_SQL = "SELECT * FROM [Table]";
	String SELETE_BY_ID_SQL = "SELECT * FROM [Table] WHERE IDTable = ?";
	String SELETE_BY_NAME_SQL = "SELECT * FROM [Table] WHERE NameTable = ?";
	
	@Override
	public void insert(Table entity) {
	}

	@Override
	public void update(Table entity) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void delete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Table selectById(String id) {
		List<Table> list = selectBySql(SELETE_BY_ID_SQL, new Object[]{id});
		return (list.size() > 0) ? list.get(0) : null;
	}

	public Table selectByName(String name) {
		List<Table> list = selectBySql(SELETE_BY_NAME_SQL, new Object[]{name});
		return (list.size() > 0) ? list.get(0) : null;
	}
	
	@Override
	public List<Table> selectAll() {
		return selectBySql(SELECT_ALL_SQL, new Object[0]);
	}

	@Override
	protected List<Table> selectBySql(String sql, Object... args) {
		List<Table> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJDBC.query(sql, args);
				while (rs.next()) {
					Table entity = new Table();
					entity.setIdTable(rs.getString("IDTable"));
					entity.setTableName(rs.getString("NameTable"));
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
