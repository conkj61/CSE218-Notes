package compareObjects;

// 3/5/19  12:34 P.M.
public class Country implements Comparable<Country>{ //12:36 it can only take a country to compare. This forces
						//us to create a way to allow us to actually compare things.
	private String name;
	private Double area; //12:53 P.M. double changed to Double in order to compare, since it uses objects

	public Country(String name, double area) {
		super();
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", area=" + area + "]";
	}

	@Override
	public int compareTo(Country o) {
		//this is the unimplemented method that we must account for
//		return name.compareTo(o.name); //By doing this we are comparing the name. When you compare two objects
						//(strings in this case) they get compared by ASCII value.
		//12:52 P.M.  What if we want to compare Countries by size? return statement commented out
		return area.compareTo(o.area); //12:59
		//suppose the scenario exist that we want to switch how it compares, but we no longer have access
		//to the Country class anymore. We will write an entirely different class CountryComparator
	}

}
