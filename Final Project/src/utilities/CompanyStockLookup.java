package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class CompanyStockLookup {
	//The entire purpose of this class is to pull the JSON data from AlphaVantage, choosing daily or intraday
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject dailyStockInfo(String companyStockAcronym) throws IOException, JSONException { //Daily JSON
		InputStream is = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+companyStockAcronym+"&outputsize=full&apikey=85J8CA3LZG9FHHP7").openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static JSONObject intraDayStockInfo(String companyStockAcronym, int interval) throws IOException, JSONException { //Intraday JSON
		InputStream is = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + companyStockAcronym + 
				"&intercal=" + interval + "min&outputsize=full&apikey=85J8CA3LZG9FHHP7").openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

}
