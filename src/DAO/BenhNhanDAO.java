/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Benhnhan;
import util.Xjdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HA NAM
 */
public class BenhNhanDAO extends PlusDAO<Benhnhan, String> {

    String Insert_Sql = "INSERT INTO BenhNhan (MaBN, Hoten, ngaysinh, Gioitinh, Diachi, Baohiem, sdt)\n"
            + "VALUES (?,?,?,?,?,?,?)";
    String Update_Sql = "UPDATE BenhNhan\n"
            + "SET Hoten = ?, ngaysinh = ?, Gioitinh = ?, Diachi = ?, Baohiem = ?, sdt = ?\n"
            + "where mabn = ?";
    String Delete_Sql = "delete from benhnhan where mabn = ?";
    String Select_All_Sql = "select * from benhnhan";
    String Select_By_Id_Sql = "select * from benhnhan where mabn = ?";

    @Override
    public void insert(Benhnhan entity) {
        Xjdbc.update(Insert_Sql,
                entity.getMaBN(),
                entity.getTenBN(),
                entity.getNgaySinh(),
                entity.getGioiTinh(),
                entity.getDiachi(),
                entity.isBaoHiem(),
                entity.getSDT());
    }

    @Override
    public void update(Benhnhan entity) {
        Xjdbc.update(Update_Sql,
                entity.getTenBN(),
                entity.getNgaySinh(),
                entity.getGioiTinh(),
                entity.getDiachi(),
                entity.isBaoHiem(),
                entity.getSDT(),
                entity.getMaBN());
    }

    @Override
    public void delete(String id) {
        Xjdbc.update(Delete_Sql, id);
    }


    @Override
    public Benhnhan selectById(String id) {
        List<Benhnhan> list = this.selectBySql(Select_By_Id_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Benhnhan> selectBySql(String sql, Object... args) {
        List<Benhnhan> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                Benhnhan entity = new Benhnhan();
                entity.setMaBN(rs.getString("MaBN"));
                entity.setTenBN(rs.getString("Hoten"));
                entity.setNgaySinh(rs.getString("ngaysinh"));
                entity.setGioiTinh(rs.getString("Gioitinh"));
                entity.setDiachi(rs.getString("Diachi"));
                entity.setBaoHiem(rs.getBoolean("Baohiem"));
                entity.setSDT(rs.getString("sdt"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Benhnhan> selectALL() {
        return this.selectBySql(Select_All_Sql);
    }
}
