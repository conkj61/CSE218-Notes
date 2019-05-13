package utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.CompanyData;
import model.IndividualStockInformation;

public class CompareMapKeys {
	
	public static Date findEarliestStockDate (CompanyData companyToSearch) {
		HashMap<Date, IndividualStockInformation> lowKeySearch = companyToSearch.getStockData();
		Map.Entry<Date, IndividualStockInformation> firstEntry = lowKeySearch.entrySet().iterator().next();
		Date earliestDate = firstEntry.getKey();
		
		for(Map.Entry<Date, IndividualStockInformation> map : lowKeySearch.entrySet()) {
			Date key = map.getKey();
			if (earliestDate.after(key)) {
				earliestDate = key;
			}
		}
		return earliestDate;
	}
	
	public static Date findLatestStockDate (CompanyData companyToSearch) {
		HashMap<Date, IndividualStockInformation> highKeySearch = companyToSearch.getStockData();
		Map.Entry<Date, IndividualStockInformation> firstEntry = highKeySearch.entrySet().iterator().next();
		Date latestDate = firstEntry.getKey();
		
		for(Map.Entry<Date, IndividualStockInformation> map : highKeySearch.entrySet()) {
			Date key = map.getKey();
			if (latestDate.before(key)) {
				latestDate = key;
			}
		}
		return latestDate;
	}
	
}
