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
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 3: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					tuesOccur++;
					tuesWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 4: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					wedOccur++;
					wedWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 5: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					thursOccur++;
					thursWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 6: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					weekCount++;
					friOccur++;
					friWeekHigh = companyInQuestion.getStockData().get(earliest).getHigh();
					double highest = getHighDayOfWeek(monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);

					if (highest == monWeekHigh) {
						monHighCount++;
					} else if (highest == tuesWeekHigh) {
						tuesHighCount++;
					} else if (highest == wedWeekHigh) {
						wedHighCount++;
					} else if (highest == thursWeekHigh) {
						thursHighCount++;
					} else if (highest == friWeekHigh) {
						friHighCount++;
					}
					
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
					monWeekHigh = tuesWeekHigh = wedWeekHigh = thursWeekHigh = friWeekHigh = 0.0;
					break;
				} else {
					weekCount++;
					double highest = getHighDayOfWeek(monWeekHigh, tuesWeekHigh, wedWeekHigh, thursWeekHigh, friWeekHigh);

					if (highest == monWeekHigh) {
						monHighCount++;
					} else if (highest == tuesWeekHigh) {
						tuesHighCount++;
					} else if (highest == wedWeekHigh) {
						wedHighCount++;
					} else if (highest == thursWeekHigh) {
						thursHighCount++;
					} else if (highest == friWeekHigh) {
						friHighCount++;
					}
					
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
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
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 3: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					tuesOccur++;
					tuesWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 4: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					wedOccur++;
					wedWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 5: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					thursOccur++;
					thursWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					incrementDate();
					break;
				} else {
					incrementDate();
					break;
				}
			}
			case 6: {
				if (companyInQuestion.getStockData().containsKey(earliest)) {
					weekCount++;
					friOccur++;
					friWeekLow = companyInQuestion.getStockData().get(earliest).getLow();
					double lowest = getLowDayOfWeek(monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);

					if (lowest == monWeekLow && monWeekLow != 0) {
						monLowCount++;
					} else if (lowest == tuesWeekLow && tuesWeekLow != 0) {
						tuesLowCount++;
					} else if (lowest == wedWeekLow && wedWeekLow != 0) {
						wedLowCount++;
					} else if (lowest == thursWeekLow && thursWeekLow != 0) {
						thursLowCount++;
					} else if (lowest == friWeekLow && friWeekLow != 0) {
						friLowCount++;
					}
					
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
					monWeekLow = tuesWeekLow = wedWeekLow = thursWeekLow = friWeekLow = 0.0;
					break;
				} else {
					weekCount++;
					double lowest = getLowDayOfWeek(monWeekLow, tuesWeekLow, wedWeekLow, thursWeekLow, friWeekLow);

					if (lowest == monWeekLow && monWeekLow != 0) {
						monLowCount++;
					} else if (lowest == tuesWeekLow && tuesWeekLow != 0) {
						tuesLowCount++;
					} else if (lowest == wedWeekLow && wedWeekLow != 0) {
						wedLowCount++;
					} else if (lowest == thursWeekLow && thursWeekLow != 0) {
						thursLowCount++;
					} else if (lowest == friWeekLow && friWeekLow != 0) {
						friLowCount++;
					}
					
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
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

	private static double getHighDayOfWeek(double monHigh, double tuesHigh, double wedHigh, double thursHigh, double friHigh) {
		double highest = Math.max(monHigh, Math.max(tuesHigh, Math.max(wedHigh, Math.max(thursHigh, friHigh))));
		return highest;
	}

	private static double getLowDayOfWeek(double monLow, double tuesLow, double wedLow, double thursLow, double friLow) {
		double lowest = Math.min(monLow, Math.min(tuesLow, Math.min(wedLow, Math.min(thursLow, friLow))));
		return lowest;
	}

	private static void incrementDate() {
		c.add(Calendar.DATE, 1);
		earliest = c.getTime();
	}
}
/*
		CompanyData test = companyInQuestion;
		Date earliest = utilities.CompareMapKeys.findEarliestStockDate(test);
		Date mostRecent = utilities.CompareMapKeys.findLatestStockDate(test);
		System.out.println(earliest);
//	System.out.println(test.getStockData().get(earliest).getHigh());
//	System.out.println(test.getStockData().get(mostRecent).getHigh());

		Calendar c = Calendar.getInstance();
		int monOccur = 0, tuesOccur = 0, wedOccur = 0, thursOccur = 0, friOccur = 0;

		int monHigh, tuesHigh, wedHigh, thursHigh, friHigh, monLow, tuesLow, wedLow, thursLow, friLow;
		monHigh = tuesHigh = wedHigh = thursHigh = friHigh = monLow = tuesLow = wedLow = thursLow = friLow = 0;

		int weekCount = 0;
		int dayOfWeek;

		double monTempHigh, tuesTempHigh, wedTempHigh, thursTempHigh, friTempHigh;
		double monTempLow, tuesTempLow, wedTempLow, thursTempLow, friTempLow;
		monTempHigh = tuesTempHigh = wedTempHigh = thursTempHigh = friTempHigh = monTempLow = tuesTempLow = wedTempLow = thursTempLow = friTempLow = 0.0;

		while ((earliest.compareTo(mostRecent) < 0) || (earliest.compareTo(mostRecent) == 0)) {
			c.setTime(earliest);
			dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			switch (dayOfWeek) {
			case 2: {
				if (test.getStockData().containsKey(earliest)) {
					monOccur++;
					monTempHigh = test.getStockData().get(earliest).getHigh();
					monTempLow = test.getStockData().get(earliest).getLow();
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				} else {
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				}
			}
			case 3: {
				if (test.getStockData().containsKey(earliest)) {
					tuesOccur++;
					tuesTempHigh = test.getStockData().get(earliest).getHigh();
					tuesTempLow = test.getStockData().get(earliest).getLow();
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				} else {
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				}
			}
			case 4: {
				if (test.getStockData().containsKey(earliest)) {
					wedOccur++;
					wedTempHigh = test.getStockData().get(earliest).getHigh();
					wedTempLow = test.getStockData().get(earliest).getLow();
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				} else {
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				}
			}
			case 5: {
				if (test.getStockData().containsKey(earliest)) {
					thursOccur++;
					thursTempHigh = test.getStockData().get(earliest).getHigh();
					thursTempLow = test.getStockData().get(earliest).getLow();
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				} else {
					c.add(Calendar.DATE, 1);
					earliest = c.getTime();
					break;
				}
			}
			case 6: {
				if (test.getStockData().containsKey(earliest)) {
					friOccur++;
					weekCount++;
					friTempHigh = test.getStockData().get(earliest).getHigh();
					friTempLow = test.getStockData().get(earliest).getLow();
					double highest = Math.max(monTempHigh,
							Math.max(tuesTempHigh, Math.max(wedTempHigh, Math.max(thursTempHigh, friTempHigh))));
					double lowest = Math.min(monTempLow,
							Math.min(tuesTempLow, Math.min(wedTempLow, Math.min(thursTempLow, friTempLow))));

					if (highest == monTempHigh) {
						monHigh++;
					} else if (highest == tuesTempHigh) {
						tuesHigh++;
					} else if (highest == wedTempHigh) {
						wedHigh++;
					} else if (highest == thursTempHigh) {
						thursHigh++;
					} else if (highest == friTempHigh) {
						friHigh++;
					}

					if (lowest == monTempLow && monTempLow != 0.0) {
						monLow++;
					} else if (lowest == tuesTempLow && tuesTempLow != 0.0) {
						tuesLow++;
					} else if (lowest == wedTempLow && wedTempLow != 0.0) {
						wedLow++;
					} else if (lowest == thursTempLow && thursTempLow != 0.0) {
						thursLow++;
					} else if (lowest == friTempLow && friTempLow != 0.0) {
						friLow++;
					}
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
					monTempHigh = tuesTempHigh = wedTempHigh = thursTempHigh = friTempHigh = monTempLow = tuesTempLow = wedTempLow = thursTempLow = friTempLow = 0.0;
					break;
				} else {
					weekCount++;
					double highest = Math.max(monTempHigh,
							Math.max(tuesTempHigh, Math.max(wedTempHigh, Math.max(thursTempHigh, friTempHigh))));
					double lowest = Math.min(monTempLow,
							Math.min(tuesTempLow, Math.min(wedTempLow, Math.min(thursTempLow, friTempLow))));

					if (highest == monTempHigh) {
						monHigh++;
					} else if (highest == tuesTempHigh) {
						tuesHigh++;
					} else if (highest == wedTempHigh) {
						wedHigh++;
					} else if (highest == thursTempHigh) {
						thursHigh++;
					} else if (highest == friTempHigh) {
						friHigh++;
					}

					if ((lowest == monTempLow) && (monTempLow != 0.0)) {
						monLow++;
					} else if ((lowest == tuesTempLow) && (tuesTempLow != 0.0)) {
						tuesLow++;
					} else if ((lowest == wedTempLow) && (wedTempLow != 0.0)) {
						wedLow++;
					} else if ((lowest == thursTempLow) && (thursTempLow != 0.0)) {
						thursLow++;
					} else if ((lowest == friTempLow) && (friTempLow != 0.0)) {
						friLow++;
					}
					c.add(Calendar.DATE, 3);
					earliest = c.getTime();
					monTempHigh = tuesTempHigh = wedTempHigh = thursTempHigh = friTempHigh = monTempLow = tuesTempLow = wedTempLow = thursTempLow = friTempLow = 0.0;
					break;
				}
			}
			default:
				break;
			}
		}
		System.out.println("monHigh count = " + monHigh);
		System.out.println("tuesHigh count = " + tuesHigh);
		System.out.println("wedHigh count = " + wedHigh);
		System.out.println("thursHigh count = " + thursHigh);
		System.out.println("friHigh count = " + friHigh);
		System.out.println("monLow count = " + monLow);
		System.out.println("tuesLow count = " + tuesLow);
		System.out.println("wedLow count = " + wedLow);
		System.out.println("thursLow count = " + thursLow);
		System.out.println("friLow count = " + friLow);
		System.out.println("Max should be: " + weekCount);
		System.out.println();
		System.out.println("Total number of Mondays that had trades: " + monOccur);
		System.out.println("Total number of Tuesdays that had trades: " + tuesOccur);
		System.out.println("Total number of Wednesdays that had trades: " + wedOccur);
		System.out.println("Total number of Thursdays that had trades: " + thursOccur);
		System.out.println("Total number of Fridays that had trades: " + friOccur);
		System.out.println("Should equal total days of: " + test.getStockData().size());
		*/
