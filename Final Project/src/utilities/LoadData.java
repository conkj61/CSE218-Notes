package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import model.CompanyData;

public class LoadData {


	public static void loadData(HashMap allCompanies) {
		try {
			FileInputStream fis = new FileInputStream("dataFolder/Stock Data.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			allCompanies = (HashMap<String, CompanyData>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
