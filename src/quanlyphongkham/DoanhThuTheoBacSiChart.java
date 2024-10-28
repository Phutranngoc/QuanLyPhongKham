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
import util.Xjdbc;

/**
 *
 * @author ADMIN
 */
public class DoanhThuTheoBacSiChart extends javax.swing.JPanel {

    private String title = "Doanh Thu (Năm) Theo Bác Sĩ";
    DefaultPieDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    public int nam = 2024;

    public void setNam(int valueNam) {
        this.nam = valueNam;
        System.out.println("Updating chart for year: " + nam);
        createChart(); // Tạo lại biểu đồ
    }

    public DoanhThuTheoBacSiChart() {
        initComponents();
        createChart();
    }

    private void createChart() {
        dataset = createDataset();
        chart = createChart(dataset, title);

        // Xóa và thêm biểu đồ mới
        removeAll(); // Xóa nội dung cũ
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel); // Thêm biểu đồ mới
        revalidate(); // Cập nhật layout
        repaint(); // Vẽ lại
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        try {
            Connection connection = Xjdbc.getConnection();

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

        DoanhThuBacSi = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());
        add(DoanhThuBacSi, java.awt.BorderLayout.CENTER);
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
    private javax.swing.JPanel DoanhThuBacSi;
    // End of variables declaration//GEN-END:variables
}
