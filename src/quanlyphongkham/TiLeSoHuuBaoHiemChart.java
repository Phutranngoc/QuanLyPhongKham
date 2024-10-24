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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import util.Xjdbc;

public class TiLeSoHuuBaoHiemChart extends javax.swing.JPanel {

    private String title = "Tỉ Lệ Bệnh Nhân Sở Hữu Bảo Hiểm Y Tế";
    DefaultPieDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;

    public TiLeSoHuuBaoHiemChart() {
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
           Connection connection = Xjdbc.getConnection();
            CallableStatement stmt = connection.prepareCall("{call GetTiLeBaoHiem}");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int coBaoHiem = rs.getInt("CoBaoHiem");
                int khongCoBaoHiem = rs.getInt("KhongCoBaoHiem");

                result.setValue("Có Bảo Hiểm", coBaoHiem);
                result.setValue("Không Có Bảo Hiểm", khongCoBaoHiem);
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
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, false, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{2}")); //set label display (0:name 1:value 2:percent)
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
