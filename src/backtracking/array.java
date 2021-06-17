package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class array {
    static final int CHARS = 26;
    int V; 
    List<List<Integer>> adj; 
    int[] in;
    array(int V)
{
    this.V = V;
    in = new int[V];
    adj = new ArrayList<>(CHARS);
      
    for(int i = 0; i < CHARS; i++)
    {
       adj.add(i, new ArrayList<>());
    }
}
void addEdge(int v, int w)
{
    adj.get(v).add(w);
    in[w]++;
}
boolean isCycle() 
{
    if (!isSC())
        return false;
  
    for(int i = 0; i < V; i++)
       if (adj.get(i).size() != in[i])
           return false;
  
    return true;
}
public boolean isSC() 
{
    boolean[] visited = new boolean[V];
    for(int i = 0; i < V; i++)
       visited[i] = false;
      int n;
    for(n = 0; n < V; n++)
       if (adj.get(n).size() > 0)
           break;
    CycleUtilFunction(n, visited);
    for(int i = 0; i < V; i++)
       if (adj.get(i).size() > 0 && !visited[i])
           return false;
    array gr = getTranspose();
    for(int i = 0; i < V; i++)
       visited[i] = false;
    gr.CycleUtilFunction(n, visited);
    for(int i = 0; i < V; i++)
       if (adj.get(i).size() > 0 && !visited[i])
           return false;
  
    return true;
}
public void CycleUtilFunction(int v, boolean[] visited)
{
    visited[v] = true;
    for(Integer i : adj.get(v))
       if (!visited[i])
       {
           CycleUtilFunction(i, visited);
       }
}
public array getTranspose()
{
    array graph = new array(V);
    for(int i = 0; i < V; i++)
    {
       for(Integer no : adj.get(i))
       {
          graph.adj.get(no).add(i);
          graph.in[i]++;
       }
    }
    return graph;
}
  
public static boolean checkCycle(String[] arr, int n)
{
    array graph = new array(CHARS);
    for(int i = 0; i < n; i++)
    {
       String string = arr[i];
       graph.addEdge(string.charAt(0) - 'a', string.charAt(string.length() - 1) - 'a');
    }
        return graph.isCycle();
}
public static void main(String[] args) throws Exception
{
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    if(n<2 || n>12){
        System.out.println("INVALID BIRD");
        return ;
    }
    String arr[]=new String[n];
    ArrayList<String> arrayToCheck=new ArrayList<String>();
    for(int i=0;i<n;i++){
        String input=sc.next().split(" ")[0];
        if(input.length()<2 || input.length()>5){
            System.out.println("INVALID BIRD");
            return ;
        }
        else{
            if(!arrayToCheck.contains(input)){
                arrayToCheck.add(input);
                arr[i]=input;
            }
            else{
                System.out.println("INVALID BIRD");
                return ;
            }
        }
    }  
    System.out.println((checkCycle(arr, n) ?"YES" : "NO"));
  
}
    
}
