/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.BacSi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class BacSiDAO extends PlusDAO<BacSi, String>{
    String INSERT_SQL = "insert into BacSi(MaBS,TenBS, Chuyennganh, NgaySinh, GhiChu, SDT,GioiTinh) values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "update BacSi set TenBS=?, Chuyennganh=?, NgaySinh=? ,GhiChu=? ,SDT=? ,GioiTinh=? where MaBS=?";
    String DELETE_SQL = "delete from BacSi where MaBS=?";
    String SELECT_ALL_SQL = "select * from BacSi";
    String SELECT_BY_ID_SQL = "select * from BacSi where MaBS=?";
    //String TinhTuoi= "SELECT DATEDIFF(yy, ?, GETDATE()) from bacsi";
    
    @Override
    public void insert(BacSi entity) {
        Xjdbc.update(INSERT_SQL,entity.getMaBS(),entity.getTenBS(),entity.getChuyennganh(),entity.getNgaysinh(),entity.getDiachi(),entity.getSDT(),entity.getGioitinh());
    }

    @Override
    public void update(BacSi entity) {
       Xjdbc.update(UPDATE_SQL,entity.getTenBS(),entity.getChuyennganh(),entity.getNgaysinh(),entity.getDiachi(),entity.getSDT(),entity.getGioitinh(),entity.getMaBS());
    }

    @Override
    public void delete(String id) {
         Xjdbc.update(DELETE_SQL, id);
    }

    @Override
    public BacSi selectById(String id) {
        List<BacSi> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BacSi> selectALL() {
       return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BacSi> selectBySql(String sql, Object... args) {
         List<BacSi> list = new ArrayList<BacSi>();
       try{
           ResultSet rs = Xjdbc.query(sql, args);
           while(rs.next()){
               BacSi entity = new BacSi();
               entity.setMaBS(rs.getString("MaBS"));
               entity.setTenBS(rs.getString("TenBS"));
               entity.setChuyennganh(rs.getString("Chuyennganh"));
               entity.setNgaysinh(rs.getString("NgaySinh"));
               entity.setDiachi(rs.getString("GhiChu"));
               entity.setSDT(rs.getString("SDT"));
               entity.setGioitinh(rs.getString("GioiTinh"));
               list.add(entity);
           }
           rs.getStatement().getConnection().close();
           return list;
       }catch(Exception e){
           throw new RuntimeException(e);
       }
    }
    
}
