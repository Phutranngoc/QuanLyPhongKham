/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DonThuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class DonThuocDAO extends PlusDAO<DonThuoc, String> {

    String INSERT_DonThuoc = "insert into DonThuoc(MaDT,MaBS,Lieudung) values(?,?,?)";
    String INSERT_ChiTietDonThuoc = "insert into Chitiet_DonThuoc_Thuoc(MaThuoc,MaDT) values(?,?)";
    String UPDATE_SQL = "update Thuoc set Tenthuoc=?, HDS=?, DonVi=?  where MaThuoc=?";
    String DELETE_DT = "delete from DonThuoc where MaDT=?";
    String DELETE_DTCT = "delete from Chitiet_DonThuoc_Thuoc  where MaDT=?";
    String SELECT_ALL_SQL = "select * from DonThuoc";
    String SELECT_BY_ID_SQL = "select * from DonThuoc where MaDT=?";

    @Override
    public void insert(DonThuoc entity) {

    }

    @Override
    public void update(DonThuoc entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DonThuoc selectById(String id) {
        List<DonThuoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DonThuoc> selectALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    
      public List<DonThuoc> searchByCodeOrName(String keyword) {
    String sql = "SELECT * FROM DonThuoc WHERE MaDT LIKE ? OR MaBS LIKE ?";
    return selectBySql(sql, "%" + keyword + "%", "%" + keyword + "%");
}

    @Override
    protected List<DonThuoc> selectBySql(String sql, Object... args) {
        List<DonThuoc> list = new ArrayList<DonThuoc>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                DonThuoc entity = new DonThuoc();
                entity.setMaDT(rs.getString("MaDT"));
                entity.setMaBS(rs.getString("MaBS"));
                entity.setLieudung(rs.getString("Lieudung"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
