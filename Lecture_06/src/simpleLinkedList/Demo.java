package simpleLinkedList;
// 2/19/19  1:03 P.M.
public class Demo {

	public static void main(String[] args) {
		//demo for linked list
		LinkList theList = new LinkList();
		
		theList.insertFirst(22, 22.22);
		theList.insertFirst(33, 33.33);
		theList.insertFirst(55, 55.55);
		theList.insertFirst(11, 11.11);
		
		theList.displayList();
		
		Link f = theList.search(33);
		f.displayLink();
		
		Link d = theList.delete(55);
		d.displayLink();
		
		System.out.println(theList.isEmpty());
		
		theList.displayList();
	}

}
/* A linked list is really only efficient and fast when working with the first of the list.
 * It is very fast when inserting and delete the first link, deleting at the end is very slow and
 * inefficient for this.
 * So this is really a more efficient Stack, keep in mind that the stack is an abstract data type
 */