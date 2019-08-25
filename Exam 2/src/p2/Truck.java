package p2;

public class Truck implements Chargeable {
	public String plateValue;

	public Truck(String plateValue) {
		this.plateValue = plateValue;
	}

	@Override
	public int charge() {
		return 10;
	}

}
