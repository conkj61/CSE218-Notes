package p2;

public class Pedestrain implements Chargeable {
	public String social;

	public Pedestrain(String social) {
		this.social = social;
	}

	@Override
	public int charge() {
		return 3;
	}

}
