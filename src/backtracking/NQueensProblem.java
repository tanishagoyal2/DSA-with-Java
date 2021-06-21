package backtracking;

public class NQueensProblem {

	int N;
	int sol[][];
	NQueensProblem(int n){
		this.N=n;
		sol=new int[n][n];
	}
	
	
	public boolean solveUtil(int row) {
		if(row==N) {
			return true;
		}
		else {
			for(int j=0;j<N;j++) {
				if(isSafe(row,j)) {
					sol[row][j]=1;
					if(solveUtil(row+1)) {
						return true;
					}
					sol[row][j]=0;
				}
			}
			return false;
		}
	}
	
	public void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean isSafe(int row,int col) {
		System.out.println(row+" "+col);
		//check with primary diagonal
		for(int i=row, j=col;i>=0 && j>=0;i--,j--) {
			System.out.println((i)+" "+(j));
			if(sol[i][j]==1) {
				return false;
			}
		}
		//check for secondary diagonal
		for(int i=row,j=col;i>=0 && j<N;i--, j++) {
			if(sol[i][j]==1) {
				return false;
			}
		}
		// check for column
		for(int k=row-1;k>=0;k--) {
			if(sol[k][col]==1) {
				return false;
			}
		}
		return true;
		
	}
	
	
	public void solve() {
		if(solveUtil(0)==true) {
			System.out.println("sol exists");
			print();
		}
		else {
			System.out.println("solution doesnt exists");
		}
	}
	
	public static void main(String args[]) {
		NQueensProblem np=new NQueensProblem(4);
		np.solve();
	}
}
