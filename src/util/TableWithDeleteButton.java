package util;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class TableWithDeleteButton extends JPanel {

    public TableWithDeleteButton() {
        String[] columnNames = {"Mã Bệnh Nhân", "Tên Bệnh Nhân", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Bảo Hiểm", "SĐT", "Thao Tác"};
        Object[][] data = {
            {"BN001", "Nguyễn Văn A", "01/01/1990", "Nam", "Hà Nội", "Có", "0123456789", createDeleteButton()},
            {"BN002", "Trần Thị B", "02/02/1992", "Nữ", "Hồ Chí Minh", "Không", "0987654321", createDeleteButton()},
            // Thêm dữ liệu vào đây
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class getColumnClass(int column) {
                if (column == 7) {
                    return JButton.class; // Đặt loại cho cột "Thao Tác"
                }
                return super.getColumnClass(column);
            }
        };

        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (column == 7) {
                    JButton button = (JButton) getValueAt(row, column);
                    return button; // Hiển thị nút "Xóa"
                }
                return c;
            }
        };
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowHeight(30); // Tăng chiều cao hàng nếu cần

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private JButton createDeleteButton() {
        JButton btnDelete = new JButton("Xóa");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic để xóa bệnh nhân
                JButton source = (JButton) e.getSource();
                int row = ((JTable) ((JScrollPane) source.getParent().getParent()).getViewport().getView()).getSelectedRow();
                if (row != -1) {
                    // Xóa bệnh nhân tương ứng
                    System.out.println("Xóa bệnh nhân ở hàng: " + row);
                    // Thực hiện xóa ở đây
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một bệnh nhân để xóa.");
                }
            }
        });
        return btnDelete;
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bảng với Nút Xóa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableWithDeleteButton());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
