package binary_tree;

import java.util.Scanner;

public class AVL {
    AVLNode root;

    //function to insert a node in avl tree
    public AVLNode insert(AVLNode node,int key){
        if (node == null)
        return (new AVLNode(key));

    if (key < node.data)
        node.left = insert(node.left, key);
    else if (key > node.data)
        node.right = insert(node.right, key);
    else // Duplicate keys not allowed
        return node;

    /* 2. Update height of this ancestor node */
    node.height = 1 + Math.max(Height(node.left),
                          Height(node.right));

    /* 3. Get the balance factor of this ancestor
          node to check whether this node became
          unbalanced */
    int balance = Height(node.left)-Height(node.right);

    // If this node becomes unbalanced, then there
    // are 4 cases Left Left Case
    if (balance > 1 && key < node.left.data)
        return LLRotation(node);

    // Right Right Case
    if (balance < -1 && key > node.right.data)
        return RRRotation(node);

    // Left Right Case
    if (balance > 1 && key > node.left.data) {
        return LRRotation(node);
    }

    // Right Left Case
    if (balance < -1 && key < node.right.data) {
        return RLRotation(node);
    }

    /* return the (unchanged) node pointer */
    return node;

    }

    //function to calculate the height factor of a node

    public int Height(AVLNode node){
        if(node==null){
            System.out.println("left is null ");
            return 0;
        }
        return node.height;

    }

    //LL ROTATION
    public AVLNode LLRotation(AVLNode node){
        AVLNode x=node.left;
        node.left=x.right;
        x.right=node;
        x.height=Math.max(Height(x.left), Height(x.right))+1;
        node.height=Math.max(Height(node.left), Height(node.right))+1;
        return x;
    }

    //RR ROTATION 
    public AVLNode RRRotation(AVLNode node){
        AVLNode x=node.right;
        node.right=x.left;
        x.left=node;
        x.height=Math.max(Height(x.left), Height(x.right))+1;
        node.height=Math.max(Height(node.left), Height(node.right))+1;
        return x;
    }
    //LR Rotation
    public AVLNode LRRotation(AVLNode node){
        node.left=RRRotation(node.left);
        return LLRotation(node);
    }
    //RL ROTATION
    public AVLNode RLRotation(AVLNode node){
        node.right=LLRotation(node.right);
        return RRRotation(node);
    }

    public void printpreorder( AVLNode start) {
		if(start==null) {
			return;
		}
		
		System.out.print(start.data+"  ");
		printpreorder(start.left);
		printpreorder(start.right);
	}
    
    //main function to run the program
    public static void main(String args[]){
        AVL avl=new AVL();
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			int m=sc.nextInt();
			AVL ob=new AVL();
            AVLNode root=ob.root;
			for(int j=0;j<m;j++){
                int ele=Integer.parseInt(sc.next().split(" ")[0]);
                System.out.println(ele);
                root=ob.insert(root,ele);
			}
            ob.printpreorder(root);
		}
    }
    
}
//class to store the node data and its height value;
class AVLNode{
    int data;
    int height;
    AVLNode left,right;
    AVLNode(int d){
        data=d;
        height=0;
        left=null;
        right=null;
    }
}