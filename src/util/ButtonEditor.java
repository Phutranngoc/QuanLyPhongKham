package util;


import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private JTable table;
    private int row;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Ngừng chỉnh sửa
                // Xử lý xóa hàng
                if (table != null) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow); // Xóa hàng
                    }
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        if (value instanceof JButton) {
            button = (JButton) value; // Sử dụng nút đã có
        } else {
            button.setText("Xóa");
            button.setIcon(new ImageIcon(getClass().getResource("/Background/Index.jpeg"))); // Đường dẫn đến hình ảnh
        }
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }
}
