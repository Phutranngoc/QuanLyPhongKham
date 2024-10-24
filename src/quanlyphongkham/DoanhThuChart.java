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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import util.Xjdbc;

public class DoanhThuChart extends javax.swing.JPanel {

    private String title = "Doanh Thu (Năm) Theo Tháng";
    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    public int nam = 2024;

    public DoanhThuChart() {
        initComponents();
        createChart();
    }

    public void setNam(int valueNam) {
        this.nam = valueNam;
        System.out.println("Updating chart for year: " + nam);
        createChart(); // Tạo lại biểu đồ
    }

    private void createChart() {
//        dataset = createDataset();
//        chart = createChart(dataset, title);
//        chartPanel = new ChartPanel(chart);
//        this.add(chartPanel);

        dataset = createDataset();
        chart = createChart(dataset, title);

        // Xóa và thêm biểu đồ mới
        removeAll(); // Xóa nội dung cũ
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel); // Thêm biểu đồ mới
        revalidate(); // Cập nhật layout
        repaint(); // Vẽ lại
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection connection = Xjdbc.getConnection();
            CallableStatement stmt = connection.prepareCall("{call GetDoanhThuTheoThang(?)}");
            stmt.setInt(1, nam);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int thang = rs.getInt("Thang");
                double doanhThu = rs.getDouble("DoanhThu");
                dataset.addValue(doanhThu, "Doanh Thu", "Tháng " + thang);
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String title) {
        return ChartFactory.createBarChart(
                title,
                " ",
                "Doanh Thu (VND)",
                dataset,
                PlotOrientation.VERTICAL,
                false, // Legend
                true, // Tooltips
                false // URLs
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        chart.getTitle().setText(title);
    }

    public void setValues(String name, int values) {
        dataset.setValue(values, "Doanh Thu", name);
    }

    public void setValues(String name, double values) {
        dataset.setValue(values, "Doanh Thu", name);
    }

    public void setBackgroundImage(Icon image) {
        ImageIcon icon = (ImageIcon) image;
        chart.setBackgroundImage(icon.getImage());
    }

    public void setBackgroundColor(Color color) {
        chart.setBackgroundPaint(color);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
