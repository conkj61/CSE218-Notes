package testZone;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import model.CompanyData;
import model.IndividualStockInformation;
import utilities.ManipulateFromAlpha;

public class Demo {
	
	public static void main(String[] args) throws ParseException, JSONException, IOException {
//		double numer = 4356;
//		double denom = 6745;
//		System.out.println(numer / denom * 100);
		
		HashMap<String, CompanyData> holdAllCompanies = new HashMap<String, CompanyData>();
		utilities.JsonParse.createStartingCompanies(holdAllCompanies);
		
		CompanyData test = holdAllCompanies.get("NFLX");
		Date earliest = utilities.CompareMapKeys.findEarliestStockDate(test);
		Date mostRecent = utilities.CompareMapKeys.findLatestStockDate(test);
		System.out.println(earliest);
//		System.out.println(test.getStockData().get(earliest).getHigh());
//		System.out.println(test.getStockData().get(mostRecent).getHigh());
		
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
		
		
//		HashMap<Date, IndividualStockInformation> lowKeySearch = test.getStockData();
//		Map.Entry<Date, IndividualStockInformation> firstEntry = lowKeySearch.entrySet().iterator().next();
//		Date earliestDate = firstEntry.getKey();
//		
//		for(Map.Entry<Date, IndividualStockInformation> map : lowKeySearch.entrySet()) {
//			Date key = map.getKey();
//			if (earliestDate.after(key)) {
//				earliestDate = key;
//			}
//		}
//		System.out.println("First available date should be: " + utilities.CompareMapKeys.findEarliestStockDate(test));
		
//		System.out.println(holdAllCompanies.containsKey("AMZN"));
//		System.out.println(holdAllCompanies.containsKey("NFLX"));
//		System.out.println(holdAllCompanies.containsKey("GOOGL"));
//		System.out.println(holdAllCompanies.containsKey("FB"));
//		System.out.println(holdAllCompanies.containsKey("AAPL"));
//		
//		holdAllCompanies.get("NFLX").showTestDate(ManipulateFromAlpha.createDate("2019-03-25"));
		
//		CompanyData netflixTest = utilities.JsonParse.createInitialCompanyData("NFLX");
////		System.out.println(netflixTest);
//		
//		CompanyData amazonTest = utilities.JsonParse.createInitialCompanyData("AMZN");
//		holdAllCompanies.put("NFLX", netflixTest);
//		holdAllCompanies.put("AMZN", amazonTest);
//		String s = "AMZN";
//		System.out.println(holdAllCompanies.containsKey(s));
//		System.out.println(holdAllCompanies.containsKey("buttered toast"));
		
//		String myDate = "2019-03-15";
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date d = formatter.parse(myDate);
////		String test = DateFormat.getDateInstance().format(d);
////		DateFormat
//		System.out.println(DateFormat.getDateInstance().format(d));
		
//		JSONObject json = utilities.CompanyStockLookup.dailyStockInfo("NFLX");
//		JSONObject metaData = json.getJSONObject("Meta Data");
//		JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
//		int n = timeScope.length();
//		
//		HashMap<Date, IndividualStockInformation> company = new HashMap<Date, IndividualStockInformation>(timeScope.length() * 2);
//		JSONObject stockValues = null;
//		Iterator<String> keys = timeScope.keys();
//		int count = 0;
//		while (keys.hasNext()) {
//			String keyString = keys.next();
//			Date keyDate = utilities.ManipulateFromAlpha.createDate(keyString);
//			stockValues = timeScope.getJSONObject(keyString);
//			double open = Double.parseDouble((String) stockValues.get("1. open"));
//			double high = Double.parseDouble((String) stockValues.get("2. high"));
//			double low = Double.parseDouble((String) stockValues.get("3. low"));
//			double close = Double.parseDouble((String) stockValues.get("4. close"));
//			long volume = Long.parseLong((String) stockValues.get("5. volume"));
//			
//			IndividualStockInformation stock = new IndividualStockInformation(keyDate, open, high, low, close, volume);
//			company.put(keyDate, stock);
//			System.out.println(volume);
//			System.out.println();
			
//			DecimalFormat df = new DecimalFormat("#.00");
//			System.out.println(open);
//			System.out.println(df.format(open));
//			System.out.println();
			
//			String keyvalue = keys.next();
////			stockValues = timeScope.getJSONObject(keyvalue);
//			System.out.println(keyvalue);
//			
//			System.out.println("\t open: " + stockValues.get("1. open"));
//			System.out.println("\t high: " + stockValues.get("2. high"));
//			System.out.println("\t low: " + stockValues.get("3. low"));
//			System.out.println("\t close: " + stockValues.get("4. close"));
//			System.out.println("\t volume: " + stockValues.get("5. volume"));
//			count++;
//		}
//		Date testSearch = utilities.ManipulateFromAlpha.createDate("2019-01-31");
//		System.out.println(company.get(testSearch).getDateOfStock());
//		System.out.println(company.get(testSearch).getOpen());
//		System.out.println(company.get(testSearch).getHigh());
//		System.out.println(company.get(testSearch).getLow());
//		System.out.println(company.get(testSearch).getClose());
//		System.out.println(company.get(testSearch).getVolume());
//		System.out.println(count);
//		return company;
	}
	
}
