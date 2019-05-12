package utilities;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import model.CompanyData;
import model.IndividualStockInformation;

public class JsonParse {
	
	public static void createStartingCompanies(HashMap<String, CompanyData> allCompanyStorage) throws JSONException, IOException, ParseException {
		allCompanyStorage.put("NFLX", createInitialCompanyData("NFLX"));
		allCompanyStorage.put("AMZN", createInitialCompanyData("AMZN"));
		allCompanyStorage.put("GOOGL", createInitialCompanyData("GOOGL"));
		allCompanyStorage.put("FB", createInitialCompanyData("FB"));
		allCompanyStorage.put("AAPL", createInitialCompanyData("AAPL"));
	}
	
	public static CompanyData createInitialCompanyData(String companyName) throws JSONException, IOException, ParseException {
		JSONObject json = utilities.CompanyStockLookup.dailyStockInfo(companyName); //retrieve raw JSON
		//separate metaData and chosen scope of stock data
		JSONObject metaData = json.getJSONObject("Meta Data");
		JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
		
		CompanyData temp = new CompanyData(metaData.getString("2. Symbol"), metaData.getString("3. Last Refreshed"), parseAlphaData(timeScope));
		return temp;
	}
	
	public static HashMap<Date, IndividualStockInformation> parseAlphaData(JSONObject timeScope) throws JSONException, IOException, ParseException {
//			JSONObject json = utilities.CompanyStockLookup.dailyStockInfo(companyName); //retrieve raw JSON
//			
//			//separate metaData and chosen scope of stock data
//			JSONObject metaData = json.getJSONObject("Meta Data");
//			JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
			
			HashMap<Date, IndividualStockInformation> company = new HashMap<Date, IndividualStockInformation>(timeScope.length() * 2);
																	//initialize with double amount of data for .5 load factor
			JSONObject stockValues = null;
			Iterator<String> keys = timeScope.keys();
//			int count = 0;
			while (keys.hasNext()) {
				String keyString = keys.next();
				Date keyDate = utilities.ManipulateFromAlpha.createDate(keyString);
				stockValues = timeScope.getJSONObject(keyString);
				double open = Double.parseDouble((String) stockValues.get("1. open"));
				double high = Double.parseDouble((String) stockValues.get("2. high"));
				double low = Double.parseDouble((String) stockValues.get("3. low"));
				double close = Double.parseDouble((String) stockValues.get("4. close"));
				long volume = Long.parseLong((String) stockValues.get("5. volume"));
				
				IndividualStockInformation stock = new IndividualStockInformation(keyDate, open, high, low, close, volume);
				company.put(keyDate, stock);
//				String keyvalue = keys.next();
//				stockValues = timeScope.getJSONObject(keyvalue);
//				System.out.println(keyvalue);
//				
//				System.out.println("\t open: " + stockValues.get("1. open"));
//				System.out.println("\t high: " + stockValues.get("2. high"));
//				System.out.println("\t low: " + stockValues.get("3. low"));
//				System.out.println("\t close: " + stockValues.get("4. close"));
//				System.out.println("\t volume: " + stockValues.get("5. volume"));
//				count++;
			}
//			System.out.println(count);
			return company;
	}
}
