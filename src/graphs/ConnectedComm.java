package graphs;

/*package whatever //do not write package name here */

import java.util.*;
class ConnectdComm {
    int v;
    LinkedList<Integer> adjList[];
    
    @SuppressWarnings("unchecked")
	ConnectdComm(int v){
        this.v=v;
        adjList=new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i]=new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }
    
    public void DFSUtil(int u,boolean visited[]){
        visited[u]=true;
        System.out.print(u+" ");
        Iterator<Integer> it=adjList[u].iterator();
        while(it.hasNext()){
            int v=it.next();
            if(!visited[v]){
                DFSUtil(v,visited);
            }
        }
    }
    
    public ConnectdComm getTranpose(){
    	ConnectdComm g=new ConnectdComm(v);
        for(int i=0;i<v;i++){
            Iterator<Integer> it=adjList[i].iterator();
            while(it.hasNext())
            g.adjList[it.next()].add(i);
            }
        return g;
        }
    
    public void fillOrder(int u,boolean visited[],Stack<Integer> stack){
        visited[u]=true;
        Iterator<Integer> it=adjList[u].iterator();
        while(it.hasNext()){
            int v=it.next();
            if(!visited[v])
            fillOrder(v,visited,stack);
        }
        stack.push(u);
    }
    
    public void printSCC(){
        Stack<Integer> stack=new Stack<Integer>();
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            visited[i]=false;
        }
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                fillOrder(i,visited,stack);
            }
        }
        
        for(int i=0;i<v;i++){
            visited[i]=false;
        }
        ConnectdComm g=getTranpose();
        while(stack.empty()!=true){
            int v=stack.pop();
            if(!visited[v]){
                g.DFSUtil(v,visited);
                System.out.println();
            }
        }
    }
	public static void main (String[] args) {
		System.out.println("GfG!");
		ConnectdComm g=new ConnectdComm(5);
		g.addEdge(1, 0); 
		g.addEdge(0, 2); 
		g.addEdge(2, 1); 
		g.addEdge(0, 3); 
		g.addEdge(3, 4); 

		System.out.println("Following are strongly connected components "+ 
						"in given graph "); 
		g.printSCC(); 
		
	}
}
