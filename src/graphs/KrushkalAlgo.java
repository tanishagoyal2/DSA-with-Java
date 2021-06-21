package graphs;

import java.util.Arrays;

public class KrushkalAlgo {
	
	int V,E;
	Edge edge[];
	class Edge implements Comparable<Edge>{
		int src,des,weight;
		public int compareTo(Edge e) {
			return this.weight-e.weight;
		}
	}

	KrushkalAlgo(int v,int e){
		this.V=v;
		this.E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	
	//all the vertices will have their parent node and rank;
	class Subset{
		int parent;
		int rank;
	}
	
	public int find(Subset subset[],int x) {
		if(subset[x].parent==x) {
			return subset[x].parent;
		}
		return find(subset,subset[x].parent);
	}
	
	public void union(Subset subset[],int x,int y) {
		int xroot=find(subset,x);
		int yroot=find(subset,y);
		if(subset[xroot].rank<subset[yroot].rank) {
			subset[xroot].parent=yroot;
		}
		else if(subset[xroot].rank>subset[yroot].rank) {
			subset[yroot].parent=xroot;
		}
		else {
			subset[xroot].parent=yroot;
			subset[yroot].rank++;
		}
	}
	
	public void krushkalMST() {
		Edge result[]=new Edge[V];
		
		Subset subset[]=new Subset[V];
		
		for(int i=0;i<V;i++) {
			subset[i]=new Subset();
			subset[i].parent=i;
			subset[i].rank=0;
			result[i]=new Edge();
		}
		int k=0;
		//sorting the edge according to their weight;
		Arrays.sort(edge);
		// for loop for v-1 times;
		for(int i=0;i<E;i++) {
			int x=find(subset,edge[i].src);
			int y=find(subset,edge[i].des);
			if(x!=y) {
				result[k++]=edge[i];
				union(subset,x,y);
			}
		}
		System.out.println("Following are the edges in "+ "the constructed MST");
		int minimumCost = 0;
		for (int i = 0; i < k; ++i)
		{
			System.out.println(result[i].src + " -- "
						+ result[i].des
						+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "
					+ minimumCost);
		
	}
	
	public static void main(String args[]) {
		KrushkalAlgo graph=new KrushkalAlgo(4,5);
		graph.edge[0].src=0;
		graph.edge[0].des=1;
		graph.edge[0].weight=10;
		
		graph.edge[1].src=0;
		graph.edge[1].des=2;
		graph.edge[1].weight=6;
		
		graph.edge[2].src=0;
		graph.edge[2].des=3;
		graph.edge[2].weight=5;
		
		graph.edge[3].src=1;
		graph.edge[3].des=3;
		graph.edge[3].weight=15;
		
		graph.edge[4].src=2;
		graph.edge[4].des=3;
		graph.edge[4].weight=4;
		graph.krushkalMST();
	}
}
