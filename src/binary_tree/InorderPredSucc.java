package binary_tree;


public class InorderPredSucc {

	Node root;
	
	
	Node Pred,Succ;
	public void inorderPredSucc(Node node,int key) {
		if(node==null)
			return;
		if(node.data==key) {
			if(node.left!=null) {
				Node temp=node.left;
				while(temp.right!=null) {
					temp=temp.right;
				}
				Pred=temp;
			}
			if(node.right!=null) {
				Node temp=node.left;
				while(temp.left!=null) {
					temp=temp.left;
				}
				Succ=temp;
			}
		}
		else {
			if(node.data>key) {
				Succ=node;
				inorderPredSucc(node.left,key);
			}
			else {
				Pred=node;
				inorderPredSucc(node.right,key);
			}
		}			
	}
	
	public static void main(String args[]) {
		InorderPredSucc bst=new InorderPredSucc();
		bst.root=new Node(50);
		bst.root.left=new Node(30);
		bst.root.right=new Node(70);
		bst.root.left.left=new Node(20);
		bst.root.left.right=new Node(40);
		bst.root.right.left=new Node(60);
		bst.root.right.right=new Node(80);
		
		bst.inorderPredSucc(bst.root, 65);
		if(bst.Succ!=null) {
			System.out.println("successor is "+bst.Succ.data);
		}
		else {
			System.out.println("no successor found");
		}
		
		if(bst.Pred!=null) {
			System.out.println("successor is "+bst.Pred.data);
		}
		else {
			System.out.println("no successor found");
		}
	}
}

  class Node{ int data; Node left; Node right; Node(int d){ this.data=d; } }
 