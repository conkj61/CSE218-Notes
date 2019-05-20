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
import utilities.CompanyComputations;
import utilities.ManipulateFromAlpha;

public class Demo {
	
	public static void main(String[] args) throws ParseException, JSONException, IOException {
//		double numer = 4356;
//		double denom = 6745;
//		System.out.println(numer / denom * 100);
		
		
		HashMap<String, CompanyData> holdAllCompanies = new HashMap<String, CompanyData>();
		utilities.JsonParse.createStartingCompanies(holdAllCompanies);
//
//		holdAllCompanies.put("jdsncsanfsa", utilities.JsonParse.createDailyCompanyData("jdsncsanfsa"));
		Date mostRecent = utilities.CompareMapKeys.findLatestStockDate(holdAllCompanies.get("NFLX"));
		holdAllCompanies.get("NFLX").showTestDate(mostRecent);
		
		Calendar c = Calendar.getInstance();
		c.setTime(mostRecent);
		for(int i = 0; i <= 30; i++) {
			c.add(Calendar.DATE, -1);
			mostRecent = c.getTime();
			while(!holdAllCompanies.get("NFLX").getStockData().containsKey(mostRecent)) {
				c.add(Calendar.DATE, -1);
				mostRecent = c.getTime();
			}
			holdAllCompanies.get("NFLX").showTestDate(mostRecent);
		}
		
		
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
