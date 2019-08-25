package p2;

public class Bike implements Chargeable {
	public String vinNum;

	public Bike(String vinNum) {
		this.vinNum = vinNum;
	}

	@Override
	public int charge() {
		return 4;
	}

}
