package hashing;


import java.util.HashMap;
import java.util.Scanner;

public class Hashing {

	public void unionAndIntersection(Node root1,Node root2) {
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		LinkedList union =new LinkedList();
		LinkedList intersection= new LinkedList();
		while(root1!=null || root2!=null) {
			if(root1!=null) {
				if(!h.containsKey(root1.data)) {
					h.put(root1.data,1 );
					union.insertElement(root1.data);
					
				}
				else if(h.get(root1.data)==1) {
					intersection.insertElement(root1.data);
					h.put(root1.data,h.get(root1.data)+1);
				}
				root1=root1.next;
			}
			if(root2!=null) {
				if(!h.containsKey(root2.data)) {
					h.put(root2.data,1 );
					union.insertElement(root2.data);
				}
				else if(h.get(root2.data)==1) {
					intersection.insertElement(root2.data);
					h.put(root2.data, h.get(root2.data)+1);
				}
				root2=root2.next;
			}
		}
		System.out.println("union is");
		union.printElements();
		System.out.println("intersection is");
		intersection.printElements();
		
	}
	//print union and intersection of linked list
	
	
	public static void main(String []args) {
		Hashing h=new Hashing();
		Scanner sc=new Scanner(System.in);
		int list[]= {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
		h.maxDistance(list);
		
	}
	
	//this method checks if the required sum is possible from two nos in array int O(n) time
	public void chechSum(int list[],int sum) {
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		for(int i=0;i<list.length;i++) {
			if(h.containsKey(sum-list[i])) {
				System.out.println("sum is found with "+(sum-list[i])+"  "+list[i]);
			}
			else {
				h.put(list[i], list[i]);
			}
		}
		
	}
	
	class sumclass{
		int index;
		int maxdist;
		sumclass(int i){
			index=i;
			maxdist=i;
		}
	}
	// program to find maximum distances between two occurances
	public void maxDistance(int list[]) {
		HashMap<Integer,sumclass> h=new HashMap<Integer,sumclass>();
		int n=list.length;
		for(int i=0;i<n;i++) {
			if(!h.containsKey(list[i])) {
				h.put(list[i],new sumclass(i));
			}
			else {
				sumclass s=h.get(list[i]);
				int max=Math.max(s.maxdist, i-s.index);
				System.out.println("maximum for "+list[i]+"  "+max);
				h.get(list[i]).maxdist=max;
			}
		}
	}
}

class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}

class LinkedList{
	public Node head;
	
	public Node getNode() {
		return head;
	}
	public void insertElement(int data) {
		Node new_node=new Node(data);
		if(head==null) {
			head=new_node;
		}
		else {
			Node node=head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next=new_node;
		}
	}
	public void printElements() {
		Node current=head;
		if(current==null)
			return;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	
}