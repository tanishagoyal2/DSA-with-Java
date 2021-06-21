import java.util.*;
public class FillNextSiblings {

	Node root;	
	FillNextSiblings(){
		this.root=null;
	}
	
	public void setNextSibling(Node prev,Node next) {
		prev.nextSibling=next;
	}
	
	public void fillNextSiblings(Node root) {
		if(root==null)
			return ;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			if(temp!=null) {
				setNextSibling(temp,queue.peek());
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			else {
				if(!queue.isEmpty())
					queue.add(null);
			}
		}
	}
	
	public static void main(String args[]) {
	
		
		
		FillNextSiblings bst=new FillNextSiblings();
		bst.root=new Node(1);
		bst.root.left=new Node(2);
		bst.root.right=new Node(3);
		bst.root.left.left=new Node(4);
		bst.root.left.right=new Node(5);
		bst.root.right.left=new Node(6);
		bst.root.right.right=new Node(7);
	}
}
class Node{
	Node left;
	Node right;
	Node nextSibling;
	int data;
	Node(int d){
		this.data=d;
	}
}