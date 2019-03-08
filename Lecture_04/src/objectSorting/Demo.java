package objectSorting;

public class Demo {

	public static void main(String[] args) {
		int maxSize = 100;
		ArrayInOb arr = new ArrayInOb(maxSize);
		
		arr.insert("Berners-Lee", "Tim", (2019 - 1955)); //this gentleman invented html
		arr.insert("Jobs", "Steve", (2011 - 1955)); //Mr. Apple himself
		arr.insert("Gates", "Bill", (2019 - 1955));
//		arr.insert("Emaxwell", "Albert", 76);
		arr.insert("Einstein", "Albert", (1955 - 1879));
		arr.insert("Maxwell", "James", (1879 - 1831));
//		arr.insert("Nugget", "Robby", 18);
		arr.insert("Newton", "Issac", (1727 - 1642));
		arr.insert("Gallilei", "Gailileo", (1642 - 1564));
		
		System.out.println("Before sorting: ");
		arr.display();
		arr.insertionSort();
		System.out.println("After sorting: ");
		arr.display();
	}

}
