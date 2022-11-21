/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Account;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KietHV
 */
public class AccountDao extends DAO<Account, String>{
    String INSERT_SQL = "INSERT INTO ACCOUNT(Username,Password,Gender,Birthday,Phone,Email,Address,Role)VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ACCOUNT SET Password = ?,Gender = ?, Birthday = ?, Phone = ?, Email = ?, Address = ?, Role = ? WHERE Username = ?";
    String DELETE_SQL = "DELETE FROM ACCOUNT WHERE Username = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ACCOUNT";
    String SELECT_BY_ID_SQL = "SELECT * FROM ACCOUNT WHERE Username = ?";

    @Override
    public void insert(Account entity) {
        XJDBC.update(INSERT_SQL,entity.getUserName(),entity.getPassWord(),entity.getGender(),entity.getBirthDay(),entity.getPhone(),entity.getEmail(),entity.getAddRess(),entity.getRole());
    }

    @Override
    public void update(Account entity) {
        XJDBC.update(UPDATE_SQL,entity.getPassWord(),entity.getGender(),entity.getBirthDay(),entity.getPhone(),entity.getEmail(),entity.getAddRess(),entity.getRole(),entity.getUserName());
    }

    @Override
    public void delete(String id) {
        XJDBC.update(DELETE_SQL,id);
    }

    @Override
    public Account selectById(String id) {
        List<Account> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Account> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Account> selectBySql(String sql, Object... args) {
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while(rs.next()){
                Account entity = new Account();
                entity.setUserName(rs.getString("Username"));
                entity.setPassWord(rs.getString("Password"));
                entity.setGender(rs.getBoolean("Gender"));
                entity.setBirthDay(rs.getDate("Birthday"));
                entity.setPhone(rs.getString("Phone"));
                entity.setEmail(rs.getString("Email"));
                entity.setAddRess(rs.getString("Address"));
                entity.setRole(rs.getBoolean("Role"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
