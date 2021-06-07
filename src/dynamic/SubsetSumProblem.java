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
	//find the no of subsets possible with the given sum
	public static void subsetNumbers(int arr[],int sum,int n){
		int dp[][]=new int [n+1][sum+1];
		for(int i=0;i<=sum;i++){
			dp[0][i]=0;
		}
		for(int i=0;i<=n;i++){
			dp[i][0]=1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(j<arr[i-1]){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
				}
				System.out.println(dp[i][j]);
			}
		}
		System.out.println(dp[n][sum]);
	}

//print the subsets possible with given sum
public static void printSubset(int arr[],int sum,int n){

}

	public static void main(String args[]) {
		int set[] = {2,5,3};
        int sum = 5;
        subsetNumbers(set,sum,3);
	}
}
