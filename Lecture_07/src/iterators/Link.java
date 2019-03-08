package iterators;
// 2/26/19  12:53 P.M.
public class Link {
	public long dData;
	public Link next;
	
	public Link(long dData) {
		this.dData = dData;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
