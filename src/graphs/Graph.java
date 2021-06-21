package graphs;
import java.util.*;
public class Graph {
	int vertices;
	private LinkedList<Integer> adjList[];
	Graph(int v){
		vertices=v;
		adjList=new LinkedList[v];
		System.out.println(adjList.length);
		for(int i=0;i<v;++i) {
			adjList[i]=new LinkedList();
		}		
	}
	
	public void addEdge(int v,int w) {
		adjList[v].add(w);
	}
	
	void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.println(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        System.out.println("adjacents are");
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            System.out.print(n+"  ");
            if (!visited[n])
                DFSUtil(n, visited);
        }
        System.out.println();
    }
	
	
	public int DFS(int v) {
		int count=-1;
		boolean visited[]=new boolean[vertices];
		for(int i=0;i<vertices;++i) {
			if(visited[i]==false)
				count++;
				DFSUtil(i,visited);
		}
		return count;
	}
	
	public void BFS(int v) {
		boolean visited[]=new boolean[vertices];
		visited[v]=true;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(v);
		while(queue.size()!=0) {
			int s=queue.poll();
			System.out.println(s+"  ");
			Iterator<Integer> i=adjList[s].listIterator();
			while(i.hasNext()) {
				int n=i.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	
	public void topologicalSort() {
		boolean visited[]=new boolean[vertices];
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<vertices;i++) {
			if(visited[i]==false)
			topologicalUtil(i,visited,stack);
		}
		for(int i=0;i<vertices;i++) {
			System.out.println(stack.pop());
		}
	}
	
	public void topologicalUtil(int n,boolean visited[],Stack<Integer> stack) {
		visited[n]=true;
		int i;
		Iterator<Integer> it=adjList[n].listIterator();
		while(it.hasNext()) {
			i=it.next();
			if(visited[i]==false) {
				topologicalUtil(i,visited,stack);
			}
		}
		stack.push(n);
	}
	
	public void shortestPathInUnweightedGraph(int s,int d,Graph g) {
		int []path=new int[vertices];
		int dist[]=new int[vertices];
		for(int i=0;i<vertices;i++) {
			dist[i]=-1;
		}
		int v,w;
		dist[s]=0;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			v=queue.remove();
			Iterator<Integer> it=adjList[v].listIterator();
			while(it.hasNext()) {
				w=it.next();
				if(dist[w]==-1) {
					dist[w]=dist[v]+1;
					path[w]=v;
					queue.add(w);
				}
			}
		}
		System.out.println("distance is "+dist[d]);
		while(d!=s) {
			System.out.println(d);
			d=path[d];
		}
		System.out.println(d);
	}
	
	public static void main(String []args) {
		Graph g = new Graph(8);
		g.addEdge( 0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.shortestPathInUnweightedGraph(0, 7, g);
	}
}
