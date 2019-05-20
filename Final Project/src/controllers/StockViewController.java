package controllers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.CompanyData;

public class StockViewController {
	@FXML
	private Label stockNameLbl;
	@FXML
	private Label stockDateLbl;
	@FXML
	private Label timeFrameLbl;
	@FXML
	private Label lastRefreshLbl;
	@FXML
	private Label openingLbl;
	@FXML
	private Label closingLbl;
	@FXML
	private Label highPriceLbl;
	@FXML
	private Label lowPriceLbl;
	@FXML
	private Label amountTradedLbl;
	@FXML
	private Label avgHighLbl;
	@FXML
	private Label avgLowLbl;
	@FXML
	private LineChart<Number, Number> stockChart;
	@FXML
	private NumberAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	
	
	private CompanyData requestedInfo;
	private Date dateTraverse;
	private Calendar c;
	private MainApp mainApp;
	
	@FXML
	public void initialize() {
	}
	
	public StockViewController() {
		
	}
	
	public void loadData(CompanyData requestedStockInfo, Date requestedDate, String timeFrame) {
		requestedInfo = requestedStockInfo;
		dateTraverse = requestedDate;
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		String dateStr = formatter.format(requestedDate);
		DecimalFormat df = new DecimalFormat("#.00");
//		String last = requestedStockInfo.getLastRefresh();
		
		stockNameLbl.setText(requestedStockInfo.getStockName());
		stockDateLbl.setText(dateStr);
		timeFrameLbl.setText(timeFrame);
		lastRefreshLbl.setText(requestedStockInfo.getLastRefresh());
		openingLbl.setText("$" + df.format(requestedStockInfo.getStockData().get(requestedDate).getOpen()));
		closingLbl.setText("$" + df.format(requestedStockInfo.getStockData().get(requestedDate).getClose()));
		highPriceLbl.setText("$" + df.format(requestedStockInfo.getStockData().get(requestedDate).getHigh()));
		lowPriceLbl.setText("$" + df.format(requestedStockInfo.getStockData().get(requestedDate).getLow()));
		amountTradedLbl.setText(String.valueOf(requestedStockInfo.getStockData().get(requestedDate).getVolume()));
		avgHighLbl.setText(utilities.CompanyComputations.avgWeekHighPercent(requestedStockInfo));
		avgLowLbl.setText(utilities.CompanyComputations.avgWeekLowPercent(requestedStockInfo));
		createChart();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createChart() {
		stockChart.setTitle("Stock History for 30 days before date");
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(30);
		xAxis.setUpperBound(0);
		xAxis.setTickUnit(1);
//		yAxis.setAutoRanging(false);
		yAxis.setForceZeroInRange(false);
		yAxis.setUpperBound(Math.round(requestedInfo.getStockData().get(dateTraverse).getHigh() + 35));
		yAxis.setLowerBound(Math.round(requestedInfo.getStockData().get(dateTraverse).getLow() - 20));
		traverseBack30StockDays();
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Open");
		for (int i = 30; i >= 0; i--) {
			double open = requestedInfo.getStockData().get(dateTraverse).getOpen();
			series1.getData().add(new XYChart.Data(i, open));
			incrementDate();
		}
		
		traverseBack30StockDays();
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Close");
		for (int i = 30; i >= 0; i--) {
			double close = requestedInfo.getStockData().get(dateTraverse).getClose();
			series2.getData().add(new XYChart.Data(i, close));
			incrementDate();
		}
		
		traverseBack30StockDays();
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("High");
		for (int i = 30; i >= 0; i--) {
			double high = requestedInfo.getStockData().get(dateTraverse).getHigh();
			series3.getData().add(new XYChart.Data(i, high));
			incrementDate();
		}
		
		traverseBack30StockDays();
		XYChart.Series series4 = new XYChart.Series();
		series4.setName("Low");
		for (int i = 30; i >= 0; i--) {
			double low = requestedInfo.getStockData().get(dateTraverse).getLow();
			series4.getData().add(new XYChart.Data(i, low));
			incrementDate();
		}
		
		stockChart.getData().addAll(series1, series2, series3, series4);
	}

	private void incrementDate() {
		c.add(Calendar.DATE, 1);
		dateTraverse = c.getTime();
		while(!requestedInfo.getStockData().containsKey(dateTraverse)) {
			c.add(Calendar.DATE, 1);
			dateTraverse = c.getTime();
		}
	}

	private void traverseBack30StockDays() {
		c = Calendar.getInstance();
		c.setTime(dateTraverse);
		for(int i = 0; i <= 30; i++) {
			c.add(Calendar.DATE, -1);
			dateTraverse = c.getTime();
			while(!requestedInfo.getStockData().containsKey(dateTraverse)) {
				c.add(Calendar.DATE, -1);
				dateTraverse = c.getTime();
			}
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
