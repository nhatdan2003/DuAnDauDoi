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
    //Câu lenh SQL
    String INSERT_SQL = "INSERT INTO ACCOUNT(Fullname,Username,Password,Gender,Birthday,Phone,Email,Address,Role)VALUES (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ACCOUNT SET Fullname = ?, Password = ?, Gender = ?, Birthday = ?, Phone = ?, Email = ?, Address = ?, Role = ? WHERE Username = ?";
    String DELETE_SQL = "DELETE FROM ACCOUNT WHERE Username = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ACCOUNT";
    String SELECT_BY_ID_SQL = "SELECT * FROM ACCOUNT WHERE Username = ?";

    //insert du lieu vao database
    @Override
    public void insert(Account entity) {
        XJDBC.update(INSERT_SQL,entity.getFullName(),entity.getUserName(),entity.getPassWord(),entity.isGender(),entity.getBirthDay(),entity.getPhone(),entity.getEmail(),entity.getAddRess(),entity.isRole());
    }

    //update du lieu vao database
    @Override
    public void update(Account entity) {
        XJDBC.update(UPDATE_SQL,entity.getFullName(),entity.getPassWord(),entity.isGender(),entity.getBirthDay(),entity.getPhone(),entity.getEmail(),entity.getAddRess(),entity.isRole(),entity.getUserName());
    }
    
    //delete du lieu co ma truyen vao
    @Override
    public void delete(String id) {
        XJDBC.update(DELETE_SQL,id);
    }

    //tim theo ma
    @Override
    public Account selectById(String id) {
        List<Account> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    //lay tat ca dieu lieu trong table account trong database
    @Override
    public List<Account> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    //tao list va gan du lieu vao doi tuong
    @Override
    protected List<Account> selectBySql(String sql, Object... args) {
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, args);
            while(rs.next()){
                Account entity = new Account();
                entity.setFullName(rs.getString("Fullname"));
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
