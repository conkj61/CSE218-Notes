package utilities;

import java.util.Calendar;
import java.util.Date;

import model.CompanyData;

public class CompanyComputations {
	private static Date earliest;
	private static Date mostRecent;
	private static Calendar c;
	private static int dayOfWeek;
	private static int weekCount;
	private static int monHighCount, tuesHighCount, wedHighCount, thursHighCount, friHighCount, monLowCount, tuesLowCount, wedLowCount, thursLowCount, friLowCount;
	private static double monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh;
	private static double monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow;

	public static String avgWeekHighPercent(CompanyData companyInQuestion) {
		earliest = utilities.CompareMapKeys.findEarliestStockDate(companyInQuestion);
		mostRecent = utilities.CompareMapKeys.findLatestStockDate(companyInQuestion);
		c = Calendar.getInstance();
		
		monHighCount = tuesHighCount = wedHighCount = thursHighCount = friHighCount = 0;
		weekCount = 0;

		while ((earliest.compareTo(mostRecent) < 0) || (earliest.compareTo(mostRecent) == 0)) {
			c.setTime(earliest);
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			switch (dayOfWeek) {
			case 2: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					monWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 3: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					tuesWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 4: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					wedWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 5: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					thursWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 6: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					weekCount++;
					friWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					double highest = getHighDayOfWeek(monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);
					
					incrementHighCount(highest, monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);
					
					incrementDate(3);
					monWeekHigh = tuesWeekHigh = wedWeekHigh = thursWeekHigh = friWeekHigh = 0.0;
					break;
				} else {
					weekCount++;
					double highest = getHighDayOfWeek(monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);
					
					incrementHighCount(highest, monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);

					incrementDate(3);
					monWeekHigh = tuesWeekHigh = wedWeekHigh = thursWeekHigh = friWeekHigh = 0.0;
					break;
				}
			}
			default: break;
			}
		}

		String highPercent = "High day occurs usually on "  + getHighDay() + "s at " + Math.round(highCounter() * 100.0) + "% of all weeks";
		return highPercent;
	}

	private static String getHighDay() {
		String day = null;
		if(highCounter() == (double)monHighCount / weekCount) {
			day = "Monday";
		} else if(highCounter() == (double)tuesHighCount / weekCount) {
			day = "Tuesday";
		} else if(highCounter() == (double)wedHighCount / weekCount) {
			day = "Wednesday";
		} else if(highCounter() == (double)thursHighCount / weekCount) {
			day = "Thursday";
		} else if(highCounter() == (double)friHighCount / weekCount) {
			day = "Friday";
		}
		return day;
	}
	
	private static double highCounter() {
		double monPer = (double)monHighCount / weekCount;
		double tuesPer = (double)tuesHighCount / weekCount;
		double wedPer = (double)wedHighCount / weekCount;
		double thurPer = (double)thursHighCount / weekCount;
		double friPer = (double)friHighCount / weekCount;
		return Math.max(monPer, Math.max(tuesPer, Math.max(wedPer, Math.max(thurPer, friPer))));
	}

	public static String avgWeekLowPercent(CompanyData companyInQuestion) {
		earliest = utilities.CompareMapKeys.findEarliestStockDate(companyInQuestion);
		mostRecent = utilities.CompareMapKeys.findLatestStockDate(companyInQuestion);
		c = Calendar.getInstance();
		
		monLowCount = tuesLowCount = wedLowCount = thursLowCount = friLowCount = 0;
		weekCount = 0;

		while ((earliest.compareTo(mostRecent) < 0) || (earliest.compareTo(mostRecent) == 0)) {
			c.setTime(earliest);
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			switch (dayOfWeek) {
			case 2: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					monWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 3: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					tuesWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 4: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					wedWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 5: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					thursWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate(1);
					break;
				} else {
					incrementDate(1);
					break;
				}
			}
			case 6: {
				weekCount++;
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					friWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					double lowest = getLowDayOfWeek(monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);

					incrementLowCount(lowest, monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);

					incrementDate(3);
					monWeekLow = tuesWeekLow = wedWeekLow = thursWeekLow = friWeekLow = 0.0;
					break;
				} else {
					double lowest = getLowDayOfWeek(monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);
					
					incrementLowCount(lowest, monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);

					incrementDate(3);
					monWeekLow = tuesWeekLow = wedWeekLow = thursWeekLow = friWeekLow = 0.0;
					break;
				}
			}
			default: break;
			}
		}

		String lowPercent = "Low day usually occurs on "  + getLowDay() + "s at " + Math.round(lowCounter() * 100.0) + "% of all weeks";
		return lowPercent;
	}

	private static String getLowDay() {
		String day = null;
		if(lowCounter() == (double)monLowCount / weekCount) {
			day = "Monday";
		} else if(lowCounter() == (double)tuesLowCount / weekCount) {
			day = "Tuesday";
		} else if(lowCounter() == (double)wedLowCount / weekCount) {
			day = "Wednesday";
		} else if(lowCounter() == (double)thursLowCount / weekCount) {
			day = "Thursday";
		} else if(lowCounter() == (double)friLowCount / weekCount) {
			day = "Friday";
		}
		return day;
	}
	
	private static double lowCounter() {
		double monPer = (double)monLowCount / weekCount;
		double tuesPer = (double)tuesLowCount / weekCount;
		double wedPer = (double)wedLowCount / weekCount;
		double thurPer = (double)thursLowCount / weekCount;
		double friPer = (double)friLowCount / weekCount;
		return Math.min(monPer, Math.min(tuesPer, Math.min(wedPer, Math.min(thurPer, friPer))));
	}
	
	private static void incrementLowCount(double compareValue, double monVar, double tuesVar, double wedVar, double thursVar, double friVar) {
		if (compareValue == monVar) {
			monLowCount++;
		} else if (compareValue == tuesVar) {
			tuesLowCount++;
		} else if (compareValue == wedVar) {
			wedLowCount++;
		} else if (compareValue == thursVar) {
			thursLowCount++;
		} else if (compareValue == friVar) {
			friLowCount++;
		}
	}
	
	private static void incrementHighCount(double compareValue, double monVar, double tuesVar, double wedVar, double thursVar, double friVar) {
		if (compareValue == monVar) {
			monHighCount++;
		} else if (compareValue == tuesVar) {
			tuesHighCount++;
		} else if (compareValue == wedVar) {
			wedHighCount++;
		} else if (compareValue == thursVar) {
			thursHighCount++;
		} else if (compareValue == friVar) {
			friHighCount++;
		}
	}

	private static double getHighDayOfWeek(double monHigh, double tuesHigh, double wedHigh, double thursHigh, double friHigh) {
		double highest = Math.max(monHigh, Math.max(tuesHigh, Math.max(wedHigh, Math.max(thursHigh, friHigh))));
		return highest;
	}

	private static double getLowDayOfWeek(double monLow, double tuesLow, double wedLow, double thursLow, double friLow) {
		if (monLow == 0.0) {
			monLow = 1000000000;
		} 
		if (tuesLow == 0.0) {
			tuesLow = 1000000000;
		} 
		if (wedLow == 0.0) {
			wedLow = 1000000000;
		} 
		if (thursLow == 0.0) {
			thursLow = 1000000000;
		} 
		if (friLow == 0.0) {
			friLow = 1000000000;
		} 
		
		double lowest = Math.min(monLow, Math.min(tuesLow, Math.min(wedLow, Math.min(thursLow, friLow))));
		return lowest;
	}

	private static void incrementDate(int incrementValue) {
		c.add(Calendar.DATE, incrementValue);
		earliest = c.getTime();
	}
}