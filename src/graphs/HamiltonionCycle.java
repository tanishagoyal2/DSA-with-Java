package graphs;

public class HamiltonionCycle {

	
	//funtion to check hamiltonon cycle
	public static int hamiltonionCycle(int graph[][],int v,int source) {
		int path[]=new int[v];
		for(int i=0;i<v;i++) {
			path[i]=-1;
		}
		//consider first vertices as the starting vertices
		path[0]=source;
		
		if(hamilUtil(graph,path,1,v)==false) {
			System.out.println("Hamiltonion cycle doesnt exists");
			return 0;
		}
		return 1;
	}
	
	//hamiltionion cycle checking util
	public static boolean hamilUtil(int [][]graph,int []path,int pos,int v) {
		//check for the base condition
		//if it is the last vertex check if there is an edge to the first vertex from it
		
		if(pos==v) {
			if(graph[path[pos-1]][path[0]]==1) {
				return true;
			}
			return false;
		}
		
	}
	
	public static void main(String args[]) {
		int graph[][]= {{}};
	}
}
