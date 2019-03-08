package double_ended_linkedLists;

public class FirstLastLinkList {
	private Link first;
	private Link last;
	
	public FirstLastLinkList() {
		first = null;
		last = null;
	}
	
	public void insertLast(double dData) { //12:35 P.M. written after insertFirst
		Link newLink = new Link(dData);
		if(isEmpty()) {
			first = newLink;
		}
		last.next = newLink; //since adding to the end, the last link next will go from null, to the new link
		last = newLink;
	}
	
	public void insertFirst(double dData) {
		Link newLink = new Link(dData);
		if(isEmpty()) {
			last = newLink; //this is a special case, only happens when there is nothing to link to
		}
		newLink.next = first; //12:28 P.M. if empty or not, new link's next, should be the first one
		first = newLink; //before we do this, the old link should become the new link's next  12:27 P.M.
	}
	
	public double deleteFirst() { //12:38 P.M.
		//will give the chance to use deleted data a final time, permanently deleted after calling this
		double temp = first.dData;
		if(first.next == null) {
			last = null;
		}
		first = first.next; //the "second" link becomes the "first" link
		return temp;
	}
	
	public void displayList() { //so we have to be careful here, because we have no indexes to work with
		Link current = first;
		while(current != null) { //so long as the current link has a link in front of it, keep going
			current.displayLink(); //display the link
			current = current.next; //then change to the next link in the chain
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}
/* 12:50 P.M.
 * this style of linked list can be used either for a stack, or queue style data
 */