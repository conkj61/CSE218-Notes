package p2;

public class Demo {
	
	public static void main(String[] args) {
		BagGeneric<Integer> testInt = new BagGeneric<>(5);
//		testInt.addValue("five");
		testInt.addValue(4);
		testInt.addValue(13);
		testInt.addValue(3);
		testInt.addValue(8);
		testInt.addValue(6);
		testInt.findGeneric(3);
		testInt.deleteGeneric(8);
		testInt.findGeneric(8);
		testInt.display();
		System.out.println();
		
		BagGeneric<Double> testDouble = new BagGeneric<>(5);
//		testDouble.addValue(2);
		testDouble.addValue(2.3);
		testDouble.addValue(3.4);
		testDouble.addValue(1.2);
		testDouble.addValue(6.7);
		testDouble.addValue(4.5);
		testDouble.findGeneric(1.2);
		testDouble.deleteGeneric(3.4);
		testDouble.findGeneric(3.4);
		testDouble.display();
		System.out.println();
		
		BagGeneric<String> testString = new BagGeneric<>(6);
//		testString.addValue(3);
		testString.addValue("Billy");
		testString.addValue("Rob");
		testString.addValue("Crystal");
		testString.addValue("Olivia");
		testString.addValue("Mike");
		testString.addValue("Beth");
		testString.findGeneric("Olive");
		testString.findGeneric("Olivia");
		testString.deleteGeneric("Crystal");
		testString.findGeneric("Crystal");
		testString.display();
	}
}