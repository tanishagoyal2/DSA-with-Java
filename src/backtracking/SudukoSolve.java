package backtracking;

public class SudukoSolve {

	int n;
	int mat[][];
	SudukoSolve(int n){
		this.n=n;
		mat=new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        }; 
	}
	
	public void solve() {
		if(solveUtil()) {
			System.out.println("solved");
		}
		else {
			System.out.println("not solved");
		}
	}
	
	public boolean solveUtil() {
		int i=0,j=0;
		int r=-1,c=-1;
		boolean isempty=true;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(mat[i][j]==0) {
					r=i;
					c=j;
					isempty=false;
					break;
				}
			}
			if(!isempty) {
				break;
			}
		}
		System.out.println(i+" "+j);
		if(isempty) {
			return true;
		}
		for(int ele=1;ele<=n;ele++) {
			if(isSafe(r,c,ele)) {
				mat[r][c]=ele;
				if(solveUtil()) {
					return true;
				}
				mat[r][c]=0;
			}
		}
		return false;
	}
	
	public boolean isSafe(int i,int j,int ele) {
		//check for row and column
		for(int r=0;r<n;r++) {
			if(mat[r][j]==ele) {
				return false;
			}
			if(mat[i][r]==ele) {
				return false;
			}
		}
		//check for submatrix
		int s=(int)Math.sqrt(n);
		int rs=i-i%s;
		int cs=j-j%s;
		for(int l=0;l<s;l++) {
			for(int m=0;m<s;m++) {
				if(mat[l+rs][m+cs]==ele) {
					return false;
				}
			}
		}
		return true;
	}
	public void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		SudukoSolve ss=new SudukoSolve(9);
		ss.solve();
		ss.print();
	}
}
