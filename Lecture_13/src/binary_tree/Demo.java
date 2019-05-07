package binary_tree;
// 4/11/19  12:42
public class Demo {

	public static void main(String[] args) {
			Tree theTree = new Tree();
			theTree.insert(50);
			theTree.insert(25);
			theTree.insert(75);
			theTree.insert(10); //1:11
//			theTree.find(25).display();
//			theTree.find(35).display();//this line should fail with a null pointer
			
			theTree.preOrder(theTree.find(50));
			System.out.println();
			theTree.postOrder(theTree.find(50));
			System.out.println();
			theTree.inOrder(theTree.find(50));
	}

}
