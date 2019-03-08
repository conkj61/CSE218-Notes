package iterators;
// 2/26/19  12:54 P.M.
public class LinkList {
	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	public Link getFirst() {
		return first;
	}
	
	public void setFirst(Link f) {
		this.first = f;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void displayList() {
		Link current = first;
		while(current != null) {
			
		}
	}
	
	public ListIterator getIterator() { //this is the start of new work 12:56 P.M.
		return new ListIterator(this);
	}
}