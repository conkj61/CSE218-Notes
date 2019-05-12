package model;

import java.util.Date;

public class IndividualStockInformation {
	private final Date dateOfStock;
	private final double open;
	private final double high;
	private final double low;
	private final double close;
	private final long volume;

	public IndividualStockInformation(Date dateOfStock, double open, double high, double low, double close,
			long volume) {
		super();
		this.dateOfStock = dateOfStock;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
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

}
