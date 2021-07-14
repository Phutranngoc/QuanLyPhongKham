/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author HA NAM
 */
public class PhieuKham {

    /**
     * @return the MaPK
     */
    public String getMaPK() {
        return MaPK;
    }

    /**
     * @param MaPK the MaPK to set
     */
    public void setMaPK(String MaPK) {
        this.MaPK = MaPK;
    }

    /**
     * @return the MaBN
     */
    public String getMaBN() {
        return MaBN;
    }

    /**
     * @param MaBN the MaBN to set
     */
    public void setMaBN(String MaBN) {
        this.MaBN = MaBN;
    }

    /**
     * @return the MaBS
     */
    public String getMaBS() {
        return MaBS;
    }

    /**
     * @param MaBS the MaBS to set
     */
    public void setMaBS(String MaBS) {
        this.MaBS = MaBS;
    }

    /**
     * @return the MotaBenh
     */
    public String getMotaBenh() {
        return MotaBenh;
    }

    /**
     * @param MotaBenh the MotaBenh to set
     */
    public void setMotaBenh(String MotaBenh) {
        this.MotaBenh = MotaBenh;
    }

    /**
     * @return the MaDT
     */
    public String getMaDT() {
        return MaDT;
    }

    /**
     * @param MaDT the MaDT to set
     */
    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    /**
     * @return the Ngaykham
     */
    public String getNgaykham() {
        return Ngaykham;
    }

    /**
     * @param Ngaykham the Ngaykham to set
     */
    public void setNgaykham(String Ngaykham) {
        this.Ngaykham = Ngaykham;
    }
    private String MaPK;
    private double thanhTien;

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    private String MaBN;
    private String MaBS;
    private String MotaBenh;
    private String MaDT;
    private String Ngaykham;
    private Date Ngaysinh;
    private String sdT;
    private String hoTen;
    private boolean gioiTinh;

    public String getSdT() {
        return sdT;
    }

    public void setSdT(String sdT) {
        this.sdT = sdT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

}
