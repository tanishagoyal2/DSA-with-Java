package doubleLinkedList;

import java.util.*;

public class DoublelinkedList {
	Node head;
	
	class Node{
		int data;
		Node prev;
		Node next;
		Node(int d){
			data=d;
		}
	}
	
	public void push(int d) {
		Node node =new Node(d);
		if(head==null) {
			head=node;
		}
		else {
			node.next=head;
			node.prev=null;
			head.prev=node;
			head=node;
		}
			
	}
	
	public void insertAfter(int ele,int d) {
		Node start=head,temp;
		Node node=new Node(d);
		while(start!=null) {
			if(start.data==ele) {
				temp=start.next;
				start.next=node;
				node.prev=start;
				node.next=temp;
				temp.prev=node;
				return;
			}
			start=start.next;
		}
		System.out.println("node is not found");
		return;
	}
	
	public void append(int d) {
		Node node=head;
		Node new_node=new Node(d);
		if(head==null) {
			head=new_node;
			return;
		}
		while(node.next!=null) {
			node=node.next;
		}
		new_node.prev=node;
		node.next=new_node;
	}
	
	public void printNode() {
		Node node=head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	public void delete(int d) {
		Node pointer=head;
		if(head==null) {
			System.out.println("list is empty");
			return;
		}
		if(head.data==d) {
			head=pointer.next;
			pointer.next=null;
			head.prev=null;
			return;
		}
		else {
			while(pointer!=null) {
				if(pointer.next.data==d) {
					Node temp=pointer.next.next;
					pointer.next=pointer.next.next;
					temp.prev=pointer;
					return;
				}
				pointer=pointer.next;
			}
		}
		System.out.println("node not found");
		return;
	}
	
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		DoublelinkedList dl=new DoublelinkedList();
		for(int i=0;i<n;i++) {
			dl.append(sc.nextInt());
		}
		dl.printNode();
		System.out.println("enter an element to be deleted");
		int ele=sc.nextInt();
		dl.delete(ele);
		dl.printNode();
		sc.close();
	}
}
