package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}


public class BinaryTree {
	Node root;
	int max =Integer.MAX_VALUE;
	BinaryTree(){
		root=null;
	}
	
	public void printLevelOrder(Node node) {
		int height=heightOfTree(node);
		for(int i=0;i<height-1;i++) {
			printLevelNodes(node,i);
		}
		System.out.println("minimum is "+this.max);
	}
	
	public void printLevelNodes(Node node,int level) {
		if(level==0) {
			if(this.max>node.data)
				this.max=node.data;
			System.out.println(this.max);
			System.out.println(node.data);
		}
		else if(node==null) {
			return ; 
		}
		else {
			printLevelNodes(node.left,level-1);
			printLevelNodes(node.right,level-1);
		}
	}
	
	public int heightOfTree(Node node) {
		if(node==null) {
			return 0;
		}
		else {
			int lheight=heightOfTree(node.left);
			int rheight=heightOfTree(node.right);
			if(lheight>rheight) {
			return lheight+1;		
			}
			else {
				return rheight+1;
			}
		}
	}
	
	public void insert(int data) {
		Node node=new Node(data);
		Node start=root;
		if(start==null) {
			root=node;
		}
		else {
			Node nodeptr=root,parentptr=null;
			while(nodeptr!=null) {
				parentptr=nodeptr;
				if(nodeptr.data<data) {
					nodeptr=nodeptr.right;
				}
				else {
					nodeptr=nodeptr.left;
				}
			}
			if(parentptr.data<data) {
				parentptr.right=node;
			}
			else {
				parentptr.left=node;
			}
		}
		System.out.println("Node inserted");
	}

	public void deleteNode(Node node,int key){
		Node curr=node;
		Node parent=null;
		while(curr!=null && curr.data!=key){
			parent=curr;
			if(curr.data<key){
				curr=curr.right;
			}
			else{
				curr=curr.left;
			}
		}
		//if node to be deleted is the leaf node
		if(curr.left==null && curr.right==null){
			if(parent.left==curr){
				parent.left=null;
			}
			else{
				parent.right=null;
			}
		}
		else if(curr.left!=null && curr.right!=null){
			//find the inorder successor
			Node successor=getMinimumKey(curr);
			int val=successor.data;
			//delete the successor node
			deleteNode(root,successor.data );
			//replace it with the deleting node
			curr.data=val;
		}
		else{
			Node child=curr.left!=null?curr.left:curr.right;
			if(curr!=root){
				if(curr==parent.left){
					parent.left=child;
				}
				else{
					parent.right=child;
				}
			}
			else{
				root=child;
			}
		}
		System.out.println("deletion completed");
	}
	
