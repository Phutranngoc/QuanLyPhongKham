/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Thuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class ThuocDAO  extends PlusDAO<Thuoc, String>{
    String INSERT_SQL = "insert into Thuoc(MaThuoc,Tenthuoc, HDS, DonVi,GiaTien) values(?,?,?,?,?)";
    String UPDATE_SQL = "update Thuoc set Tenthuoc=?, HDS=?, DonVi=?,GiaTien=?  where MaThuoc=?";
    String DELETE_SQL = "delete from Thuoc where MaThuoc=?";
    String SELECT_ALL_SQL = "select * from Thuoc";
    String SELECT_BY_ID_SQL = "select * from Thuoc where MaThuoc=?";
    @Override
    public void insert(Thuoc entity) {
    Xjdbc.update(INSERT_SQL,entity.getMaThuoc(),entity.getTenthuoc(),entity.getHSD(),entity.getDVT(),entity.getGiaTien());
            
    }

    @Override
    public void update(Thuoc entity) {
        Xjdbc.update(UPDATE_SQL,entity.getTenthuoc(),entity.getHSD(),entity.getDVT(),entity.getGiaTien(),entity.getMaThuoc());
    }

    @Override
    public void delete(String id) {
      Xjdbc.update(DELETE_SQL,id);
    }

    @Override
    public Thuoc selectById(String id) {
          List<Thuoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Thuoc> selectALL() {
       return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Thuoc> selectBySql(String sql, Object... args) {
  List<Thuoc> list = new ArrayList<Thuoc>();
       try{
           ResultSet rs = Xjdbc.query(sql, args);
           while(rs.next()){
               Thuoc entity = new Thuoc();
               entity.setMaThuoc(rs.getString("MaThuoc"));
               entity.setTenthuoc(rs.getString("Tenthuoc"));
               entity.setHSD(rs.getString("HDS"));
               entity.setDVT(rs.getString("DonVi"));
               entity.setGiaTien(rs.getString("GiaTien"));
               
               list.add(entity);
           }
           rs.getStatement().getConnection().close();
           return list;
       }catch(Exception e){
           throw new RuntimeException(e);
       }    }
    
}
