/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Account;
import Entity.TheLastLogin;
import Utils.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KietHV
 */
public class TheLastLoginDAO {

    String SELECT_ALL = "SELECT * FROM the_last_login";
    String UPDATE = "UPDATE THE_LAST_LOGIN SET REMEMBER = ?";

    public TheLastLogin selectAllLogin() {
        return this.selectBySql(SELECT_ALL);
    }

    private TheLastLogin selectBySql(String SELECT_ALL) {
        TheLastLogin entity = new TheLastLogin();
        try {
            ResultSet rs = XJDBC.query(SELECT_ALL);
            while (rs.next()) {
                entity.setRemember(rs.getBoolean("remember"));
            }
            rs.getStatement().getConnection().close();
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(boolean remember) {
        XJDBC.update(UPDATE, remember);
    }
}
