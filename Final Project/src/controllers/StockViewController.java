package controllers;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CompanyData;

public class StockViewController {
	@FXML
	private Label stockNameLbl;
	@FXML
	private Label dateLbl;
	@FXML
	private Label stockDate;
	@FXML
	private Label timeFrameLbl;
	@FXML
	private Label lastRefreshLbl;
	@FXML
	private Label openLbl;
	@FXML
	private Label openingPrice;
	@FXML
	private Label closingLbl;
	@FXML
	private Label closingPrice;
	@FXML
	private Label highLbl;
	@FXML
	private Label highPrice;
	@FXML
	private Label lowLbl;
	@FXML
	private Label lowPrice;
	@FXML
	private Label amountLbl;
	@FXML
	private Label amountTraded;
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
	@FXML
	private Label updateLbl;
	@FXML
	private Button update;
	
	
	private CompanyData requestedInfo;
	private Date dateTraverse;
	private Date startDate;
	private Date endDate;
	private Calendar c;
	private MainApp mainApp;
	
	@FXML
	public void initialize() {
	}
	
	public StockViewController() {
	}
	
	@FXML
	private void handleUpdateBtn() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/UpdateDialog.fxml"));
		AnchorPane popup = (AnchorPane) loader.load();
		
		Stage dialog = new Stage();
		dialog.setTitle("Update Current Day");
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(mainApp.getPrimary());
		Scene scene = new Scene(popup);
		dialog.setScene(scene);
		UpdateController controller = loader.getController();
		controller.setDialog(dialog);
		controller.setStock(requestedInfo.getStockData().get(utilities.CompareMapKeys.findLatestStockDate(requestedInfo)));
		dialog.showAndWait();
	}
	
	public void loadData(CompanyData requestedStockInfo, Date requestedDate, String timeFrame) {
		update.setVisible(false);
		updateLbl.setVisible(false);
		dateLbl.setText("Stock Date:");
		openLbl.setText("Opening Price:");
		closingLbl.setText("Closing Price:");
		highLbl.setText("High Price:");
		lowLbl.setText("Low Price:");
		amountLbl.setText("Amount Traded:");
		requestedInfo = requestedStockInfo;
		
		Date test = utilities.CompareMapKeys.findLatestStockDate(requestedInfo);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(requestedDate);
		cal2.setTime(test);
		boolean same = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		if (same) {
			update.setVisible(true);
			updateLbl.setVisible(true);
		}
		
		dateTraverse = requestedDate;
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		String dateStr = formatter.format(requestedDate);
		DecimalFormat df = new DecimalFormat("#.00");
		
		stockNameLbl.setText(requestedInfo.getStockName());
		stockDate.setText(dateStr);
		timeFrameLbl.setText(timeFrame);
		lastRefreshLbl.setText(requestedInfo.getLastRefresh());
		openingPrice.setText("$" + df.format(requestedInfo.getStockData().get(dateTraverse).getOpen()));
		closingPrice.setText("$" + df.format(requestedInfo.getStockData().get(dateTraverse).getClose()));
		highPrice.setText("$" + df.format(requestedInfo.getStockData().get(dateTraverse).getHigh()));
		lowPrice.setText("$" + df.format(requestedInfo.getStockData().get(dateTraverse).getLow()));
		amountTraded.setText(String.valueOf(requestedInfo.getStockData().get(dateTraverse).getVolume()));
		avgHighLbl.setText(utilities.CompanyComputations.avgWeekHighPercent(requestedInfo));
		avgLowLbl.setText(utilities.CompanyComputations.avgWeekLowPercent(requestedInfo));
		createChart();
	}
	
	public void loadData(CompanyData requestedStockInfo, Date startDate, Date endDate, String timeFrame) {
		dateLbl.setText("Date Range:");
		openLbl.setText("Opening Average:");
		closingLbl.setText("Closing Average:");
		highLbl.setText("Average High Price:");
		lowLbl.setText("Average Low Price:");
		amountLbl.setText("Average Amount Traded:");
		update.setVisible(false);
		updateLbl.setVisible(false);
		requestedInfo = requestedStockInfo;
		this.startDate = startDate;
		this.endDate = endDate;
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		String dateStr1 = formatter.format(startDate);
		String dateStr2 = formatter.format(endDate);
		DecimalFormat df = new DecimalFormat("#.00");
		
		stockNameLbl.setText(requestedInfo.getStockName());
		stockDate.setText(dateStr1 + " - " + dateStr2);
		timeFrameLbl.setText(timeFrame);
		lastRefreshLbl.setText(requestedInfo.getLastRefresh());
		openingPrice.setText("$" + df.format(getRangeOpenAvg()));
		closingPrice.setText("$" + df.format(getRangeCloseAvg()));
		highPrice.setText("$" + df.format(getRangeHighAvg()));
		lowPrice.setText("$" + df.format(getRangeLowAvg()));
		amountTraded.setText(df.format(getRangeAmountTradedAvg()));
		avgHighLbl.setText(utilities.CompanyComputations.avgWeekHighPercent(requestedInfo));
		avgLowLbl.setText(utilities.CompanyComputations.avgWeekLowPercent(requestedInfo));
		createRangeChart();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createChart() {
		stockChart.setTitle("Stock History for 30 days after date");
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(0);
		xAxis.setUpperBound(30);
		xAxis.setTickUnit(1);
		yAxis.setForceZeroInRange(false);
		if(dateTraverse.after(thirtyStockDayPostStart())) {
			traverseBack30StockDays();
			stockChart.setTitle("Stock History for 30 days before date");
			xAxis.setLowerBound(30);
			xAxis.setUpperBound(0);
		}
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createRangeChart() {
		stockChart.setTitle("Stock data between the two dates");
		stockChart.getXAxis().setTickLabelsVisible(false);
		xAxis.setForceZeroInRange(false);
		yAxis.setForceZeroInRange(false);
		
		XYChart.Series series1 = new XYChart.Series();
		dateTraverse = startDate;
		series1.setName("Open");
		while(!dateTraverse.after(endDate)) {
			double open = requestedInfo.getStockData().get(dateTraverse).getOpen();
			series1.getData().add(new XYChart.Data(dateTraverse.getTime(), open));
			incrementDate();
		}
		
		XYChart.Series series2 = new XYChart.Series();
		dateTraverse = startDate;
		series2.setName("Close");
		while(!dateTraverse.after(endDate)) {
			double close = requestedInfo.getStockData().get(dateTraverse).getClose();
			series2.getData().add(new XYChart.Data(dateTraverse.getTime(), close));
			incrementDate();
		}
		
		XYChart.Series series3 = new XYChart.Series();
		dateTraverse = startDate;
		series3.setName("High");
		while(!dateTraverse.after(endDate)) {
			double high = requestedInfo.getStockData().get(dateTraverse).getHigh();
			series3.getData().add(new XYChart.Data(dateTraverse.getTime(), high));
			incrementDate();
		}
		
		XYChart.Series series4 = new XYChart.Series();
		dateTraverse = startDate;
		series4.setName("Low");
		while(!dateTraverse.after(endDate)) {
			double low = requestedInfo.getStockData().get(dateTraverse).getLow();
			series4.getData().add(new XYChart.Data(dateTraverse.getTime(), low));
			incrementDate();
		}
		
		stockChart.getData().addAll(series1, series2, series3, series4);
	}

	private Double getRangeOpenAvg() {
		double average = 0.0;
		int days = 0;
		dateTraverse = startDate;
		while (!dateTraverse.after(endDate)) {
			average += requestedInfo.getStockData().get(dateTraverse).getOpen();
			days++;
			incrementDate();
		}
		return average / days;
	}
	
	private Double getRangeCloseAvg() {
		double average = 0.0;
		int days = 0;
		dateTraverse = startDate;
		while (!dateTraverse.after(endDate)) {
			average += requestedInfo.getStockData().get(dateTraverse).getClose();
			days++;
			incrementDate();
		}
		return average / days;
	}
	
	private Double getRangeHighAvg() {
		double average = 0.0;
		int days = 0;
		dateTraverse = startDate;
		while (!dateTraverse.after(endDate)) {
			average += requestedInfo.getStockData().get(dateTraverse).getHigh();
			days++;
			incrementDate();
		}
		return average / days;
	}
	
	private Double getRangeLowAvg() {
		double average = 0.0;
		int days = 0;
		dateTraverse = startDate;
		while (!dateTraverse.after(endDate)) {
			average += requestedInfo.getStockData().get(dateTraverse).getLow();
			days++;
			incrementDate();
		}
		return average / days;
	}
	
	private Double getRangeAmountTradedAvg() {
		double average = 0.0;
		int days = 0;
		dateTraverse = startDate;
		while (!dateTraverse.after(endDate)) {
			average += requestedInfo.getStockData().get(dateTraverse).getVolume();
			days++;
			incrementDate();
		}
		return average / days;
	}

	private Date thirtyStockDayPostStart() {
		Date beginning = utilities.CompareMapKeys.findEarliestStockDate(requestedInfo);
		c = Calendar.getInstance();
		c.setTime(beginning);
		for(int i = 0; i <= 30; i++) {
			c.add(Calendar.DATE, 1);
			beginning = c.getTime();
			while(!requestedInfo.getStockData().containsKey(beginning)) {
				c.add(Calendar.DATE, 1);
				beginning = c.getTime();
			}
		}
		return beginning;
	}

	private void incrementDate() {
		c = Calendar.getInstance();
		c.setTime(dateTraverse);
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
