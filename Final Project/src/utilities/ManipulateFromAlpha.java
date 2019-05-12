package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulateFromAlpha {
	
	public static Date createDate(String dateFromPage) throws ParseException {
		String pageDate = dateFromPage;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateForObjects = formatter.parse(pageDate);
		return dateForObjects;
	}
}
