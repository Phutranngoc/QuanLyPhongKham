/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyphongkham;

import DAO.BenhNhanDAO;
import Entity.BacSi;
import Entity.Benhnhan;
import Entity.Benhnhan.BenhNhanModalCallback;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.MsgBox;
import util.Xjdbc;
import util.TableWithDeleteButton; // Nhập khẩu lớp TableIcon

/**
 *
 * @author ADMIN
 */
public class BenhNhanPage extends javax.swing.JFrame {

    /**
     * Creates new form Doctor
     */
    public BenhNhanPage() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bệnh Nhân", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Bảo Hiểm", "SĐT", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.setPreferredSize(new java.awt.Dimension(600, 240));
        tblBang.setRowHeight(30);
        tblBang.setRowMargin(4);
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 960, 410));

        btnAdd.setText("Thêm Mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 110, 30));

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

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách bệnh nhân");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setText("Quản lý bệnh nhân");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/vector-MAY-2020-112.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.create();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // Kiểm tra nhấp chuột đơn
        if (evt.getClickCount() == 1) {
            int row = tblBang.getSelectedRow();
            int column = tblBang.columnAtPoint(evt.getPoint()); // Lấy cột được nhấn

            // Kiểm tra nếu cột không phải là cột "Xóa"
            if (column != 7) { // Giả sử cột "Thao Tác" là cột thứ 8 (index 7)
                this.row = row; // Cập nhật hàng được chọn
                this.edit(); // Gọi hàm edit chỉ khi không nhấn vào cột "Xóa"
            }
        }
    }//GEN-LAST:event_tblBangMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Lấy giá trị tìm kiếm từ jTextField1
        String keyword = jTextField1.getText().trim();

        // Kiểm tra nếu keyword không rỗng
        if (!keyword.isEmpty()) {
            // Gọi phương thức tìm kiếm từ dao
            List<Benhnhan> results = dao.searchByCodeOrName(keyword);

            // Cập nhật bảng với dữ liệu mới
            fillTable(results);
        } else {
            // Nếu không có gì để tìm kiếm, có thể load lại toàn bộ danh sách bác sĩ
            loadAllBenhNhan(); // Phương thức này cần được tạo để load lại tất cả bác sĩ
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
            java.util.logging.Logger.getLogger(BenhNhanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenhNhanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenhNhanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenhNhanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup buttonGroupBaoHiem;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBang;
    // End of variables declaration//GEN-END:variables

    BenhNhanDAO dao = new BenhNhanDAO();
    int row = -1;

    void init() {
        setLocationRelativeTo(null); // đưa cửa sổ ra giữa màn hình
        this.loadAllBenhNhan(); // đổ dữ liệu nhân viên vào bảng
    }

    private void loadAllBenhNhan() {
        List<Benhnhan> list = dao.selectALL(); // Giả sử bạn có phương thức này trong DAO
        fillTable(list); // Cập nhật bảng với toàn bộ danh sách bác sĩ
    }

    void create() {
        // Tạo một modal BenhNhanForm và hiển thị nó
        BenhNhanModal modal = new BenhNhanModal(this, true, false, new BenhNhanModalCallback() {
            @Override
            public void onBenhNhanAdded() {
                init(); // Gọi phương thức init() để cập nhật danh sách bác sĩ
            }
        });
        modal.setVisible(true);

    }

    private void fillTable(List<Benhnhan> list) {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0); // Xóa sạch dữ liệu bên trong bảng

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày từ cơ sở dữ liệu
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng đầu ra

            for (Benhnhan bn : list) {
                // Định dạng ngày sinh
                String dateString = bn.getNgaySinh();
                String formattedDate = dateString; // Giá trị mặc định
                try {
                    Date date = inputFormat.parse(dateString);
                    formattedDate = outputFormat.format(date); // Định dạng thành DD/MM/YYYY
                } catch (ParseException e) {
                    System.out.println("Lỗi phân tích ngày: " + e.getMessage());
                }

                // Thêm hàng vào model
                Object[] row = {
                    bn.getMaBN(),
                    bn.getTenBN(),
                    formattedDate,
                    bn.getGioiTinh(),
                    bn.getDiachi(),
                    bn.isBaoHiem() ? "Có" : "Không",
                    bn.getSDT(),
                    "Xóa"
                };
                model.addRow(row);
            }
            // Thêm MouseListener để xử lý sự kiện nhấn chuột
            tblBang.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tblBang.rowAtPoint(e.getPoint());
                    int column = tblBang.columnAtPoint(e.getPoint());
                    if (column == 7) { // Nếu cột được nhấp là cột "Xóa"
                        String maBN = (String) tblBang.getValueAt(row, 0); // Lấy mã bệnh nhân
                        delete(maBN); // Gọi hàm xóa
                    }
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy xuất dữ liệu");
        }
    }

    private void delete(String maBN) {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có thật sự muốn xóa bệnh nhân này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    dao.delete(maBN); // Xóa bệnh nhân từ cơ sở dữ liệu bằng mã bệnh nhân
                    this.loadAllBenhNhan();
                    MsgBox.alert(this, "Xóa bệnh nhân thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa bệnh nhân thất bại. Vui lòng kiểm tra lại.");
                    MsgBox.alert(this, "Hãy xóa phiếu khám của bệnh nhân này trước!");
                }
            }
        }
    }

    void edit() {
        String mabn = (String) tblBang.getValueAt(this.row, 0);
        Benhnhan bn = dao.selectById(mabn);

        // Tạo một modal BacSiForm và hiển thị nó
        BenhNhanModal modal = new BenhNhanModal(this, true, true, new BenhNhanModalCallback() {
            @Override
            public void onBenhNhanAdded() {
                init(); // Gọi phương thức init() để cập nhật danh sách bác sĩ
            }
        });
        modal.setForm(bn);  // Fill dữ liệu vào modal
        modal.setVisible(true);
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

}
