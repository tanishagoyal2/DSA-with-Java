package heaps;

import java.util.*;
import java.util.PriorityQueue;

public class priorityQueue {

	//min heap using priority queue
	public void minHeap() {
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(30);
		pq.add(40);
		pq.add(20);
		
		printElements(pq);
		
		int peek=pq.peek();
		System.out.println("peek is "+peek);
		pq.poll();
		
		printElements(pq);
	}
	
	
	//max heap using priority queue
	public void maxHeap() {
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(10);
		pq.add(30);
		pq.add(20);
		pq.add(40);
		
		printElements(pq);
		
		int peek=pq.peek();
		System.out.println("peek is "+peek);
		pq.poll();
		
		printElements(pq);
	}
	
	
	public void printElements(PriorityQueue<Integer> pq) {
		Iterator<Integer> it=pq.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	public static void main(String args[]) {
		
		priorityQueue p=new priorityQueue();
		p.maxHeap();
		
		
		p.minHeap();
	}
}
