package linkedList;
import java.util.*;
public class LinkedListClass {
	Node head;
	public class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	public void push(int d) {
		Node newNode=new Node(d);
		newNode.next=head;
		head=newNode;
	}
	
	public void insertAfter(Node prevNode,int d) {
		if(prevNode==null) {
			System.out.println("node provided cant be null");
			return;
		}
		Node newNode=new Node(d);
		newNode.next=prevNode.next;
		prevNode.next=newNode;
	}
	
	public void append(int d) {
		Node newNode=new Node(d);
		if(head==null) {
			head=new Node(d);
			return;
		}
		Node node=head;
		while(node.next!=null) {
			node=node.next;
		}
		node.next=newNode;
		return ;
	}
	
	public void printNode() {
		Node node=head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	public void delete(int d) {
		Node node=head;
		if(node.data==d) {
			head=node.next;
			return;
		}
		while(node!=null) {
			if(node.next.data==d) {
				System.out.println("deleted element");
				node.next=node.next.next;
				return;
			}
			node=node.next;
		}
	}
	
	public void length() {
		Node node=head;
		int length=0;
		while(node!=null) {
			length++;
			node=node.next;
		}
		System.out.println(length);
	}
	
	public void swapNode(int x,int y) {
		Node prevx=null,currx,curry,prevy=null;
		currx=head;
		curry=head;
		while(currx!=null && currx.data!=x) {
			prevx=currx;
			currx=currx.next;
		}
		while(curry!=null && curry.data!=y) {
			prevy=curry;
			curry=curry.next;
		}
		if(currx==null||curry==null) {
			return ;
		}
		if(prevx!=null) {
			prevx.next=curry;
		}
		else
			head=curry;
		if(prevy!=null) {
			prevy.next=currx;
		}
		else
			head=currx;
		Node temp=currx.next;
		currx.next=curry.next;
		curry.next=temp;
	}
	
	public void reverse() {
		Node curr=head,prev=null,next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	
	public void merge(Node a,Node b) {
		Node tail=null;
		while(a!=null && b!=null) {
			if(a.data>=b.data) {
				if(tail==null) {
					tail=b;
					head=tail;
				}	
				else {
					tail.next=b;
					tail=tail.next;
				}
				b=b.next;
				
			}
			else {
				if(tail==null) {
					tail=a;
					head=tail;
				}
				else {
					tail.next=a;
					tail=tail.next;
				}
				a=a.next;
			}
		}
		if(a==null) {
			if(tail==null) {
				tail=b;
				head=tail;
			}
			else
				tail.next=b;
		}
		else {
			if(tail==null) {
				tail=a;
				head=tail;
			}
			else
				tail.next=a;
		
		}
	}
	
	public void detectloop() {
		Node node=head;
		HashSet<Node> h=new HashSet<Node>();
		while(node!=null) {
			if(h.contains(node)) {
				System.out.println("loop detected");
				node.next=null;
				detectloop();
				return;
			}
			h.add(node);
			node=node.next;
		}
		System.out.println("loop not found or deleted");
	}
	
	public void addTwoNos(Node a,Node b) {
		int carry=0;
		int sum=0;
		Node temp=null,node=null;
		while(a!=null || b!=null) {
			sum=carry+(a!=null?a.data:0)+(b!=null?b.data:0);
			carry=sum>=10?1:0;
			sum=sum%10;
			node=new Node(sum);
			if(head==null)
			{	
				head=node;
				temp=node;
			}
			else {
				temp.next=node;
				temp=temp.next;
				}
			
			if(a!=null)
				a=a.next;
			if(b!=null)
				b=b.next;	
		}
		if(carry>0)
			temp.next=new Node(carry);
	}
	public void remove_duplicate() {

		// write your code here
		HashMap<Integer,Node> hm=new HashMap<Integer,Node>();
		Node curr=head;
		Node prev=head;
		while(curr!=null){
			if(hm.containsKey(curr.data)){
				System.out.println("duplicate "+curr.data);
				prev.next=curr.next;
				curr=curr.next;
				continue;
			}
			else{
				System.out.println(curr.data+" added");
				hm.put(curr.data,curr);
			}
			prev=curr;
			curr=curr.next;
		}
	}
	
	//segregate the odd and even nodes;
	public static Node oddEven(Node head){
		LinkedListClass odd=new LinkedListClass();
		LinkedListClass even=new LinkedListClass();
		Node curr=head;
		while(curr!=null){
			if(curr.data%2==0){
				even.append(curr.data);
			}
			else{
				odd.append(curr.data);
			}
		}
		Node last=odd.head;
		while(last.next!=null){
			last=last.next;
		}
		last.next=even.head;
		return odd.head;
	}
	public static void main(String [] args) {
		LinkedListClass list1=new LinkedListClass();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			list1.append(sc.nextInt());
		}
		list1.remove_duplicate();
		list1.printNode();
		sc.close();
	}
}
