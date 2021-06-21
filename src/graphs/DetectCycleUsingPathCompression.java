package graphs;



public class DetectCycleUsingPathCompression {
	int V,E;
	Edge edge[];
	class Edge{
		int src,des;
	}
	DetectCycleUsingPathCompression(int v,int e){
		V=v;
		E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	
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
		else if(subset[xroot].rank>subset[yroot].rank){
			subset[yroot].parent=xroot;
		}
		else {
			subset[xroot].parent=yroot;
			subset[yroot].rank++;
		}
	}
	public boolean isCycle(DetectCycleUsingPathCompression graph) {
		int v=graph.V;
		int e=graph.E;
		Subset subset[]=new Subset[v];
		for(int i=0;i<v;i++) {
			subset[i]=new Subset();
			subset[i].parent=i;
			subset[i].rank=0;
		}
		for(int i=0;i<e;i++) {
			int x=find(subset,graph.edge[i].src);
			int y=find(subset,graph.edge[i].des);
			if(x==y) {
				System.out.println("cycle is detected between "+graph.edge[i].src+" and "+graph.edge[i].des);
				return true;
			}
			union(subset,x,y);
		}
		return false;
	}
	
	public static void main(String args[]) {
		DetectCycleUsingPathCompression graph=new DetectCycleUsingPathCompression(4,3);
		graph.edge[0].src = 0;
        graph.edge[0].des = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].des = 2;
 
        // add edge 0-2
        graph.edge[2].src = 1;
        graph.edge[2].des = 3;
        
        System.out.println(graph.isCycle(graph));
	}
}
