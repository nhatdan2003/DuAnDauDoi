package DAO;

import Entity.*;
import Utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author haoireal
 */
public class ProductDAO extends DAO<Product, String> {

	String INSERT_SQL = "INSERT INTO Product(IDProduct,ProductName,IDType,Price,Image,Description)VALUES(?,?,?,?,?,?)";
	String UPDATE_SQL = "UPDATE Product SET ProductName = ?,IDType =?,Price = ?,Image =?,Description = ? where IDProduct = ?";
	String DELETE_SQL = "DELETE FROM Product WHERE IDProduct =?";
	String SELECT_ALL_SQL = "SELECT * FROM Product";
	String SELETE_BY_ID_SQL = "SELECT * FROM Product WHERE IDProduct = ?";
	String SELETE_BY_NAME_SQL = "SELECT * FROM Product WHERE ProductName = ?";
	String SELETE_BY_TYPE = "SELECT * FROM Product WHERE IDType = ?";
	String SEARCH_BY_SQL = "SELECT * FROM Product WHERE IDProduct LIKE ? OR ProductName LIKE ? OR Price = ?";
	

	@Override
	public void insert(Product model) {
		XJDBC.update(INSERT_SQL, new Object[]{
			model.getIdProduct(),
			model.getProductName(),
			model.getTypePro(),
			Double.valueOf(model.getPrice()),
			model.getImage(),
			model.getDescreption()});
	}

	@Override
	public void update(Product model) {
		XJDBC.update(UPDATE_SQL, new Object[]{
			model.getProductName(),
			model.getTypePro(),
			Double.valueOf(model.getPrice()),
			model.getImage(),
			model.getDescreption(),
			model.getIdProduct()});
	}

	@Override
	public void delete(String id) {
		XJDBC.update(DELETE_SQL, id);
	}

	@Override
	public Product selectById(String IDProduct) {
		List<Product> list = selectBySql(SELETE_BY_ID_SQL, new Object[]{IDProduct});
		return (list.size() > 0) ? list.get(0) : null;
	}

	public Product selectByName(String Name) {
		List<Product> list = selectBySql(SELETE_BY_NAME_SQL, new Object[]{Name});
		return (list.size() > 0) ? list.get(0) : null;
	}
	
	@Override
	public List<Product> selectAll() {
		return selectBySql(SELECT_ALL_SQL, new Object[0]);
	}
	
	public List<Product> searchSQL(String key, double num){
		return selectBySql(SEARCH_BY_SQL, new Object[]{
			"%"+key+"%",
			"%"+key+"%",
			
			num

		});
	}
	public List<Product> selectByType(String key){
		return selectBySql(SELETE_BY_TYPE, new Object[]{key});
	}
	
	@Override
	protected List<Product> selectBySql(String sql, Object... args) {
		List<Product> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJDBC.query(sql, args);
				while (rs.next()) {
					Product entity = new Product();
					entity.setIdProduct(rs.getString("IDProduct"));
					entity.setProductName(rs.getString("ProductName"));
					entity.setTypePro(rs.getString("IDType"));
					entity.setPrice(rs.getDouble("Price"));
					entity.setImage(rs.getString("Image"));
					entity.setDescreption(rs.getString("Description"));
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
