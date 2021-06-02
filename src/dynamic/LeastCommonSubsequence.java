package dynamic;
import java.util.*;
public class LeastCommonSubsequence {

	int memo[][];
	LeastCommonSubsequence(int m,int n){
		memo=new int [m+1][n+1];
		for(int [] i:memo) {
			Arrays.fill(i, -1);
		}
	}
	public int LCS(String s1,String s2,int m,int n) {
		if(memo[m][n]!=-1) {
			return memo[m][n];
		}
		if(m==0||n==0) {
			return 0;
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			memo[m][n]=1+LCS(s1,s2,m-1,n-1);
		}
		else {
			memo[m][n]=Math.max(LCS(s1,s2,m-1,n), LCS(s1,s2,m,n-1));
		}
		return memo[m][n];
	}
	
	public static void main(String args[]) {
		LeastCommonSubsequence lcs=new LeastCommonSubsequence(4,3);
		String s1="AXYZ";
		String s2="BXYZ";
		System.out.println(lcs.LCS(s1,s2,4,4));
	}
}
