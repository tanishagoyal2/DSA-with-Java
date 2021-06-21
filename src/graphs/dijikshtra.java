package graphs;

public class dijikshtra {
	static int v=9;
	public void shortestDistance(int g[][],int s) {
		int dist[]=new int[v];
		Boolean visited[]=new Boolean[v];
		for(int i=0;i<v;i++) {
			dist[i]=Integer.MAX_VALUE;
			visited[i]=false;
		}
		dist[s]=0;
		for(int i=0;i<v-1;i++) {
			int u=minDistance(dist, visited);
			visited[u]=true;
			for(int w=0;w<v;w++) {
				if(visited[w]==false && g[u][w] != 0 && dist[u]!=Integer.MAX_VALUE && dist[w]>dist[u]+g[u][w]) {
					dist[w]=dist[u]+g[u][w];
					
				}
			}
		}
		printSolution(dist);
		
	}
	
	void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < v; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
	
	int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int i = 0; i < v; i++)
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
  
        return min_index;
    }
  
	public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijikshtra t = new dijikshtra();
        t.shortestDistance(graph,0);
    }
}
