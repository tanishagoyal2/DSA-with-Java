package graphs;

public class detectCycleUsingUnion {

	int V,E;
	Edge edge[];
	class Edge{
		int src,des;
	}
	detectCycleUsingUnion(int v,int e){
		V=v;
		E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	
	public int find(int []parent,int ver) {
		if(parent[ver]==-1) {
			return ver;
		}
		return find(parent,parent[ver]);
	}
	
	public void union(int parent[],int x,int y) {
		parent[x]=y;
	}
	
	public boolean isCycle(detectCycleUsingUnion graph) {
		int parent[]=new int[graph.V];
		for(int i=0;i<graph.V;i++) {
			parent[i]=-1;
		}
		for(int i=0;i<graph.E;i++) {
			int x=find(parent,graph.edge[i].src);
			int y=find(parent,graph.edge[i].des);
			if(x==y) {
				System.out.println("cycle is detected between "+graph.edge[i].src+" and "+graph.edge[i].des);
				return true;
			}
			union(parent,x,y);
		}
		return false;
	}
	public static void main(String []args) {
		detectCycleUsingUnion graph=new detectCycleUsingUnion(4,4);
		graph.edge[0].src = 0;
        graph.edge[0].des = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].des = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].des = 3;
        System.out.println(graph.isCycle(graph));
	}
}
