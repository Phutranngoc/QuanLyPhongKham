/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import util.Xjdbc;
import Entity.Account;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends PlusDAO<Account, String>{
     String INSERT_SQL = "insert into Account(UserName,Password) values(?,?)";
    String UPDATE_SQL = "update Account set Password=? where UserName=?";
    String DELETE_SQL = "delete from Account where UserName=?";
    String SELECT_ALL_SQL = "select * from Account";
    String SELECT_BY_ID_SQL = "select * from Account where UserName=?";

    @Override
    public void insert(Account entity) {
        Xjdbc.update(INSERT_SQL,entity.getUserName(),entity.getPassword());
    }

    @Override
    public void update(Account entity) {
         Xjdbc.update(UPDATE_SQL,entity.getPassword(),entity.getUserName());
    }

    @Override
    public void delete(String id) {
       Xjdbc.update(DELETE_SQL, id);
    }

    @Override
    public Account selectById(String UserName) {
     List<Account> list = this.selectBySql(SELECT_BY_ID_SQL, UserName);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    

    @Override
    public List<Account> selectALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Account> selectBySql(String sql, Object... args) {
        List<Account> list = new ArrayList<Account>();
       try{
           ResultSet rs = Xjdbc.query(sql, args);
           while(rs.next()){
               Account entity = new Account();
               entity.setUserName(rs.getString("Username"));
               entity.setPassword(rs.getString("Password"));
               entity.setVaiTro(rs.getBoolean("vaitro"));
               list.add(entity);
           }
           rs.getStatement().getConnection().close();
           return list;
       }catch(Exception e){
           throw new RuntimeException(e);
       }
    }
}
