package dynamic;
public class SubsetSumProblem {

	// not a efficient approach . 
	public static boolean isSubset(int set[],int n,int sum) {
		if(sum==0) {
			return true;
		}
		if(n==0) {
			return false;
		}
		
		if(set[n-1]>sum) {
			return isSubset(set,n-1,sum);
		}
		return isSubset(set,n-1,sum) || isSubset(set,n-1,sum-set[n-1]);
	}
	
	
	//dynamic approach to solve the problem
	public static void isSubset(int set[],int sum) {
		boolean dp[][]=new boolean [set.length+1][sum+1];
		int lenx=set.length+1;
		int leny=sum+1;
		for(int i=0;i<lenx;i++) {
			for(int j=0;j<leny;j++) {
				if(i==0 && j==0) {
					dp[i][j]=true;
				}
				else if(i==0) {
					dp[i][j]=false;
				}
				else if(j==0) {
					dp[i][j]=true;
				}
				else {
					if(dp[i-1][j]==true) {
						dp[i][j]=true;
					}
					else {
						int val=set[i-1];
						if(val<=j) {
							dp[i][j]=dp[i-1][j-val];
						}
					}
				}
			}
		}
		System.out.println(dp[set.length][sum]);
	}
	
	public static void main(String args[]) {
		int set[] = { 3, 34, 10, 12, 5, 1 };
        int sum = 9;
        int n = set.length;
        isSubset(set,sum);
        if (isSubset(set, n, sum) == true)
            System.out.println("Found a subset"
                               + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
	}
}
