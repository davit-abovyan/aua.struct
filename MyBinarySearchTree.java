
public class MyBinarySearchTree {
	// the root of the tree
	public static  Node root;
	/*
	 * Constructor
	 */
	public MyBinarySearchTree(){
		this.root = null;
	}
	/*
	 * CHeck whether the element is in the tree
	 */
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	/*
	 * Remove element from tree
	 * @param id - the element to remove
	 * @return true for success
	 */
	public boolean remove(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			} // end if
			if(current ==null){
				return false; // no such element to remove
			} // end if
		} // end while
		// check whether the element is leaf
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			} // end if
			if(isLeftChild){
				parent.left = null;
			}else{
				parent.right = null;
			} // end if
		} else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		} else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//get minimum element in the right sub tree
			Node child = removeHelper(current);
			if(current==root){
				root = child;
			}else if(isLeftChild){
				parent.left = child;
			}else{
				parent.right = child;
			}			
			child.left = current.left;
		}		
		return true;		
	}
	/*
	 * Helper function for remove method to find the minimal element in the sub-tree	
	 */
	private Node removeHelper(Node n){
		Node child = null;
		Node Parent = null;
		Node current = n.right;
		// find the most left node
		while(current!=null){
			Parent = child;
			child = current;
			current = current.left;
		}
		//if child has the right child, add it to the left of Parent.
		if(child!=n.right){
			Parent.left = child.right;
			child.right = n.right;
		}
		return child;
	}
	/*
	 * Insert element into the tree
	 * @param id - element to insert
	 */
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	/*
	 * Helper function to test
	 */
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
}
