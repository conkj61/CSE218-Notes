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
	private static int monOccur, tuesOccur, wedOccur, thursOccur, friOccur;
	private static int monHighCount, tuesHighCount, wedHighCount, thursHighCount, friHighCount, monLowCount, tuesLowCount, wedLowCount, thursLowCount, friLowCount;
	private static double monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh;
	private static double monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow;

	public static void avgWeekHighPercent(CompanyData companyInQuestion) {
		earliest = utilities.CompareMapKeys.findEarliestStockDate(companyInQuestion);
		mostRecent = utilities.CompareMapKeys.findLatestStockDate(companyInQuestion);
		c = Calendar.getInstance();
		
		monOccur = tuesOccur = wedOccur = thursOccur = friOccur = 0;
		monHighCount = tuesHighCount = wedHighCount = thursHighCount = friHighCount = 0;
		weekCount = 0;

		while ((earliest.compareTo(mostRecent) < 0) || (earliest.compareTo(mostRecent) == 0)) {
			c.setTime(earliest);
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			switch (dayOfWeek) {
			case 2: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					monOccur++;
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
					tuesOccur++;
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
					wedOccur++;
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
					thursOccur++;
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
					friOccur++;
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
		System.out.println("Out of " + weekCount + " weeks of data:");
		System.out.println("monHigh count = " + monHighCount + " which occurs " + Math.round(monHighCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("tuesHigh count = " + tuesHighCount + " which occurs " + Math.round(tuesHighCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("wedHigh count = " + wedHighCount + " which occurs " + Math.round(wedHighCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("thursHigh count = " + thursHighCount + " which occurs " + Math.round(thursHighCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("friHigh count = " + friHighCount + " which occurs " + Math.round(friHighCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("Weeks unaccounted for: " + (weekCount - monHighCount - tuesHighCount - wedHighCount - thursHighCount - friHighCount));
		System.out.println("Total number of Mondays that had trades: " + monOccur);
		System.out.println("Total number of Tuesdays that had trades: " + tuesOccur);
		System.out.println("Total number of Wednesdays that had trades: " + wedOccur);
		System.out.println("Total number of Thursdays that had trades: " + thursOccur);
		System.out.println("Total number of Fridays that had trades: " + friOccur);
		System.out.println("Should equal total days of: " + companyInQuestion.getStockData().size());
		System.out.println("Days unaccounted for: " + (companyInQuestion.getStockData().size() - (monOccur + tuesOccur + wedOccur + thursOccur + friOccur)));
	}

	public static void avgWeekLowPercent(CompanyData companyInQuestion) {
		earliest = utilities.CompareMapKeys.findEarliestStockDate(companyInQuestion);
		mostRecent = utilities.CompareMapKeys.findLatestStockDate(companyInQuestion);
		c = Calendar.getInstance();
		
		monOccur = tuesOccur = wedOccur = thursOccur = friOccur = 0;
		monLowCount = tuesLowCount = wedLowCount = thursLowCount = friLowCount = 0;
		weekCount = 0;

		while ((earliest.compareTo(mostRecent) < 0) || (earliest.compareTo(mostRecent) == 0)) {
			c.setTime(earliest);
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			switch (dayOfWeek) {
			case 2: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					monOccur++;
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
					tuesOccur++;
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
					wedOccur++;
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
					thursOccur++;
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
					friOccur++;
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
		System.out.println("Out of " + weekCount + " weeks of data:");
		System.out.println("monLow count = " + monLowCount + " which occurs " + Math.round(monLowCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("tuesLow count = " + tuesLowCount + " which occurs " + Math.round(tuesLowCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("wedLow count = " + wedLowCount + " which occurs " + Math.round(wedLowCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("thursLow count = " + thursLowCount + " which occurs " + Math.round(thursLowCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("friLow count = " + friLowCount + " which occurs " + Math.round(friLowCount * 100.0 / weekCount) +"% of weeks");
		System.out.println("Weeks unaccounted for: " + (weekCount - monLowCount - tuesLowCount - wedLowCount - thursLowCount - friLowCount));
		System.out.println("Total number of Mondays that had trades: " + monOccur);
		System.out.println("Total number of Tuesdays that had trades: " + tuesOccur);
		System.out.println("Total number of Wednesdays that had trades: " + wedOccur);
		System.out.println("Total number of Thursdays that had trades: " + thursOccur);
		System.out.println("Total number of Fridays that had trades: " + friOccur);
		System.out.println("Should equal total days of: " + companyInQuestion.getStockData().size());
		System.out.println("Days unaccounted for: " + (companyInQuestion.getStockData().size() - (monOccur + tuesOccur + wedOccur + thursOccur + friOccur)));
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