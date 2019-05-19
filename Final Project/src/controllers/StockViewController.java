package controllers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.MainApp;
import javafx.fxml.FXML;
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
	
	private MainApp mainApp;
	
	@FXML
	public void initialize() {
	}
	
	public StockViewController() {
		
	}
	
	public void loadData(CompanyData requestedStockInfo, Date requestedDate, String timeFrame) {
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
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	private String getAverageWeekHigh() {
		double averageHigh;
		return null;
	}

	private String getAverageWeekLow() {
		double averageLow;
		return null;
	}
}
