package doublyLinkedLinkList;
// 2/21/19
public class Link { //12:53 P.M.
	//again these variable are public for ease of our teaching and testing
	public long dData;
	public Link next;
	public Link previous;
	
	public Link(long dData) {
		this.dData = dData;
		next = null;
		previous = null;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
/* this style of linked list will tackle the problem allowing us to delete the last link in the 
 * chain, so we can move front to back or back to front.
 * 
 * It will not however be any sort of efficient for searching
 */