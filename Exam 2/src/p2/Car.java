package p2;

public class Car implements Chargeable {
	public String plateValue;

	public Car(String plateValue) {
		this.plateValue = plateValue;
	}

	@Override
	public int charge() {
		
		return 7;
		
	}

}
