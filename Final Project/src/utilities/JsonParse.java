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
		allCompanyStorage.put("NFLX", createInitialCompanies("NFLX"));
		allCompanyStorage.put("AMZN", createInitialCompanies("AMZN"));
//		allCompanyStorage.put("GOOGL", createInitialCompanies("GOOGL"));
//		allCompanyStorage.put("FB", createInitialCompanies("FB"));
//		allCompanyStorage.put("AAPL", createInitialCompanies("AAPL"));
	}
	
	public static CompanyData createInitialCompanies(String companyName) throws JSONException, IOException, ParseException {
		JSONObject json = utilities.CompanyStockLookup.dailyStockInfo(companyName); //retrieve raw JSON
		//separate metaData and chosen scope of stock data
		JSONObject metaData = json.getJSONObject("Meta Data");
		JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
		
		CompanyData temp = new CompanyData(metaData.getString("2. Symbol"), metaData.getString("3. Last Refreshed"), parseAlphaData(timeScope, 1440)); //1440 mins in a day
		return temp;
	}
	
	public static CompanyData createDailyCompanyData(String companyName) throws JSONException, IOException, ParseException {
		JSONObject json = utilities.CompanyStockLookup.dailyStockInfo(companyName); //retrieve raw JSON
		CompanyData temp = null;
		if(json.has("Note")) {
			alerts.Alerts.timeOutAlert();
		}
		else {
		if(json.has("Error Message")) {
			alerts.Alerts.failedSearch();
		} else {
			alerts.Alerts.successfulSearch();
			//separate metaData and chosen scope of stock data
			JSONObject metaData = json.getJSONObject("Meta Data");
			JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
			
			temp = new CompanyData(metaData.getString("2. Symbol"), metaData.getString("3. Last Refreshed"), parseAlphaData(timeScope, 1440)); //1440 mins in a day
			}
		}
		return temp;
	}
	
	public static CompanyData createIntraCompanyData(String companyName, int interval) throws JSONException, IOException, ParseException {
		JSONObject json = utilities.CompanyStockLookup.dailyStockInfo(companyName); //retrieve raw JSON
		CompanyData temp = null;
		if(json.has("Note")) {
			alerts.Alerts.timeOutAlert();
		}
		else {
		if(json.has("Error Message")) {
			alerts.Alerts.failedSearch();
		} else {
			alerts.Alerts.successfulSearch();
			//separate metaData and chosen scope of stock data
			JSONObject metaData = json.getJSONObject("Meta Data");
			JSONObject timeScope = json.getJSONObject("Time Series (Daily)");
			
			temp = new CompanyData(metaData.getString("2. Symbol"), metaData.getString("3. Last Refreshed"), parseAlphaData(timeScope, interval));
			}
		}
		return temp;
	}
	
	public static HashMap<Date, IndividualStockInformation> parseAlphaData(JSONObject timeScope, int interval) throws JSONException, IOException, ParseException {
			HashMap<Date, IndividualStockInformation> company = new HashMap<Date, IndividualStockInformation>(timeScope.length() * 2);
																	//initialize with double amount of data for .5 load factor
			JSONObject stockValues = null;
			Iterator<String> keys = timeScope.keys();
			while (keys.hasNext()) {
				String keyString = keys.next();
				Date keyDate = utilities.ManipulateFromAlpha.createDate(keyString);
				stockValues = timeScope.getJSONObject(keyString);
				double open = Double.parseDouble((String) stockValues.get("1. open"));
				double high = Double.parseDouble((String) stockValues.get("2. high"));
				double low = Double.parseDouble((String) stockValues.get("3. low"));
				double close = Double.parseDouble((String) stockValues.get("4. close"));
				long volume = Long.parseLong((String) stockValues.get("5. volume"));
				
				IndividualStockInformation stock = new IndividualStockInformation(keyDate, open, high, low, close, volume, interval);
				company.put(keyDate, stock);
			}
			return company;
	}
}