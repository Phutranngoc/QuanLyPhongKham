package quanlyphongkham;

import java.awt.Color;
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

public class DoanhThuChart extends javax.swing.JPanel {

    private String title = "Doanh Thu Theo Các Dịch Vụ";
    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;

    public DoanhThuChart() {
        initComponents();
        createChart();
    }

    private void createChart() {
        dataset = createDataset();
        chart = createChart(dataset, title);
        chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5000000, "Doanh Thu", "Khám Chuyên Khoa");
        dataset.addValue(3000000, "Doanh Thu", "Xét Nghiệm");
        dataset.addValue(2000000, "Doanh Thu", "Phẫu Thuật");
        dataset.addValue(1500000, "Doanh Thu", "Khám Tổng Quát");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String title) {
        return ChartFactory.createBarChart(
                title,
                "Dịch Vụ",
                "Doanh Thu (VND)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // Legend
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
