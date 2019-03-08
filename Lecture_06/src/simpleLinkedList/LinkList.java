package simpleLinkedList;
// 2/19/19  12:35 P.M.
public class LinkList {
	private Link first; //the first link
	
	public LinkList() {
		first = null; //the first link will nearly always be null, since the list is empty
	}
	
	public void displayList() {
		System.out.println("List (First--->Last): ");
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.getNext();
		}
		System.out.println();
	}
	
	public Link search(int key) { //12:46 P.M.   search/find function
		Link current = first; //make the current start at the beginning
		while(current.getiData() != key) { //if it doesn't equal the data move forward
			if(current.getNext() == null) {
				return null; //went through entire list with no match
			} else {
				current = current.getNext(); //move to the next link
			}
		}
		return current;
	}
	
	public boolean isEmpty() {
		return first == null; //this is appropriate, because without a first link, there is no list
	}
	
	public void insertFirst(int i, double d) { // 12:40 P.M this method name change from insert to
						//insert next, we did this to signify that insert will add to the beginning
		//in order to insert, we must create a link first, to start the chain
		Link newLink = new Link(i, d); //here, we create a link but this one's "next" is still null
								//because new links are created with "next" being null
		
		newLink.setNext(first);
		first = newLink; //these two lines, make the new link the first one, and the old one the 2nd
				//we inserted the new one "ahead" of the first one
		//there is no way to insert last, we will not be taught if it exist. Because this would be
		//incredibly slow and highly inefficient, defeating the purpose of linked list
	}
	
	public Link deleteFirst() {
		Link temp = first;
		first = first.getNext(); //the second link replaces the first, the original first will
								//become part of garbage collection
		return temp;
	}
	
	public Link delete(int key) { //delete non-first
		Link current = first;
		Link previous = first; //in order to delete non-first, we have to see the last link
		while(current.getiData() != key) {
			if(current.getNext() == null) {
				return null; //end of list
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		if(current == first) { //this is a special case, match happens immediately
			first = first.getNext();
		} else {
			previous.setNext(current.getNext());
		}
		return current;
	}
}
