package graphs;
/*package whatever //do not write package name here */
import java.util.*;

class ArticulationPoint {
    int v;
    LinkedList<Integer> adjList[];
    int time=0;
    int NIL=-1;
    
    @SuppressWarnings("unchecked")
	ArticulationPoint(int v){
        this.v= v;
        this.adjList=new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i]=new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void ATPUtil(int u,boolean visited[],int disc[],int low[],int parent[],boolean ap[]){
        visited[u]=true;
        disc[u]=low[u]= ++time;
        int children=0;
        Iterator<Integer> it=adjList[u].iterator();
        while(it.hasNext()){
            int v=it.next();
            if(visited[v]==false){
                children++;
                parent[v]=u;
                ATPUtil(v,visited,disc,low,parent,ap);
                if(parent[u]==NIL && children>1){
                    ap[u]=true;
                }
                else if(parent[u]!=NIL && low[v]>=disc[u]){
                    ap[u]=true;
                }
            }
            else if(v!=parent[u]){
                low[u]=Math.min(low[u],disc[v]);
            }
        }
        
    }

    public void ATP(){
        boolean visited[]=new boolean[v];
        int parent[]=new int[v];
        int disc[]=new int[v];
        int low[]=new int[v];
        boolean ap[]=new boolean[v];
        
        for(int i=0;i<v;i++){
            parent[i]=NIL;
            visited[i]=false;
            ap[i]=false;    
        }
        for(int i=0;i<v;i++){
            if(!visited[i]){
                ATPUtil(i,visited,disc,low,parent,ap);
            }
        }
        for(int i=0;i<v;i++){
            if(ap[i]==true)
            System.out.print(i+" ");
        }
    }
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		ArticulationPoint g=new ArticulationPoint(5);
		g.addEdge(1,0);
		g.addEdge(0,2);
		g.addEdge(2,1);
		g.addEdge(0,3);
		g.addEdge(3,4);
		g.ATP();
	}
}