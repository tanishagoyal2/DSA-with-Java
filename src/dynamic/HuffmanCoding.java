package dynamic;
import java.util.*;
public class HuffmanCoding {

	
	HuffmanNode root;
	public void printCode(HuffmanNode root,String c) {
		if(root.left==null && root.right==null && Character.isLetter(root.c)) {
			System.out.println("for chracter "+root.c+" code is "+c);
			return ;
		}
		printCode(root.left,c+"0");
		printCode(root.right,c+"1");
		
	}
	
	
	public void decoding(String s) {
		int len=s.length();
		String decoded="";
		HuffmanNode curr=root;
		for(int i=0;i<len;i++) {
			if(s.charAt(i)=='0') {
				curr=curr.left;
			}
			else {
				curr=curr.right;
			}
			if(curr.left==null && curr.right==null ) {
				decoded+=curr.c;
				System.out.println(decoded);
				curr=root;
			}
		}
	}
	
	public void encoding(int freq[],char ch[],int n) {
		PriorityQueue<HuffmanNode> heap=new PriorityQueue<HuffmanNode>(n,new MyComparator());
		for(int i=0;i<n;i++) {
			HuffmanNode node=new HuffmanNode(freq[i],ch[i]);
			heap.add(node);
		}
		while(heap.size()>1) {
			HuffmanNode first=heap.poll();
			HuffmanNode second=heap.poll();
			int data=first.freq+second.freq;
			char character='-';
			HuffmanNode new_node=new HuffmanNode(data,character);
			new_node.left=first;
			new_node.right=second;
			heap.add(new_node);
			root=new_node;
			
		}
		
		printCode(root,"");

	}
	public static void main(String []args) {
		HuffmanCoding hf=new HuffmanCoding();
		int n=6;
		int freq[]= {5,9,12,13,16,45};
		char c[]= {'a','b','c','d','e','f'};		
		hf.encoding(freq,c,n);
		hf.decoding("111101100011001101");
	}
}

class MyComparator implements Comparator<HuffmanNode>{
	public int compare(HuffmanNode x,HuffmanNode y) {
		return x.freq-y.freq;
	}
}
class HuffmanNode{
	int freq;
	char c;
	HuffmanNode left;
	HuffmanNode right;
	HuffmanNode(int freq,char c){
		this.freq=freq;
		this.c=c;
		this.left=null;
		this.right=null;
	}
}