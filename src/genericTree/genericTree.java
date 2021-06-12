package genericTree;

import java.util.LinkedList;
import java.util.Stack;

public class genericTree {
    Node root;
    
    public void insert(int i,int parent,int arr[]){
        Node new_node=new Node(i);
        if(parent==-1){
            root=new_node;
        }
        else{
            Node curr=root;
            Stack<Integer> st=new Stack<Integer>();
            st.add(-1);
            int j=arr[i];
            while(j!=0){
                st.push(j);
                j=arr[j];
            }
            int top=st.pop();
            while(top!=-1){
                System.out.println("for inserting "+i +"top lement is "+top);
                if( curr.left !=null && curr.left.data==top){
                    curr=curr.left;
                }
                else if(curr.right!=null){
                    curr=curr.right;
                }
                top=st.pop();
            }
            if(curr.left==null){
                curr.left=new_node;
                System.out.print(" to the left of "+curr.data);
            }
            else{
                System.out.print(" to the right "+curr.data);
                curr.right=new_node;
            }
        }
    }
    public void preorderTraversal(Node node){
        if(node==null){
            return ;
        }
        System.out.println(node.data);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    public void printLevelOrder(Node node) {
		int height=heightOfTree(node);
		for(int i=0;i<height-1;i++) {
			printLevelNodes(node,i);
		}
	}
	
	public void printLevelNodes(Node node,int level) {
		if(level==0) {
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
    public static void main(String args[]){
        genericTree gt=new genericTree();
        int arr[]={-1,0,0,1,1,3,5};
        int n=7;
        for(int i=0;i<n;i++){
            gt.insert(i,arr[i],arr);
            System.out.println(i+" inserted");
        }
        gt.preorderTraversal(gt.root);

    }
    
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        this.data=d;
    }
}
