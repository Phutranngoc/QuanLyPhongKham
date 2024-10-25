/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Benhnhan;
import Entity.PhieuKham;
import util.Xjdbc;
import util.XDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author HA NAM
 */
public class PhieuKhamDAO extends PlusDAO<PhieuKham, String> {

    String Insert_Sql = "INSERT INTO PhieuKham (MaPhieuKham, MaDT, MaBS, MaBN,ThanhTien, NgayKham, MotaBenh)\n"
            + "VALUES (?,?,?,?,?,?,?)";
    String Update_Sql = "UPDATE PhieuKham\n"
            + "SET MaDT = ?, MaBS = ?, MaBN = ?, ThanhTien = ? ,NgayKham = ?, MotaBenh = ?\n"
            + "where maphieukham = ?";
    String Delete_Sql = "delete from phieukham where maphieukham = ?";
    String Select_All_Sql = "select * from phieukham";
//    String select_all_BN_PK = "  select hoten, ngaysinh, gioitinh, sdt from benhnhan \n"
//            + "  inner join phieukham on benhnhan.mabn = phieukham.mabn\n"
//            + "  where phieukham.mabn = ? and ngaykham = '?";
    //String select_All_BenhNhan = "select * from benhnhan where mabn = ?";
    String Select_By_Id_Sql = "select * from phieukham where maphieukham = ?";

    @Override
    public void insert(PhieuKham entity) {
        Xjdbc.update(Insert_Sql,
                entity.getMaPK(),
                entity.getMaDT(),
                entity.getMaBS(),
                entity.getMaBN(),
                entity.getThanhTien(),
                entity.getNgaykham(),
                entity.getMotaBenh()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PhieuKham entity) {
        Xjdbc.update(Update_Sql,
                entity.getMaDT(),
                entity.getMaBS(),
                entity.getMaBN(),
                entity.getThanhTien(),
                entity.getNgaykham(),
                entity.getMotaBenh(),
                entity.getMaPK()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        Xjdbc.update(Delete_Sql, id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhieuKham selectById(String id) {
        List<PhieuKham> list = this.selectBySql(Select_By_Id_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhieuKham> selectALL() {
        return this.selectBySql(Select_All_Sql); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<PhieuKham> selectBySql(String sql, Object... args) {
        List<PhieuKham> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                PhieuKham entity = new PhieuKham();
                entity.setMaPK(rs.getString("MaphieuKham"));
                entity.setMaDT(rs.getString("MaDT"));
                entity.setMaBS(rs.getString("MaBS"));
                entity.setMaBN(rs.getString("MaBN"));
                entity.setThanhTien(rs.getDouble("Thanhtien"));
                entity.setNgaykham(rs.getString("NgayKham"));
                entity.setMotaBenh(rs.getString("MotaBenh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } //To change body of generated methods, choose Tools | Templates.
    }

    public List<Integer> selectYears() {
        String sql = "SELECT distinct year(ngaykham) as 'năm' FROM phieukham ORDER BY năm DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Object[]> getbenhnhan(String maphieukham) {
        String sql = "{CALL sp_benhnhan(?)}";
        String[] cols = {"hoten", "ngaysinh", "gioitinh", "sdt", "mabn", "maphieukham", "madt", "mabs",
            "motabenh", "ngaykham", "thanhtien"};
        return this.getListOfArray(sql, cols, maphieukham);
    }

    public List<Object[]> getBenhNhanById(String maBN) {
        String sql = "SELECT hoten, ngaysinh FROM BenhNhan WHERE mabn = ?";
        String[] cols = {"hoten", "ngaysinh"};
        return this.getListOfArray(sql, cols, maBN);
    }

    public List<Object[]> getdonthuoc(String madt) {
        String sql = "{CALL sp_LoadTableThuoc(?)}"; // Gọi stored procedure
        String[] cols = {"Mathuoc", "Tenthuoc", "DonVi", "HDS", "GiaTien", "SoLuong"}; // Thêm cột Giá tiền
        return this.getListOfArray(sql, cols, madt);

    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//   
}
