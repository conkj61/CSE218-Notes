package doublyLinkedLinkList;
// 2/26/19  12:36 P.M.
public class Demo {

	public static void main(String[] args) {
		// DoublyLinkedList demo
		DoublyLinkedList theList = new DoublyLinkedList();
		theList.insertLast(69);
		theList.displayForward();
		theList.insertFirst(22);
		theList.displayForward();
		theList.insertFirst(44);
		theList.displayForward();
		theList.insertFirst(66);
		theList.displayForward();
		
		theList.displayBackwards();
		theList.displayForward();
		theList.deleteKey(44);
		theList.displayForward();
		
		theList.insertBefore(22, 55);
		theList.displayForward();
	}

}
