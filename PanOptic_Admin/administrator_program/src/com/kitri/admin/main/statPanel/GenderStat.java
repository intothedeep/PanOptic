package com.kitri.admin.main.statPanel;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GenderStat extends ApplicationFrame {
    public static String title = "User Gender Ratio";
    public GenderStat(String title) {
	super(title);
	setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset() {
	DefaultPieDataset dataset = new DefaultPieDataset();
	dataset.setValue("Female", new Double(30));
	dataset.setValue("Male", new Double(70));
	return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
	JFreeChart chart = ChartFactory.createPieChart(title, // chart
								       // title
		dataset, // data
		true, // include legend
		true, false);

	return chart;
    }

    public static JPanel createDemoPanel() {
	JFreeChart chart = createChart(createDataset());
	return new ChartPanel(chart);
    }

    public static void main(String[] args) {
	GenderStat demo = new GenderStat("Mobile Sales");
	demo.setSize(560, 367);
	RefineryUtilities.centerFrameOnScreen(demo);
	demo.setVisible(true);
    }

}
