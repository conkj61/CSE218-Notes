package model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;

public class CompanyData {
	private final String stockName;
	private String lastRefresh;
	private HashMap<Date, IndividualStockInformation> stockData;
	
	public CompanyData(String stockName, String lastRefresh, HashMap<Date, IndividualStockInformation> stockData) {
		super();
		this.stockName = stockName;
		this.lastRefresh = lastRefresh;
		this.stockData = stockData;
	}

	public String getStockName() {
		return stockName;
	}

	public String getLastRefresh() {
		return lastRefresh;
	}

	public HashMap<Date, IndividualStockInformation> getStockData() {
		return stockData;
	}
	
	public void showTestDate(Date testDate) {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(stockName + " " + stockData.get(testDate).getDateOfStock() + ":");
		System.out.println("\topening price: $" + df.format(stockData.get(testDate).getOpen()));
		System.out.println("\tclosing price: $" + df.format(stockData.get(testDate).getClose()));
		System.out.println("\thigh price: $" + df.format(stockData.get(testDate).getHigh()));
		System.out.println("\tlow price: $" + df.format(stockData.get(testDate).getLow()));
		System.out.println("\tamount traded: " + stockData.get(testDate).getVolume());
	}
	
}