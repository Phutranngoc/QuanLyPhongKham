/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import util.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HA NAM
 */
public class ThongKeDAO {

    /*getListofArray chỉ pv cho các phương thức còn lại, nó dựa vào PROC, mảng các
    cột để đọc dữ liệu trên mỗi bản ghi*/
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

    public List<Object[]> getbenhnhan(String maphieukham) {
        String sql = "{CALL sp_benhnhan(?)}";
        String[] cols = {"hoten", "ngaysinh", "gioitinh", "sdt", "mabn", "maphieukham", "madt", "mabs",
            "motabenh", "ngaykham", "thanhtien"};
        return this.getListOfArray(sql, cols, maphieukham);
    }

    public List<Object[]> getdonthuoc(String madt) {
        String sql = "{CALL sp_LoadTableThuoc(?)}";
        String[] cols = {"Mathuoc", "Tenthuoc", "HDS", "DonVi"};
        return this.getListOfArray(sql, cols, madt);
    }

    public List<Object[]> getDoanhthu(int nam) {
        String sql = "{CALL sp_DoanhThu (?)}";
        String[] cols = {"Tổng số phiếu khám", "Tổng số bệnh nhân", "Doanh thu",
             "Doanh thu thấp", "Doanh thu cao", "Doanh thu trung bình"};
        return this.getListOfArray(sql, cols, nam);
    }

  

}
