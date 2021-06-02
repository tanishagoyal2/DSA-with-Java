package backtracking;

public class RatInAMaze {
	boolean mat[][],sol[][];
	int n;
    RatInAMaze(int n){
        mat= new boolean [][]{
        	{true,false,false,false},
				{true,true,false,true},
				{false,true,false,false},
				{true,true,true,true}};
        sol=new boolean[n][n];
        this.n=n;
    }
    
    public void solution(){
        if(solutionUtil(0,0)==true){
            System.out.println("path exists");
        }
        else{
            System.out.println("path doesnt exists");
        }
    }
    
    public boolean solutionUtil(int i,int j){
        if(i==n-1 && j==n-1 && isSafe(i,j)==true){
            return true;
        }
        else{
            if(isSafe(i,j)==true){
                sol[i][j]=true;
                if(solutionUtil(i+1,j)==true){
                    return true;
                }
                else if(solutionUtil(i,j+1)==true){
                    return true;
                }
                else{
                    sol[i][j]=false;
                }
            }
        }
        return false;
    }
    
    public boolean isSafe(int i,int j){
        if(i<n && j<n && mat[i][j]==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		RatInAMaze g=new RatInAMaze(4);
		g.solution();
	}
}
