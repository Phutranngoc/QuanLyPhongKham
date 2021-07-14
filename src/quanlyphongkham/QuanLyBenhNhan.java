/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import DAO.BenhNhanDAO;
import Entity.Benhnhan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.MsgBox;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class QuanLyBenhNhan extends javax.swing.JDialog {

    /**
     * Creates new form Doctor
     */
    public QuanLyBenhNhan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        rdoYes = new javax.swing.JRadioButton();
        rdoNo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtMaBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtMaBN);
        txtMaBN.setBounds(140, 40, 414, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã BN");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(15, 41, 100, 22);

        txtTenBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtTenBN);
        txtTenBN.setBounds(138, 85, 414, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Giới Tính");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(15, 125, 71, 22);

        buttonGroupGioiTinh.add(rdoNam);
        rdoNam.setText("Nam");
        jPanel2.add(rdoNam);
        rdoNam.setBounds(138, 125, 55, 25);

        buttonGroupGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel2.add(rdoNu);
        rdoNu.setBounds(211, 125, 45, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Địa Chỉ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(15, 168, 57, 22);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtDiaChi);
        txtDiaChi.setBounds(113, 170, 780, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Bảo Hiểm");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 230, 90, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tuổi");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(619, 41, 35, 22);

        txtTuoi.setEditable(false);
        txtTuoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtTuoi);
        txtTuoi.setBounds(685, 43, 44, 26);

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtNgaySinh);
        txtNgaySinh.setBounds(747, 43, 121, 26);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SĐT");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(619, 83, 50, 22);

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtSDT);
        txtSDT.setBounds(688, 85, 180, 26);

        buttonGroupBaoHiem.add(rdoYes);
        rdoYes.setText("Có");
        jPanel2.add(rdoYes);
        rdoYes.setBounds(120, 230, 43, 25);

        buttonGroupBaoHiem.add(rdoNo);
        rdoNo.setText("Không");
        jPanel2.add(rdoNo);
        rdoNo.setBounds(200, 230, 63, 25);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 908, 280));

        tblBang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bệnh Nhân", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Bảo Hiểm", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblBang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 910, 340));

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 660, 110, 50));

        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 110, 50));

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, 110, 50));

        btnAdd.setText("Thêm Mới");
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 932, 738));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (checkform()) {
            MsgBox.confirm(this,"Vui lòng không thay đổi mã bệnh nhân khi cập nhật");
            this.update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (checkform()) {
            if (checkInsert()) {
                this.insert();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblBang.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblBangMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyBenhNhan dialog = new QuanLyBenhNhan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupBaoHiem;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNo;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoYes;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

    BenhNhanDAO dao = new BenhNhanDAO();
    int row = -1;

    void init() {
        this.setLocationRelativeTo(null);
        this.row = -1;
        //this.updateStatus();
        this.fillTable();
        rdoNam.setSelected(true);
        rdoYes.setSelected(true);
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);//xóa sạch dữ liệu bên trong form bảng
        try {
            List<Benhnhan> list = dao.selectALL();
            for (Benhnhan bn : list) {
                Object[] row = {
                    bn.getMaBN(),
                    bn.getTenBN(),
                    bn.getNgaySinh(),
                    bn.getGioiTinh(),
                    bn.getDiachi(),
                    bn.isBaoHiem() ? "Có" : "Không",
                    bn.getSDT()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy xuất dữ liệu");
        }
    }

    Benhnhan getForm() {
        Benhnhan bn = new Benhnhan();
        bn.setMaBN(txtMaBN.getText());
        bn.setTenBN(txtTenBN.getText());
        bn.setNgaySinh(txtNgaySinh.getText());
        if (rdoNam.isSelected()) {
            bn.setGioiTinh(rdoNam.getText());
        }
        if (rdoNu.isSelected()) {
            bn.setGioiTinh(rdoNu.getText());
        }
        bn.setDiachi(txtDiaChi.getText());
        bn.setBaoHiem(rdoYes.isSelected());
        bn.setSDT(txtSDT.getText());
        return bn;
    }

    void setForm(Benhnhan bn) {
        txtMaBN.setText(bn.getMaBN());
        txtTenBN.setText(bn.getTenBN());
        txtNgaySinh.setText(bn.getNgaySinh());
        if (bn.getGioiTinh().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else if (bn.getGioiTinh().equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(bn.getDiachi());
        rdoYes.setSelected(bn.isBaoHiem());
        rdoNo.setSelected(!bn.isBaoHiem());
        txtSDT.setText(String.valueOf(bn.getSDT()));
        txtTuoi.setText(String.valueOf(tuoi()));
    }

    void clearForm() {//btnMoi
        txtMaBN.setText("");
        txtTenBN.setText("");
        txtTuoi.setText("");
        rdoNam.setSelected(true);
        txtDiaChi.setText("");
        rdoYes.setSelected(true);
        txtSDT.setText("");
        txtNgaySinh.setText("");
        this.row = -1;
        // this.updateStatus();
    }

    void edit() {//tblBenhNhan
        String mabn = (String) tblBang.getValueAt(this.row, 0);
        Benhnhan nv = dao.selectById(mabn);
        this.row = -1;
        this.setForm(nv);
        // this.updateStatus();
    }
    
    void insert() {
        Benhnhan bn = getForm();
        try {
            dao.insert(bn);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "thêm bệnh nhân thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "thêm bệnh nhân thất bại!!!");
            System.out.print(e);
        }
    }

    void update() {
        Benhnhan bn = getForm();
        try {
            dao.update(bn);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "cập nhật bệnh nhân thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "cập nhật bệnh nhân thất bại!!!");
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            String mabn = txtMaBN.getText();
            //không đc xóa chính nhân viên hiện tại
//            if (mabn.equals(Auth.user.get())) {
//                MsgBox.alert(this, "bạn không thể xóa chính bạn!");
            MsgBox.confirm(this, "Bạn có thật sự muốn xóa bệnh nhân này?");
            try {
                dao.delete(mabn);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "xóa bệnh nhân thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "xóa bệnh nhân thất bại");
                MsgBox.alert(this, "Hãy xóa phiếu khám của bệnh nhân này trước!");
            }
        }
    }

    boolean checkform() {
        String sdt = "0[0-9]{9,10}";
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (txtMaBN.getText().length() == 0) {
            MsgBox.alert(this, "Không để trống mã bệnh nhân");
            return false;
        } else if (txtTenBN.getText().length() == 0) {
            MsgBox.alert(this, "Không để trống họ tên");
            return false;
        } else if (txtNgaySinh.getText().length() == 0) {
            MsgBox.alert(this, "Không để trống ngày sinh");
            return false;
        } else if (!txtNgaySinh.getText().matches(regex)) {
            MsgBox.alert(this, "Không đúng định dạng ngày sinh!!! vd 2001-02-26");
            return false;
        } else if (txtDiaChi.getText().length() == 0) {
            MsgBox.alert(this, "Không để trống địa chỉ");
            return false;
        } else if (txtSDT.getText().length() == 0) {
            MsgBox.alert(this, "Không để trống SDT");
            return false;
        }else if (!txtSDT.getText().matches(sdt)) {
            MsgBox.alert(this, "Không đúng định dạng số điện thoại!!!");
            return false;
        }

        return true;
    }

    int tuoi() {
        int namNgaySinh = 0;
        Benhnhan list = dao.selectById(txtMaBN.getText());
        String ngaysinh = list.getNgaySinh();
        String[] parts = ngaysinh.split("-");
        String part1 = parts[0];
        namNgaySinh = Integer.parseInt(String.valueOf(part1));
        int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
        int tuoi = namHienTai - namNgaySinh;
        return tuoi;
    }

    public List<String> selectID() {
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

    boolean checkInsert() {
        List<String> list = selectID();
        for (String ma : list) {
            if (txtMaBN.getText().equalsIgnoreCase(ma)) {
                MsgBox.alert(this, "Mã bệnh nhân đã tồn tại!");
                return false;
            }
        }
        return true;
    }

}
