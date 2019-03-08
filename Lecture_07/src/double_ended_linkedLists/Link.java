package double_ended_linkedLists;
// 2/21/19
public class Link {
	public double dData;
	public Link next; //these two are public just for our examples today, for ease of work
	
	public Link(double dData) {
		this.dData = dData;
		next = null;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
