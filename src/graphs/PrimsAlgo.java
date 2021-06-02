package graphs;

public class PrimsAlgo {
	int V,E;
	Edge edge[];
	
	PrimsAlgo(int v,int e){
		this.V=v;
		this.E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	
	class Edge{
		int src,des,weight;
		Edge(){
			src=des=weight;
		}
	}
	class Subset{
		int parent;
		int value;
	}
	
	public int minKey(int key[],boolean mst[]) {
		int r=Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<V;i++) {
			if(!mst[i] && key[i]<r) {
				r=key[i];
				index=i;
			}
		}
		return index;
	}
	
	public void primMST(int s,int graph[][]) {
		int parent[]=new int[V];
		int key[]=new int [V];
		boolean mst[]=new boolean[V];
		for(int i=0;i<V;i++) {
			key[i]=Integer.MAX_VALUE;
			mst[i]=false;
		}
		key[s]=0;
		parent[s]=-1;
		System.out.println("perfecly worked fine");
		for(int i=0;i<V-1;i++) {
			//extract the min value node
			int u=minKey(key,mst);
			// mark it as visited
			mst[u]=true;
			//for every its adjacent edge check its value
			for(int v=0;v<V;v++) {
				if(graph[u][v]!=0 && mst[v]==false && graph[u][v]<key[v]) {
					parent[v]=u;
					key[v]=graph[u][v];
				}
			}
		}
		printMST(parent,graph);
	}
	
	public void printMST(int parent[],int graph[][]) {
		for(int i=1;i<V;i++) {
			System.out.println(parent[i]+"  "+i+"  "+graph[i][parent[i]]);
		}
	}
	
	public static void main(String args[]) {
		PrimsAlgo algo=new PrimsAlgo(5,5);
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
		algo.primMST(0,graph);
	}
}
