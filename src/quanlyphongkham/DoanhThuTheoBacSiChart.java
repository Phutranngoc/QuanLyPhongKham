package quanlyphongkham;

import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class DoanhThuTheoBacSiChart extends javax.swing.JPanel {

    private String title = "Doanh Thu (Năm) Theo Bác Sĩ";
    DefaultPieDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    public int nam = 2024;

    public void setNam(int nam) {
        this.nam = nam;
        System.out.println(nam);
        updateChart();
    }

    private void updateChart() {
        // Tạo dataset mới
        dataset = createDataset();

        // Tạo biểu đồ mới
        chart = createChart(dataset, title);

        // Xóa biểu đồ cũ
        jPanel1.removeAll();

        // Thêm biểu đồ mới vào jPanel1
        chartPanel = new ChartPanel(chart);
        jPanel1.add(chartPanel);

        // Cập nhật lại layout và vẽ lại panel
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    public DoanhThuTheoBacSiChart() {
        initComponents();
        createChart();
    }

    private void createChart() {
        dataset = createDataset();
        chart = createChart(dataset, title);
        chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuanLyPhongKham;encrypt=false;user=sa;password=12341234;");

            // Gọi stored procedure với năm được chỉ định
            CallableStatement stmt = connection.prepareCall("{call ThongKeDoanhThuTheoBS(?)}");
            stmt.setInt(1, nam); // Sử dụng biến nam

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tenBS = rs.getString("TenBS");
                double doanhThu = rs.getDouble("DoanhThu");

                result.setValue(tenBS, doanhThu);
            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, false, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{0} - {2}")); //set label display (0:name 1:value 2:percent)
        return chart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());
        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        chart.getTitle().setText(title);
    }

    public void setValues(String name, int values) {
        dataset.setValue(name, values);
    }

    public void setValues(String name, double values) {
        dataset.setValue(name, values);
    }

    public void setBackgroundImage(Icon image) {
        ImageIcon icon = (ImageIcon) image;
        chart.setBackgroundImage(icon.getImage());
    }

    public void setBackgroundColor(Color color) {
        chart.setBackgroundPaint(color);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}