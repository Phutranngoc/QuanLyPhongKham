/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import Entity.DonThuoc;
import java.awt.Color;
import util.Xjdbc;
import DAO.DonThuocDAO;
import DAO.PhieuKhamDAO;
import Entity.DonThuoc.DonThuocModalCallback;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import util.MsgBox;

/**
 *
 * @author ADMIN
 */
public class DonThuocModal extends javax.swing.JDialog {

    private Boolean isUpdate; //Check xem đang cập nhật hay tạo mới
    private DonThuocModalCallback callback; // Trường callback

    /**
     * Creates new form Doctor
     */
    public DonThuocModal(java.awt.Frame parent, boolean isVisible, Boolean isUpdate, DonThuocModalCallback callback) {
        super(parent, isVisible);
        initComponents();
        this.setLocationRelativeTo(null);
        this.isUpdate = isUpdate; // Lưu trạng thái
        this.callback = callback; // Gán callback
        this.fillComboBoxThuoc();
        this.fillComboBoxBS();

    }

    ;
    
      public void setDonThuoc(DonThuoc dt) {
        this.setFrom(dt); // Thực hiện thiết lập dữ liệu ở đây
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtMaDonThuoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBacSi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLieuDung = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoThuoc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboThuoc = new javax.swing.JComboBox<>();
        btnThemThuoc = new javax.swing.JButton();
        cboBS = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuoc = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(738, 932));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setText("Đóng");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 650, 110, 40));

        btnAdd.setText("Xác nhận");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 110, 40));

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đơn Thuốc");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(13, 2, 130, 30);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(3, 32, 890, 3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã Bác Sĩ Kê");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 120, 120, 30);

        txtMaDonThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtMaDonThuoc);
        txtMaDonThuoc.setBounds(160, 60, 414, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã Đơn Thuốc");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 60, 130, 22);

        txtBacSi.setEditable(false);
        txtBacSi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtBacSi);
        txtBacSi.setBounds(160, 120, 130, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Liều dùng");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 180, 110, 22);

        txtLieuDung.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtLieuDung);
        txtLieuDung.setBounds(160, 170, 410, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Số Thuốc");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 240, 130, 30);

        txtSoThuoc.setEditable(false);
        txtSoThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel3.add(txtSoThuoc);
        txtSoThuoc.setBounds(160, 240, 50, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/bill medical 1.png"))); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(650, 50, 210, 200);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thuốc");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(240, 240, 70, 30);

        cboThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cboThuoc);
        cboThuoc.setBounds(310, 240, 160, 30);

        btnThemThuoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnThemThuoc.setText("Thêm");
        btnThemThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemThuocMouseClicked(evt);
            }
        });
        btnThemThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemThuoc);
        btnThemThuoc.setBounds(490, 240, 80, 30);

        cboBS.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboBS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBSActionPerformed(evt);
            }
        });
        jPanel3.add(cboBS);
        cboBS.setBounds(310, 120, 160, 30);

        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel3.add(btnNew);
        btnNew.setBounds(780, 2, 100, 30);

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 910, 310));

        tblThuoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Đơn Vị", "Hạn Sử Dụng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuoc.setRowHeight(30);
        tblThuoc.setRowMargin(4);
        jScrollPane1.setViewportView(tblThuoc);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 910, 280));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        jLabel7.setMaximumSize(new java.awt.Dimension(700, 500));
        jLabel7.setMinimumSize(new java.awt.Dimension(700, 500));
        jLabel7.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 738));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.Clearform();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (checkform()) {
            if (this.isUpdate) {
                this.update();
            } else {
                this.insert();
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnThemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemThuocActionPerformed

    private void btnThemThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemThuocMouseClicked
        // TODO add your handling code here:
        fillTHuoc();
    }//GEN-LAST:event_btnThemThuocMouseClicked

    private void cboBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBSActionPerformed
        txtBacSi.setText(String.valueOf(cboBS.getSelectedItem()));
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
            java.util.logging.Logger.getLogger(DonThuocModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonThuocModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonThuocModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonThuocModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DonThuocModal dialog = new DonThuocModal(new javax.swing.JFrame(), true, false, new DonThuocModalCallback() {
                    @Override
                    public void onDonThuocAdded() {

                    }
                });
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
    private javax.swing.JButton btnThemThuoc;
    private javax.swing.JComboBox<String> cboBS;
    private javax.swing.JComboBox<String> cboThuoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblThuoc;
    private javax.swing.JTextField txtBacSi;
    private javax.swing.JTextField txtLieuDung;
    private javax.swing.JTextField txtMaDonThuoc;
    private javax.swing.JTextField txtSoThuoc;
    // End of variables declaration//GEN-END:variables
 DonThuocDAO dao = new DonThuocDAO();
    PhieuKhamDAO pkdao = new PhieuKhamDAO();
    int row = -1;

    String INSERT_DonThuoc = "insert into DonThuoc(MaDT,MaBS,Lieudung) values(?,?,?)";
    String INSERT_ChiTietDonThuoc = "insert into Chitiet_DonThuoc_Thuoc(MaThuoc,MaDT) values(?,?)";
    String UPDATE_SQL = "update DonThuoc set MaBS=?,Lieudung=? where MaDT=?";
    String UPDATE_CT = "update Chitiet_DonThuoc_Thuoc set MaThuoc=? where MaDT=? and MaThuoc=?";
    String DELETE_DT = "delete from DonThuoc where MaDT=?";
    String DELETE_DTCT = "delete from Chitiet_DonThuoc_Thuoc  where MaDT=?";
    String SELECT_ALL_SQL = "select * from DonThuoc";

    public void insert() {
        try {
            Xjdbc.update(INSERT_DonThuoc, txtMaDonThuoc.getText(), txtBacSi.getText(), txtLieuDung.getText());

            int dem = tblThuoc.getRowCount();
            System.out.println(dem);
            int i;
            for (i = 0; i <= dem; i++) {
                Xjdbc.update(INSERT_ChiTietDonThuoc, tblThuoc.getValueAt(i, 0), txtMaDonThuoc.getText());
            }
            MsgBox.alert(this, "Thêm Thành Công");
            if (callback != null) {
                callback.onDonThuocAdded();// Gọi callback sau khi cập nhật thành công
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void update() {
        try {
            Xjdbc.update(UPDATE_SQL, txtBacSi.getText(), txtLieuDung.getText(), txtMaDonThuoc.getText());
            Xjdbc.update(DELETE_DTCT, txtMaDonThuoc.getText());
            int dem = tblThuoc.getRowCount();
            for (int i = 0; i <= dem; i++) {
                Xjdbc.update(INSERT_ChiTietDonThuoc, tblThuoc.getValueAt(i, 0), txtMaDonThuoc.getText());
            }
            //MsgBox.confirm(this, "Lưu ý! Không được thay đổi số thuốc của đơn thuốc,mọi chi tiết thay đổi trong danh sách thuốc sẽ không được thực thi.");
            MsgBox.alert(this, "Sửa thành công");
            if (callback != null) {
                callback.onDonThuocAdded();// Gọi callback sau khi cập nhật thành công
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void delete() {
        try {
            Xjdbc.update(DELETE_DTCT, txtMaDonThuoc.getText());
            Xjdbc.update(DELETE_DT, txtMaDonThuoc.getText());

            MsgBox.alert(this, "Xóa thành công!");
            Clearform();

        } catch (Exception e) {
            MsgBox.alert(this, "Xóa Thất Bại,Vui Lòng Xóa Phiếu Khám Sử Dụng Đơn Thuốc Này Trước!");
        }

    }

    public void Clearform() {
        txtBacSi.setText("");
        txtLieuDung.setText("");
        txtMaDonThuoc.setText("");
        txtSoThuoc.setText("");
    }

    void setFrom(DonThuoc dt) {
        txtBacSi.setText(dt.getMaBS());
        txtLieuDung.setText(dt.getLieudung());
        txtMaDonThuoc.setText(dt.getMaDT());
//        loadData(dt.getMaDT());
        LoadDataThuoc(dt);
        int lieudung = tblThuoc.getRowCount();
        txtSoThuoc.setText(String.valueOf(lieudung));

    }

    void LoadDataThuoc(DonThuoc dt) {
        DefaultTableModel model = (DefaultTableModel) tblThuoc.getModel();
        model.setRowCount(0);
        List<Object[]> list = pkdao.getdonthuoc(dt.getMaDT());
        for (Object[] row : list) {
            model.addRow(row);
        }
        tblThuoc.setModel(model);
    }

    public List<String> selectThuoc() {
        String sql = "select MaThuoc+ '-' +TenThuoc as Thuoc from Thuoc";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getString("Thuoc"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void fillComboBoxThuoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboThuoc.getModel();
        model.removeAllElements();
        List<String> list = selectThuoc();
        for (String ma : list) {
            model.addElement(ma);
        }
    }

    void fillTHuoc() {
        DefaultTableModel model = (DefaultTableModel) tblThuoc.getModel();
        String index = (String) cboThuoc.getSelectedItem();
        String List[] = index.split("-");
        model.addRow(new Object[]{List[0], List[1], "", ""});
    }

    boolean checkform() {
        if (txtBacSi.getText().equals("")) {
            MsgBox.alert(this, "KHông được để trống mã bác sĩ kê thuốc!");
            return false;
        } else if (txtLieuDung.getText().equals("")) {
            MsgBox.alert(this, "KHông được để trống liều dùng!");
            return false;
        } else if (txtMaDonThuoc.getText().equals("")) {
            MsgBox.alert(this, "KHông được để trống mã đơn thuốc!");
            return false;
        } else if (tblThuoc.getRowCount() == 0) {
            MsgBox.alert(this, "Vui lòng chọn thuốc!");
            return false;
        }
        return true;
    }

    public List<String> selectID() {
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

    public List<String> selectIDBS() {
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
            if (txtMaDonThuoc.getText().equalsIgnoreCase(ma)) {
                MsgBox.alert(this, "Mã đơn thuốc đã tồn tại!");
                return false;
            }
        }
        return true;
    }

    void fillComboBoxBS() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboBS.getModel();
        model.removeAllElements();
        List<String> list = selectIDBS();
        for (String ma : list) {
            model.addElement(ma);
        }
    }
}
