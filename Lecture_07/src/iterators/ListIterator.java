package iterators;
// 2/26/19  12:57 P.M.
public class ListIterator {
	//the objective of this class is to try to traverse quickly through LinkLists
	private Link current;
	private Link previous;
	private LinkList ourList;
	
	public ListIterator(LinkList list) {
		ourList = list;
		reset(); //this methods intend is to reset the list to the first link
	}

	public void reset() {
		// 1:00 P.M.
		current = ourList.getFirst();
		previous = null;
	}
	
	public boolean atEnd() { // 1:01 P.M.
		return current.next == null;
	}
	
	public void nextLink() { // this is a method to take care of setting up the next link 1:02 P.M.
		previous = current;
		current = current.next;
	}
	
	public Link getCurrent() { //allow us to always see where we are 1:02 P.M.
		return current;
	}
	
	public void insertAfter(long dd) { // 1:04 P.M.
		Link newLink = new Link(dd);
		if(ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}		
	}
	
	public void insertBefore(long dd) { // 1:05 P.M
		Link newLink = new Link(dd);
		if(previous == null) { //at the beginning or empty list
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			reset();
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;
		}
	}
	
	public long deleteCurrent() { // 1:10 P.M.
		long value = current.dData;
		if(previous == null) { //beginning of the list
			ourList.setFirst(current.next);
			reset();
		} else {
			previous.next = current.next;
			if(atEnd()) {
				reset();
			} else {
				current = current.next;
			}
		}
		return value;
	}
}