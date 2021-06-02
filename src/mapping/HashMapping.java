package mapping;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.*;


public class HashMapping {
	
	Node root;
	
	class Node{
		int data;
		Node left,right;
		Node(int d){
			data=d;
			left=null;
			right=null;
		}
	}
	
	public void insertion(int d) {
		Node node=new Node(d);
		Node head=root;
		if(head==null) {
			root=node;
		}
		else {
			Node par=null;
			while(head!=null) {
				par=head;
				if(d<head.data) {
					head=head.left;
				}
				else {
					head=head.right;
				}
			}
			
			if(par.data>d) {
				par.left=node;
			}
			else {
				par.right=node;
			}
		}
	}
	
	public void verticalTree(Node start,int depth,TreeMap<Integer,Vector<Integer>> tm) {
		Vector <Integer> ver=tm.get(depth);
		
		if(start==null)
			return;
		
		if(ver==null) {
			ver=new Vector<Integer>();
			ver.add(start.data);
		}
		else {
			ver.add(start.data);
		}
		tm.put(depth, ver);
		
		verticalTree(start.left,depth-1,tm);
		verticalTree(start.right,depth+1,tm);
	}
	
	public static void main(String []args) {
		TreeMap <Integer,Vector<Integer>> tm=new TreeMap<Integer,Vector<Integer>>();
		Scanner sc=new Scanner(System.in);
		HashMapping hm=new HashMapping();
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			hm.insertion(sc.nextInt());
		}
		hm.verticalTree(hm.root, 0, tm);
		for(Map.Entry<Integer,Vector<Integer>> mp:tm.entrySet()) {
			System.out.println(mp.getKey()+"   "+mp.getValue());
		}
		
		sc.close();
	}
}
