package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {

	int n;
	Items items[];
	int pos=0;
	int capacity;
	KnapsackProblem(int n,int c){
		this.n=n;
		items=new Items[n];
		this.capacity=c;
	}
	
	public void addItem(int w,int v) {
		items[pos++]=new Items(w,v);
	}
	
	public void fracknapsack() {
		int output=0;
		Arrays.sort(items,new Mycom());
		for(int i=0;i<n;i++) {
			if(items[i].weight<=capacity) {
				capacity-=items[i].weight;
				output+=items[i].value;
			}
			else {
				output+=items[i].value*((double)capacity/items[i].weight);
				capacity-=(capacity/items[i].weight)*100;
				break;
			}
		}
		System.out.println(output);
	}
	
	public static void main(String []args) {
		KnapsackProblem kp=new KnapsackProblem(4,50);
		kp.addItem(10,60);
		kp.addItem(40,40);
		kp.addItem(20,100);
		kp.addItem(30,120);
		kp.fracknapsack();
	}
}

class Mycom implements Comparator<Items>{
	public int compare(Items a,Items b) {
		return a.weight*b.value-a.value*b.weight;
	}
}

class Items{
	int weight;
	int value;
	Items(int w,int v){
		this.weight=w;
		this.value=v;
	}
}