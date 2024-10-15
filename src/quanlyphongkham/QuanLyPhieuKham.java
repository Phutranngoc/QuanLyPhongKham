/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import DAO.BenhNhanDAO;
import DAO.PhieuKhamDAO;
import Entity.PhieuKham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.MsgBox;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class QuanLyPhieuKham extends javax.swing.JDialog {

    /**
     * Creates new form Doctor
     */
    public QuanLyPhieuKham(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        buttonGroupBaoHiem = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtMaPhieuKham = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayKham = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaDonThuoc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaBS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTaBenh = new javax.swing.JTextArea();
        cboDT = new javax.swing.JComboBox<>();
        cboBS = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenBN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        cboBenhNhan = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Thông tin Phiếu Khám");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(3, 3, 180, 22);
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(3, 32, 890, 2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Mã Bác Sĩ");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(15, 83, 77, 22);

        txtMaPhieuKham.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtMaPhieuKham);
        txtMaPhieuKham.setBounds(140, 40, 310, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Mã Phiếu");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(15, 41, 100, 22);

        txtNgayKham.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayKham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgayKhamFocusLost(evt);
            }
        });
        txtNgayKham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayKhamMouseClicked(evt);
            }
        });
        jPanel3.add(txtNgayKham);
        txtNgayKham.setBounds(140, 130, 310, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Mã Đơn Thuốc");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(520, 40, 130, 22);

        txtMaDonThuoc.setEditable(false);
        txtMaDonThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtMaDonThuoc);
        txtMaDonThuoc.setBounds(650, 40, 90, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Mô Tả Bệnh");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(520, 80, 120, 22);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Ngày Khám");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(10, 130, 110, 22);

        txtMaBS.setEditable(false);
        txtMaBS.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtMaBS);
        txtMaBS.setBounds(140, 80, 150, 30);

        txtMoTaBenh.setColumns(20);
        txtMoTaBenh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMoTaBenh.setRows(5);
        jScrollPane1.setViewportView(txtMoTaBenh);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(650, 80, 240, 106);

        cboDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDTActionPerformed(evt);
            }
        });
        jPanel3.add(cboDT);
        cboDT.setBounds(760, 40, 130, 30);

        cboBS.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboBS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBSActionPerformed(evt);
            }
        });
        jPanel3.add(cboBS);
        cboBS.setBounds(320, 80, 130, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 908, 200));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Thông Tin Bệnh Nhân");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(3, 3, 180, 22);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(3, 32, 890, 2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Họ Và Tên BN");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(15, 83, 113, 22);

        txtMaBN.setEditable(false);
        txtMaBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtMaBN);
        txtMaBN.setBounds(140, 40, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã BN");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(15, 41, 100, 22);

        txtTenBN.setEditable(false);
        txtTenBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtTenBN);
        txtTenBN.setBounds(138, 85, 414, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Giới Tính");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 140, 71, 22);

        buttonGroupGioiTinh.add(rdoNam);
        rdoNam.setText("Nam");
        jPanel2.add(rdoNam);
        rdoNam.setBounds(130, 140, 55, 25);

        buttonGroupGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel2.add(rdoNu);
        rdoNu.setBounds(220, 140, 45, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tuổi");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(620, 50, 35, 22);

        txtTuoi.setEditable(false);
        txtTuoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtTuoi);
        txtTuoi.setBounds(685, 43, 44, 30);

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });
        jPanel2.add(txtNgaySinh);
        txtNgaySinh.setBounds(747, 43, 121, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SĐT");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(620, 90, 50, 22);

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtSDT);
        txtSDT.setBounds(688, 85, 180, 30);

        cboBenhNhan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboBenhNhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBenhNhanActionPerformed(evt);
            }
        });
        jPanel2.add(cboBenhNhan);
        cboBenhNhan.setBounds(280, 40, 100, 30);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 908, 190));

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 660, 110, 50));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 110, 50));

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, 110, 50));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 660, 110, 50));

        btnNew.setText("Nhập Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 100, 50));

        tblBang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Khám", "Mã DT", "Mã BS", "Mã BN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.setRowHeight(30);
        tblBang.setRowMargin(4);
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBang);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 910, 170));

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 51, 51));
        txtTongTien.setText("0");
        getContentPane().add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 120, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tổng Tiền");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 90, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VNĐ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 50, 40));

        lblBackGround.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        getContentPane().add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 932, 738));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (checkform()) {
            if (checkInsert()) {
                this.insert();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        try {
            BenhNhan_PhieuKham();
            txtTuoi.setText(String.valueOf(tuoi(txtNgaySinh.getText())));
            //edit();
            //test();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi");
            System.out.println(e);
        }

    }//GEN-LAST:event_tblBangMouseClicked

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtNgayKhamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayKhamFocusLost
//        if (txtNgaySinh.getText().trim().toLowerCase().equals("")) {
//            txtNgaySinh.setText("yyyy-MM-dd");
//        }
    }//GEN-LAST:event_txtNgayKhamFocusLost

    private void txtNgayKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayKhamMouseClicked
        txtNgayKham.setText("");
    }//GEN-LAST:event_txtNgayKhamMouseClicked

    private void cboBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBenhNhanActionPerformed
        // TODO add your handling code here:
        txtMaBN.setText(String.valueOf(cboBenhNhan.getSelectedItem()));
    }//GEN-LAST:event_cboBenhNhanActionPerformed

    private void cboDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDTActionPerformed
        // TODO add your handling code here:
        txtMaDonThuoc.setText(String.valueOf(cboDT.getSelectedItem()));
    }//GEN-LAST:event_cboDTActionPerformed

    private void cboBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBSActionPerformed
        // TODO add your handling code here:
        txtMaBS.setText(String.valueOf(cboBS.getSelectedItem()));
    }//GEN-LAST:event_cboBSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhieuKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyPhieuKham dialog = new QuanLyPhieuKham(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroupBaoHiem;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JComboBox<String> cboBS;
    private javax.swing.JComboBox<String> cboBenhNhan;
    private javax.swing.JComboBox<String> cboDT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtMaBS;
    private javax.swing.JTextField txtMaDonThuoc;
    private javax.swing.JTextField txtMaPhieuKham;
    private javax.swing.JTextArea txtMoTaBenh;
    private javax.swing.JTextField txtNgayKham;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

    BenhNhanDAO bndao = new BenhNhanDAO();
    PhieuKhamDAO pkdao = new PhieuKhamDAO();
    int row = -1;

    void init() {
        this.setLocationRelativeTo(null);
        // this.row = -1;
        //this.fillComboBoxBenhNhan();
        fillTable();
        fillComboBoxBN();
        fillComboBoxDT();
        fillComboBoxBS();
        rdoNam.setSelected(true);
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        try {
            List<PhieuKham> list = pkdao.selectALL();
            for (PhieuKham pk : list) {
                Object[] row = {
                    pk.getMaPK(),
                    pk.getMaDT(),
                    pk.getMaBS(),
                    pk.getMaBN(),
                    pk.getThanhTien(),
                    pk.getNgaykham(),
                    pk.getMotaBenh()
                };
                model.addRow(row);
            }
            tblBang.setModel(model);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy xuất dữ liệu");
            System.out.println(e);
        }
    }

    PhieuKham getForm() {
        PhieuKham pk = new PhieuKham();
        pk.setMaPK(txtMaPhieuKham.getText());
        pk.setMaBS(txtMaBS.getText());
        pk.setMaDT(txtMaDonThuoc.getText());
        pk.setMotaBenh(txtMoTaBenh.getText());
        pk.setNgaykham(txtNgayKham.getText());
        pk.setMaBN(txtMaBN.getText());
        pk.setThanhTien(Double.parseDouble(txtTongTien.getText()));
        //
        //     
        return pk;
    }

    void setForm(PhieuKham pk) {
//        txtMaPhieuKham.setText(pk.getMaPK());
//        txtMaBS.setText(pk.getMaBS());
//        txtMaDonThuoc.setText(pk.getMaDT());
//        txtMoTaBenh.setText(pk.getMotaBenh());
//        txtNgayKham.setText(XDate.toString(pk.getNgaykham(), "yyyy-MM-dd"));
//        txtTongTien.setText(String.valueOf(pk.getThanhTien()));
//        txtMaBN.setText(pk.getMaBN());
//        //      
//        txtNgaySinh.setText(XDate.toString(pk.getNgaysinh(), "yyyy-MM-dd"));
//        txtSDT.setText(pk.getSdT());
//        txtTuoi.setText(XDate.toString(pk.getNgaysinh(), "yyyy-MM-dd"));
//        rdoNam.setSelected(pk.isGioiTinh());
//        rdoNu.setSelected(!pk.isGioiTinh());
//
//        //
    }

    void edit() {//tblBenhNhan
        String mapk = (String) tblBang.getValueAt(this.row, 0);
        PhieuKham pk = pkdao.selectById(mapk);
        //PhieuKham pk = (PhieuKham) pkdao.selectALL1(mapk);
        this.setForm(pk);
    }

    void clearForm() {//btnMoi
        txtMaPhieuKham.setText("");
        txtMaDonThuoc.setText("");
        txtMaBS.setText("");
        txtMaBN.setText("");
        txtMoTaBenh.setText("");
        txtNgayKham.setText("yyyy-MM-dd");
        txtTongTien.setText("0");
        txtTuoi.setText("");
        txtTenBN.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        rdoNam.setSelected(true);
        this.row = -1;
        // this.updateStatus();
    }

    void insert() {
        PhieuKham pk = getForm();
        try {
            pkdao.insert(pk);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "thêm phiếu khám thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "thêm phiếu khám thất bại!!!");
            System.out.print(e);
        }
    }

    void update() {
        PhieuKham pk = getForm();
        try {
            pkdao.update(pk);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "cập nhật phiếu khám thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "cập nhật phiếu khám thất bại!!!");
            System.out.println(e);
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            String mapk = txtMaPhieuKham.getText();
            //không đc xóa chính nhân viên hiện tại
//            if (mabn.equals(Auth.user.get())) {
//                MsgBox.alert(this, "bạn không thể xóa chính bạn!");
            MsgBox.confirm(this, "Bạn có thật sự muốn xóa phiếu khám này?");
            try {
                pkdao.delete(mapk);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "xóa phiếu khám thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "xóa phiếu khám thất bại");
            }
        }
    }

    void BenhNhan_PhieuKham() {
        try {
            String maphieukham = (String) tblBang.getValueAt(tblBang.getSelectedRow(), 0);
            List<Object[]> list = pkdao.getbenhnhan(maphieukham);
            for (Object[] cd : list) {

                txtTenBN.setText((String) cd[0]);
                txtNgaySinh.setText(String.valueOf(cd[1]));
                if (cd[2].equals("Nam")) {
                    rdoNam.setSelected(true);
                } else {
                    rdoNu.setSelected(true);
                }
                txtSDT.setText((String.valueOf(cd[3])));
                txtMaBN.setText((String.valueOf(cd[4])));
                txtMaPhieuKham.setText((String.valueOf(cd[5])));
                txtMaDonThuoc.setText((String.valueOf(cd[6])));
                txtMaBS.setText((String.valueOf(cd[7])));
                txtMoTaBenh.setText((String.valueOf(cd[8])));
                txtNgayKham.setText((String.valueOf(cd[9])));
                txtTongTien.setText((String.valueOf(cd[10])));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean checkform() {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (txtMaPhieuKham.getText().length() == 0) {
            MsgBox.alert(this, "không để trống mã phiếu khám");
            return false;
        } else if (txtMaBN.getText().length() == 0) {
            MsgBox.alert(this, "không để trống mã bệnh nhân");
            return false;
        } else if (txtMaBS.getText().length() == 0) {
            MsgBox.alert(this, "không để trống mã bác sĩ");
            return false;
        } else if (txtMaDonThuoc.getText().length() == 0) {
            MsgBox.alert(this, "không để trống mã đơn thuốc");
            return false;
        } else if (!txtNgayKham.getText().matches(regex)) {
            MsgBox.alert(this, "không đúng định dạng ngày khám!!! vd 2001-02-26");
            return false;
        } else if (txtMoTaBenh.getText().length() == 0) {
            MsgBox.alert(this, "không để trống mô tả bệnh");
            return false;
        }

        return true;
    }

    int tuoi(String ngaysinh) {
        int namNgaySinh = 0;
        // Benhnhan list = bndao.selectById(txtMaBN.getText());
        //PhieuKham list = pkdao.selectById(txtNgaySinh.getText());
        //String ngaysinh = XDate.toString(list.getNgaysinh(), "yyyy-MM-dd");
        String[] parts = ngaysinh.split("-");
        String part1 = parts[0];
        namNgaySinh = Integer.parseInt(String.valueOf(part1));
        int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
        int tuoi = namHienTai - namNgaySinh;
        return tuoi;
    }

    public List<String> selectID() {
        String sql = "select MaPhieuKham from PhieuKham";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaPhieuKham"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> selectDT() {
        String sql = "select MaDT from DonThuoc";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaDT"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> selectBN() {
        String sql = "select MaBN from BenhNhan";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaBN"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> selectBS() {
        String sql = "select MaBS from BacSi";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaBS"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean checkInsert() {
        List<String> list = selectID();
        for (String ma : list) {
            if (txtMaPhieuKham.getText().equalsIgnoreCase(ma)) {
                MsgBox.alert(this, "Mã phiếu khám bạn nhập đã tồn tại!");
                return false;
            }
        }
        return true;
    }

    void fillComboBoxDT() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboDT.getModel();
        model.removeAllElements();
        List<String> list = selectDT();
        for (String ma : list) {
            model.addElement(ma);
        }
    }

    void fillComboBoxBN() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboBenhNhan.getModel();
        model.removeAllElements();
        List<String> list = selectBN();
        for (String ma : list) {
            model.addElement(ma);
        }
    }

    void fillComboBoxBS() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboBS.getModel();
        model.removeAllElements();
        List<String> list = selectBS();
        for (String ma : list) {
            model.addElement(ma);
        }
    }

}
