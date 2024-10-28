/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import DAO.ThuocDAO;
import Entity.Thuoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.MsgBox;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class QuanLyThuoc extends javax.swing.JDialog {

    /**
     * Creates new form Doctor
     */
    public QuanLyThuoc(java.awt.Frame parent, boolean modal) {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttenThuoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
        txtHSD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaThuoc = new javax.swing.JTextField();
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
        setSize(new java.awt.Dimension(738, 932));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Thông Tin Thuốc");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(3, 3, 151, 22);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(3, 32, 890, 2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên Thuốc");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 100, 85, 22);

        txtMaThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtMaThuoc);
        txtMaThuoc.setBounds(140, 40, 414, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã Thuốc");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 40, 78, 22);

        txttenThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txttenThuoc);
        txttenThuoc.setBounds(140, 100, 414, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Đơn vị thuốc");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 160, 110, 22);

        txtDonVi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtDonVi);
        txtDonVi.setBounds(140, 160, 410, 30);

        txtHSD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtHSD);
        txtHSD.setBounds(140, 210, 410, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Hạn Sử dụng");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 206, 110, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/medical1.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(630, 50, 250, 200);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Giá Thuốc");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 260, 100, 30);

        txtGiaThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(txtGiaThuoc);
        txtGiaThuoc.setBounds(140, 260, 410, 30);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 908, 310));

        tblBang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Đơn Vị", "Hạn Sử Dụng", "Giá Thuốc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 910, 310));

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 932, 738));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (checkform()) {
            if (checkInsert()) {
                try {
                    this.insert();
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLyThuoc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (checkform()) {
            MsgBox.confirm(this, "Vui lòng không thay đổi mã thuốc khi cập nhật");
            try {
                this.update();
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyThuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnDelActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyThuoc dialog = new QuanLyThuoc(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtGiaThuoc;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txttenThuoc;
    // End of variables declaration//GEN-END:variables
    ThuocDAO dao = new ThuocDAO();
    int row = -1;

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        try {
            List<Thuoc> list = dao.selectALL();
            for (Thuoc th : list) {
                Object[] row = {
                    th.getMaThuoc(),
                    th.getTenthuoc(),
                    th.getDVT(),
                    th.getHSD(),
                    th.getGiaTien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    Thuoc getform() throws ParseException {
        Thuoc th = new Thuoc();
        String formattedDate = "";
        try {
            String inputDate = txtHSD.getText();
            // Define the date format you expect to receive (dd/MM/yyyy)
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(inputDate);  // Parse the input date

            // Define the date format the database expects (yyyy-MM-dd)
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = outputFormat.format(date);  // Format the date
        } catch (Exception e) {
            formattedDate = "";
        }
        th.setMaThuoc(txtMaThuoc.getText());
        th.setTenthuoc(txttenThuoc.getText());
        th.setDVT(txtDonVi.getText());
        th.setHSD(formattedDate);
        th.setGiaTien(txtGiaThuoc.getText());
        return th;
    }

    void setForm(Thuoc th) {
        String dateFormatHanSuDung = th.getHSD();
        if (dateFormatHanSuDung != null) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = inputFormat.parse(dateFormatHanSuDung);
                String formattedDate = outputFormat.format(date);
                txtHSD.setText(formattedDate);
            } catch (ParseException e) {
                txtHSD.setText(""); // Handle parsing error
            }
        } else {
            txtHSD.setText(""); // Handle null case
        }
        txtMaThuoc.setText(th.getMaThuoc());
        txttenThuoc.setText(th.getTenthuoc());
        txtDonVi.setText(th.getDVT());
        //txtHSD.setText(th.getHSD());
        txtGiaThuoc.setText(th.getGiaTien());
    }

    void edit() {
        String math = (String) tblBang.getValueAt(this.row, 0);
        Thuoc medic = dao.selectById(math);
        this.setForm(medic);
    }

    void insert() throws ParseException {
        Thuoc medic = this.getform();
        try {
            dao.insert(medic);
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");

        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            MsgBox.alert(this, "Mã bác sĩ có thể bị trùng,hãy kiểm tra lại!");
        }
    }

    void update() throws ParseException {
        Thuoc medic = this.getform();
        try {
            dao.update(medic); // cập nhật
            this.fillTable(); // đổ lại bảng
            MsgBox.alert(this, "Cập nhật thành công!");

        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa!");

        } else {
            String math = txtMaThuoc.getText();
            try {
                dao.delete(math);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");

            } catch (Exception e) {
                System.out.println(e);
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }

    }

    private void clearForm() {
        txtDonVi.setText("");
        txtHSD.setText("");
        txtMaThuoc.setText("");
        txttenThuoc.setText("");
        txtGiaThuoc.setText("");
    }

    boolean checkform() {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        if (txtMaThuoc.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập mã thuốc");
            return false;
        } else if (txttenThuoc.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập tên thuốc");
            return false;
        } else if (txtDonVi.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập đơn vị thuốc");
            return false;
        } else if (txtHSD.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập Hạn sử dụng");
            return false;
        } else if (!txtHSD.getText().matches(regex)) {
            MsgBox.alert(this, "Bạn nhập sai định dạng ngày,hãy kiểm tra lại(yyy-mm-dd)!");
            return false;
        } else if (txtGiaThuoc.getText().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập giá thuốc này!");
            return false;
        } else if (Double.parseDouble(txtGiaThuoc.getText()) < 0) {
            MsgBox.alert(this, "Giá Thuốc không hợp lệ!");
            return false;
        }
        return true;
    }

    private void init() {
        setLocationRelativeTo(null); // đưa cửa sổ ra giữa màn hình
        this.fillTable(); // đổ dữ liệu nhân viên vào bảng
    }

    public List<String> selectID() {
        String sql = "select MaThuoc from Thuoc";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("MaThuoc"));
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
            if (txtMaThuoc.getText().equalsIgnoreCase(ma)) {
                MsgBox.alert(this, "Mã thuốc đã tồn tại!");
                return false;
            }
        }
        return true;
    }
}
