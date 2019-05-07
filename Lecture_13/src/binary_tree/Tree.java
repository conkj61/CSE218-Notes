package binary_tree;

import java.util.Stack;

// 4/9/19  12:38 P.M.
/// triple / comments denote notes taken on 4/11/19
public class Tree {
	private Node root;
	
	public Tree() { //12:39
		root = null; //empty tree
	}
	
	public Node find(int key) { //12:41 things we likely want our tree to be able to do
					///12:37 we are assuming that the tree is not empty
		Node current = root;
		while(current.iData != key) {
			if(key < current.iData) { ///if the key is smaller than our current node
				current = current.leftChild; ///we will move left
			} else { ///key is larger than our node
				current = current.rightChild; ///move to the right
			}
			
			if(current == null) { ///have reached the end without finding a match
				return null;
			}
		}
		return current;
	} ///12:40 again we ran a loop with two exits, and it was clear what we were doing along the way.
	
	public void insert(int key/*Node node*/) { //12:41 things we likely want our tree to be able to do
							//12:43 we changed from node to tree, to hide the complexity for user
		Node newNode = new Node();
		newNode.iData = key;
		if(root == null) { ///12:19 special case of not having a root already(Empty tree)
			root = newNode;
		} else { ///12:20 root already exist
			Node current = root;
			Node parent;
			while(true) { ///12:25 this is an infinite while loop, will only end when we tell it to
				///infinite loops are not always bad (a common misconception)
				///loops can be good, when code is both clear and concise, and the loops function is clean
				parent = current;
				if(key < current.iData) { ///12:22 key smaller than data, go left
					current = current.leftChild; ///moving along to the left
					if(current == null) { ///have gotten all the way left
						parent.leftChild = newNode;
						return; ///12:25 one exit to leave our infinite loop
					} ///12:32 with each of these actions/branches in the loop, our statements were clear at each step
				} else { ///12:23 else we will go right
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return; ///12:25 second exit to leave our infinite loop
					} ///12:32 with each of these actions/branches in the loop, our statements were clear at each step
				}
			} ///12:25 furthermore, keywords such as: break, return, continue, etc may also have poor conceptions
			  ///associated with them. But again when used with clear and concise code all can be good and useful.
			  ///the above code is a good example of how infinite loops and exit keywords can be good.
		}
	}
	
	public boolean delete(int key) { //12:41 things we likely want our tree to be able to do
		//all copied from pasted notes on 4/16/19
		
		// (assumes non-empty list)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.iData != key) { // search for key
			parent = current;
			if (key < current.iData) { // go left
				isLeftChild = true;
				current = current.leftChild;
			} else { // or go right
				isLeftChild = false;
				current = current.rightChild;
			}

			if (current == null) { // end of the line
				return false;
			}
		} // end while

		// found node to delete, it is just a matter of deleting it from this
		// point on

		// if it has no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) { // if root,
				root = null; // tree is empty
			} else if (isLeftChild) {
				parent.leftChild = null; // disconnect from parent
			} else {
				parent.rightChild = null; // disconnect from parent
			}
		}

			// if no right child, replace with left subtree
		else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		}
		// if no left child, replace with right subtree
		else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else { // two children
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);
			// connect parent of current to successor instead
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		} // end else two children

		// (successor cannot have a left child)
		return true;
	} // end of delete
	// returns node with next-highest value after delNode
	// goes to right child then right child's left descendants
	
	private Node getSuccessor(Node delNode) {
		//all copied from pasted notes on 4/16/19
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while (current != null) { // until no more left children
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}

		if (successor != delNode.rightChild) { // if successor not right child,
												// make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void preOrder(Node localRoot) { ///1:06
		if(localRoot != null) { ///checking that the tree isn't empty
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	public void inOrder(Node localRoot) { ///1:06
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public void postOrder(Node localRoot) { ///1:06
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	public void traverse(int traverseType) {//all copied from pasted notes on 4/16/19
		switch (traverseType) {
		case 1:
			System.out.print("\nPreorder Traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder Traversal: ");
			inOrder(root);
			break;
		case 3:
			System.out.println("\nPostorder Traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}
	
	public void displayTree() { //12:41 things we likely want our tree to be able to do
		//all copied from pasted notes on 4/16/19
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out
				.println("--------------------------------------------------");
		while (isRowEmpty == false) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
		} // end while isRowEmpty is false
		System.out
				.println("---------------------------------------------------");
	} // end displayTree()
	
}
