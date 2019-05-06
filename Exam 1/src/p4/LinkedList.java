package p4;

public class LinkedList {
	private Link first;
	private Link last;
	
	public LinkedList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(Student data) {
		Link newLink = new Link(data);
		if(isEmpty()) { //special case of list being empty
			last = newLink;
		} else {
			first.previous = newLink; //make sure the old link's previous value is set to the new link
		}
		newLink.next = first; //make sure the new link chains to the existing link
		first = newLink; //make new link the start
	}
	
	public boolean insertBefore(Student key, Student data) {
		Link current = first;
		while(current.data != key) {
			current = current.next;
			if(current == null) {
				return false;
			}
		}
		Link newLink = new Link(data);
		
		if(current == first) {
			newLink.next = first;
			first.previous = newLink;
			first = newLink;
		} else {
			newLink.next = current;
			current.previous.next = newLink;
			newLink.previous = current.previous;
			current.previous = newLink;
		}
		return true;
	}
	
	public boolean insertAfter(Student key, Student data) {
		Link current = first;
		while(current.data != key) {
			current = current.next;
			if(current == null) {
				return false;
			}
		}
		//if the method got here, then a match was found
		Link newLink = new Link(data);
		if(current == last) { //in the case of the last link, we will insert it at the end
			newLink.next = null;
			last = newLink;
		} else { //otherwise will take the current link and set it's next target as the newLink's target
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
	
	public Link deleteKey(Student key) {
		Link current = first;
		while(current.data != key) {
			current = current.next;
			if(current == null) {
				return null;
			}
		}
		
		if(current == first) {
			first = current.next; //only happens when deletion is the first link
		} else {
			current.previous.next = current.next;
		}
		
		if(current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current; //last chance to see deleted link data
	}
	
	public void displayForward() {
		System.out.println("list (first --> last: ");
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
	public void displayBackwards() {
		System.out.println("list (last --> first: ");
		Link current = last;
		while(current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println();
	}
	
	public void insertLast(Student data) {
		Link newLink = new Link(data);
		if(isEmpty()) { //special case of list being empty
			first = newLink;
		} else {
			last.next = newLink; //same as first but inverse, previous last will point to the new link
		}
		newLink.previous = last; //the new link's previous set to the existing last
		last = newLink; //set new link as the end of the chain
	}
	
	public String deleteLast() {
		Link temp = last;
		if(first.next == null) { //special case of only one link
			first = null;
		}
		last.previous.next = null; //setting the link before the last next value to be null, since
					//the link will be deleted
		last = last.previous; //set second to last as the last link
		return temp.displayLink();
	}
	
	public String deleteFirst() {
		Link temp = first;
		if(first.next == null) { //special case of the only being one link
			last = null;
		}
		first.next.previous = null; //take the old first one, go to the next one, set that previous
				//to be null so that way it will become the first
		first = first.next;
		return temp.displayLink();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
