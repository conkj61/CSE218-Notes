package model;

import java.util.Date;

public class IndividualStockInformation {
	private final Date dateOfStock;
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	private final int interval;

	public IndividualStockInformation(Date dateOfStock, double open, double high, double low, double close,
			long volume, int interval) {
		super();
		this.dateOfStock = dateOfStock;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.interval = interval;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public Date getDateOfStock() {
		return dateOfStock;
	}

	public double getOpen() {
		return open;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getClose() {
		return close;
	}

	public long getVolume() {
		return volume;
	}

	public int getInterval() {
		return interval;
	}
}