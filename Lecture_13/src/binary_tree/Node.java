package binary_tree;
//  4/9/19  12:35 P.M.
/// triple / comments denote notes taken on 4/11/19
public class Node {
	public int iData;
	public Node leftChild;
	public Node rightChild;  ///all three of these values were changed from private to public for ease of learning
	
//	public Node(int value) {
//		iData = value;
//		
//	}
	
	public void display() {
		System.out.print(String.valueOf(iData + " "));
	}
}