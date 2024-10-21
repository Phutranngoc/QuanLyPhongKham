/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import Entity.BacSi;
import DAO.BacSiDAO;
import Entity.BacSi.BacSiModalCallback;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.MsgBox;
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class BacSiPage extends javax.swing.JFrame {

    /**
     * Creates new form Doctor
     */
    public BacSiPage() {

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(738, 932));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bác Sĩ", "Họ Và Tên", "Chuyên Ngành", "Ngày sinh", "Ghi chú", "Địa Chỉ", "SĐT", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 970, 440));

        btnAdd.setText("Thêm Mới");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 110, 30));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setText("Quản lý bác sĩ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách bác sĩ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jTextField1.setToolTipText("Tìm kiếm theo mã, tên bác sĩ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, 30));

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 100, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblBang.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblBangMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.create();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Lấy giá trị tìm kiếm từ jTextField1
        String keyword = jTextField1.getText().trim();

        // Kiểm tra nếu keyword không rỗng
        if (!keyword.isEmpty()) {
            // Gọi phương thức tìm kiếm từ dao
            List<BacSi> results = dao.searchByCodeOrName(keyword);

            // Cập nhật bảng với dữ liệu mới
            fillTable(results);
        } else {
            // Nếu không có gì để tìm kiếm, có thể load lại toàn bộ danh sách bác sĩ
            loadAllBacSi(); // Phương thức này cần được tạo để load lại tất cả bác sĩ
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BacSiPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BacSiPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BacSiPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BacSiPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBang;
    // End of variables declaration//GEN-END:variables
 BacSiDAO dao = new BacSiDAO();
    int row = -1;

    private void fillTable(List<BacSi> list) {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0); // Xóa toàn bộ hàng trong bảng

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày trong cơ sở dữ liệu
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng đầu ra mong muốn

            for (BacSi bs : list) {
                // Phân tích chuỗi ngày từ cơ sở dữ liệu
                String dateString = bs.getNgaysinh(); // e.g., "YYYY-MM-DD"
                String formattedDate = dateString; // Mặc định là giá trị gốc

                try {
                    Date date = inputFormat.parse(dateString); // Phân tích chuỗi ngày gốc
                    formattedDate = outputFormat.format(date); // Định dạng thành DD/MM/YYYY
                } catch (ParseException e) {
                    System.out.println("Lỗi phân tích ngày: " + e.getMessage());
                    // Tùy chọn, xử lý lỗi hoặc đặt formattedDate thành thông điệp lỗi
                }

                Object[] row = {
                    bs.getMaBS(),
                    bs.getTenBS(),
                    bs.getChuyennganh(),
                    formattedDate, // Sử dụng ngày đã định dạng ở đây
                    bs.getGhiChu(),
                    bs.getDiachi(),
                    bs.getSDT(),
                    bs.getGioitinh(),};
                model.addRow(row); // Thêm hàng vào bảng
            }
        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void loadAllBacSi() {
        List<BacSi> list = dao.selectALL(); // Giả sử bạn có phương thức này trong DAO
        fillTable(list); // Cập nhật bảng với toàn bộ danh sách bác sĩ
    }

    void create() {
        // Tạo một modal BacSiForm và hiển thị nó
        BacSiModal modal = new BacSiModal(this, true, false, new BacSiModalCallback() {
            @Override
            public void onBacSiAdded() {
                init(); // Gọi phương thức init() để cập nhật danh sách bác sĩ
            }
        });
        modal.setVisible(true);

    }

    void edit() {
        String mabs = (String) tblBang.getValueAt(this.row, 0);
        BacSi bs = dao.selectById(mabs);

        // Tạo một modal BacSiForm và hiển thị nó
        BacSiModal modal = new BacSiModal(this, true, true, new BacSiModalCallback() {
            @Override
            public void onBacSiAdded() {
                init(); // Gọi phương thức init() để cập nhật danh sách bác sĩ
            }
        });
        modal.setForm(bs);  // Fill dữ liệu vào modal
        modal.setVisible(true);
    }

    void init() {
        setLocationRelativeTo(null); // đưa cửa sổ ra giữa màn hình
        this.loadAllBacSi(); // đổ dữ liệu nhân viên vào bảng
    }

    public List<String> selectID() {
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

}
