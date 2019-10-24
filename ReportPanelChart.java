import java.util.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;

import org.jfree.chart.plot.*;
import org.jfree.*;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.time.*;
import org.jfree.data.xy.*;
import org.jfree.chart.renderer.xy.*;
import java.time.LocalDate;
import org.jfree.data.time.RegularTimePeriod;
import java.text.SimpleDateFormat;

public class ReportPanelChart extends JPanel{
	private JFreeChart chart;
	private XYSeriesCollection dataset;
	private String name;
	private String xAxis;
	private String yAxis;
	private List<Serie> series;
	public ReportPanelChart(String name,String xAxis,String yAxis, List<Serie> series){
		this.name = name;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.series = series;
		initUI();

	}

	public XYDataset createDataset(List<Serie> series){
		TimeSeriesCollection dataset = new TimeSeriesCollection();

		Calendar cal = Calendar.getInstance();
		int serieCont = 0;
		for(Serie serie : series){

			TimeSeries ts = new TimeSeries("series"+serieCont);
			for(Refuel refuel : serie.getAbast()){

			   	ts.add(new Day(refuel.getDia(),refuel.getMes(), refuel.getAno()), 5);
			}
			dataset.addSeries(ts);
			serieCont++;
		}

		return dataset;
	}


	private JFreeChart makeChart(){
		XYDataset dataset = createDataset(series);
		return ChartFactory.createTimeSeriesChart(
			name,
			xAxis,
			yAxis,
			dataset,
			// /PlotOrientation.VERTICAL,
			true,
			true,
			true
			);
		
	}

	public void initUI(){
		chart = makeChart();
		XYPlot plot = chart.getXYPlot();
		XYSplineRenderer renderer = new XYSplineRenderer();
		plot.setRenderer(renderer);
		ChartPanel chartpanel = new ChartPanel(chart);
		add(chartpanel);
		setVisible(true);
	}
}