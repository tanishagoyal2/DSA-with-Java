package binary_tree;

public class ThreadedBinaryTree {

	Node root;
	class Node{
		int data;
		Node left,right;
		boolean rightThread,leftThread;
		
		Node(int d){
			data=d;
			left=null;right=null;
		}
	}
	
	public void insert(int d) {
		Node start=root;
		Node par=null;
		Node node=new Node(d);
		while(start!=null) {
			par=start;
			if(d<start.data) {
				if(start.leftThread==false) {
					start=start.left;
				}
				else
					break;
			}
			else {
				if(start.rightThread==false) {
					start=start.right;
				}
				else
					break;
			}
		}
		
		if(par==null) {
			root=node;
			node.left=null;
			node.right=null;
		}
		else if(d<par.data) {
			node.left=par.left;
			node.right=par;
			par.left=node;
			par.leftThread=false;
		}
		else {
			node.right=par.right;
			node.left=par;
			par.right=node;
			par.rightThread=false;
		}
	}
	
	
}
