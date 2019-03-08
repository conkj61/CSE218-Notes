package simpleLinkedList;
// 2/19/19 12:31 P.M.
public class Link {
	private int iData;
	private double dData;
	private Link next;
	
	public Link(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
		this.next = null; //everytime I create a new link it won't point to anything to begin,
						//then later we will create the relationship
	}

	public int getiData() {
		return iData;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}

	public double getdData() {
		return dData;
	}

	public void setdData(double dData) {
		this.dData = dData;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	public void displayLink() {
		System.out.println(iData + "," + dData);
	}
}
