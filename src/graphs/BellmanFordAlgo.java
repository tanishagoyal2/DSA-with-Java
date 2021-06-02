package graphs;

import java.util.*;
public class BellmanFordAlgo {
	int V,E;
	Edge edge[];
	BellmanFordAlgo(int v,int e){
		V=v;
		E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	class Edge{
		int src,des,weight;
		Edge(){
			src=des=weight=0;
		}
	}
	
	public void shortestDistance(BellmanFordAlgo graph,int s) {
		int dist[]=new int[graph.V];
		for(int i=0;i<graph.V;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		for(int i=1;i<graph.V;i++) {
			for(int j=0;j<graph.E;j++) {
				int u=graph.edge[j].src;
				int v=graph.edge[j].des;
				int weight=graph.edge[j].weight;
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
					dist[v]=dist[u]+weight;
				}
			}
		}
		for(int i=0;i<graph.E;i++) {
			int u=graph.edge[i].src;
			int v=graph.edge[i].des;
			int weight=graph.edge[i].des;
			if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
				System.out.println("negative cycle exists");
				return ;
			}
		}
		printArr(dist,graph.V);
	}
	
	void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
	
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		BellmanFordAlgo graph=new BellmanFordAlgo(5,8);
		graph.edge[0].src = 0;
        graph.edge[0].des = 1;
        graph.edge[0].weight = -1;
  
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].des = 2;
        graph.edge[1].weight = 4;
  
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].des = 2;
        graph.edge[2].weight = 3;
  
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].des = 3;
        graph.edge[3].weight = 2;
  
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].des = 4;
        graph.edge[4].weight = 2;
  
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].des = 2;
        graph.edge[5].weight = 5;
  
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].des = 1;
        graph.edge[6].weight = 1;
  
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].des = 3;
        graph.edge[7].weight = -3;
        
        graph.shortestDistance(graph, 0);
		sc.close();
	}
}