	public static Node getMinimumKey(Node curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
	
	public void printinorder(Node start) {
		if(start==null) {
			return;
		}
		else {
			printinorder(start.left);
			System.out.print(start.data);
			printinorder(start.right);
		}
	}
	
	public void printpostorder(Node start) {
		if(start==null) {
			return;
		}
		
		printpostorder(start.left);
		printpostorder(start.right);
		System.out.print(start.data);
	}
	
	public void printpreorder(Node start) {
		if(start==null) {
			return;
		}
		
		System.out.print(start.data+"  ");
		printpreorder(start.left);
		printpreorder(start.right);
	}
	
	public DiaPair diameter(Node node) {
		if(node==null) {
			DiaPair bp=new DiaPair();
			bp.h=-1;
			bp.dia=0;
			return bp;
		}
		
		DiaPair lp=diameter(node.left);
		DiaPair rp=diameter(node.right);
		
		DiaPair mp=new DiaPair();
		mp.h=Math.max(lp.h, rp.h)+1;
		mp.dia=Math.max(lp.h+rp.h+2,Math.max(lp.dia, rp.dia));
		return mp;	
	}
	
	public int DiameterOfTree(Node node,Height height) {
		if(node==null) {
			height.h=0;
			return 0;
		}
		Height lh=new Height();
		Height rh=new Height();
		int ldiameter=DiameterOfTree(node.left,lh);
		int rdiameter=DiameterOfTree(node.right,rh);
		height.h=Math.max(lh.h,rh.h)+1;
		return Math.max(lh.h+rh.h+1, Math.max(ldiameter, rdiameter));
	}
	
	public int Diameter(Node node) {
		if(node==null)
			return 1;
		int len1=heightOfTree(node.left)+heightOfTree(node.right)+1;
		int len2=Math.max(Diameter(node.left), Diameter(node.right));
		return Math.max(len1, len2);
		
	}
	
	public void printkdistance(Node root,int k) {
		if(root==null) {
			return;
		}
		
		if(k==0) {
			System.out.println("dataa is "+root.data);
			return;
		}
		printkdistance(root.left,k-1);
		printkdistance(root.right,k-1);
		
	}
	
	public boolean printancestors(Node node,int target){
		if(node==null)
			return false;
		if(node.data==target)
			return true;
		if(printancestors(node.left, target)||printancestors(node.right,target)) {
			System.out.println(node.data);
			return true;
		}
		else
			return false;
	}	
	
	int count =0;
	public void countleaves(Node node) {
		if(node==null)
			return;
		if(node.left==null && node.right==null) {
			count++;
			System.out.println("leaf is "+node.data);
		}
		else {
			countleaves(node.left);
			countleaves(node.right);
		}
	}
	
	public void topView(Node root)
    {
       class OBJ{
           int hd;
           Node node;
           OBJ(Node node,int h){
               this.hd=h;
               this.node=node;
           }
       }
       HashMap<Integer,Node> hm=new HashMap<Integer,Node>();
       Queue<OBJ> queue=new LinkedList<OBJ>();
       if (root == null) {
            return;
        }
        else {
            queue.add(new OBJ(root, 0));
        }
        
        while(!queue.isEmpty()){
            OBJ top=queue.poll();
            if(!hm.containsKey(top.hd)){
                hm.put(top.hd,top.node);
            }
            if(top.node.left!=null){
				System.out.println("tleft added "+top.node.left.data);
                queue.add(new OBJ(top.node.left,top.hd-1));
            }
            if(top.node.right!=null){
				System.out.println("right added "+top.node.right.data);
                queue.add(new OBJ(top.node.right,top.hd+1));
            }
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(HashMap.Entry<Integer, Node> entry :hm.entrySet()){
            System.out.print(entry.getValue().data);
        }
    }
	
	public void bottomView(Node root)
    {
       class OBJ{
           int hd;
           Node node;
           OBJ(Node node,int h){
               this.hd=h;
               this.node=node;
           }
       }
       HashMap<Integer,Node> hm=new HashMap<Integer,Node>();
       Queue<OBJ> queue=new LinkedList<OBJ>();
       if (root == null) {
            return;
        }
        else {
            queue.add(new OBJ(root, 0));
        }
        
        while(!queue.isEmpty()){
            OBJ top=queue.poll();
            hm.put(top.hd,top.node);
            if(top.node.left!=null){
				System.out.println("tleft added "+top.node.left.data);
                queue.add(new OBJ(top.node.left,top.hd-1));
            }
            if(top.node.right!=null){
				System.out.println("right added "+top.node.right.data);
                queue.add(new OBJ(top.node.right,top.hd+1));
            }
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(HashMap.Entry<Integer, Node> entry :hm.entrySet()){
            System.out.print(entry.getValue().data);
        }
    }
	
	
	public static void main(String []args) {
		BinaryTree tree=new BinaryTree();
		tree.root= new Node(10);
	    tree.root.left= new Node(4);
	    tree.root.right= new Node(30);
	    tree.root.left.left= new Node(2);
	    tree.root.left.right= new Node(5);
	    tree.root.right.left= new Node(11);
	    tree.root.right.right= new Node(12);
	    System.out.println("Level order traversal of binary tree is ");
		tree.topView(tree.root);
	}
}
class DiaPair{
	int h;
	int dia;
}

class Height{
	int h;
}