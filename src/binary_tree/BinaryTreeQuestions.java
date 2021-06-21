package binary_tree;

import java.util.*;

public class BinaryTreeQuestions {
	Node root;
	Stack<Integer> st;
	int count=0;
	
	public int height(Node node) {
		if(node==null)
			return 0;
		int lheight=height(node.left);
		int rheight=height(node.right);
		
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	
	public int traverselevel(Node node) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<height(node);i++) {
			int count=widthsum(node,i);
			System.out.println(i +"level contains "+count);
			if(max<count) {
				max=count;
			}
		}
		return max;
	}
	
	
	public int printlevelnodes(Node node,int level) {
		if(node==null)
			return 0;
		if(level==0) {
			System.out.println(node.data);
			return 1;
			}
		return printlevelnodes(node.left,level-1)+printlevelnodes(node.right,level-1);
	
			
	}
	
	
	public int widthsum(Node node,int level) {
		if(node==null)
			return 0;
		if(level==0) {
			System.out.println(node.data);
			return node.data;
		}
		return widthsum(node.left,level-1)+widthsum(node.right,level-1);
	}
	
	public void mirrorTree(Node node) {
		if(node==null)
			return;
		Node temp=node.left;
		node.left=node.right;
		node.right=temp;
		mirrorTree(node.left);
		mirrorTree(node.right);
	}
	
	public void printzigzagElements(Node node) {
		int h=height(node);
		for(int i=0;i<h;i++) {
			this.st=new Stack<Integer>();
			getlevelnodes(node,i,this.st);
			if(i%2==0) {
				while(!st.isEmpty())
					System.out.println(st.pop());
			}
			else {
				System.out.println(st);
			}
		}
	}
	
	public void getlevelnodes(Node node,int level,Stack<Integer> st) {
		if(node==null)
			return;
		if(level==0)
			this.st.add(node.data);
		getlevelnodes(node.left,level-1,this.st);
		getlevelnodes(node.right,level-1,this.st);
		
	}
	
	// it takes less time as compared to above method
	
	public void printlevel(Node node) {
		Stack<Node> S = new Stack<Node>();
        Queue<Node> Q = new LinkedList();
        Q.add(node);
   
        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false) 
        {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);
   
            /* Enqueue right child */
            if (node.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.right); 
                  
            /* Enqueue left child */
            if (node.left != null)
                Q.add(node.left);
        }
   
        // Now pop all items from stack one by one and print them
        while (!S.isEmpty()) 
        {
            node = S.peek();
            System.out.print(node.data + " ");
            S.pop();
        }
   
	}
	
	//optimized width sum
	
	public void width_sum(Node node) {
		Queue<Node> q=new LinkedList<Node>();
		int currentsum=0;int maxsum=0;
		if(node==null)
			return ;
		
		
		q.add(node);
		q.add(null);
		while(!q.isEmpty()) {
			node=q.poll();
			if(node!=null) {
				currentsum+=node.data;
			System.out.println(currentsum);
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
			}
			else {
				if(currentsum>maxsum)
					maxsum=currentsum;
				currentsum=0;
				if(!q.isEmpty()) {
					q.add(null);
				}
				
			}
			
		}
		
	}
	public static void main(String []args) {
		BinaryTreeQuestions tree=new BinaryTreeQuestions();
		
		//    	   1
		//  	 /  \
		//	    2    3
		//     / \   \
		//    4  5     8
		//            / \
		//           6   7
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left=new Node(10);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
  
        System.out.println("Maximum width is ");
        tree.width_sum(tree.root);
	}
	
}