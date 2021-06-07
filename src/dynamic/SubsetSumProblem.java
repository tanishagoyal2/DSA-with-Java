package dynamic;

import java.util.ArrayDeque;
import java.util.HashMap;

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

	boolean dp[][]=new boolean [n+1][sum+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=sum;j++){
			if(i==0 && j==0){
				dp[i][j]=true;
			}
			else if(i==0){
				dp[i][j]=false;
			}
			else if(j==0){
				dp[i][j]=true;
			}
			else{
				if(dp[i-1][j]==true) {
					dp[i][j]=true;
				}
				else {
					int val=arr[i-1];
					if(val<=j) {
						dp[i][j]=dp[i-1][j-val];
					}
				}
			}
			System.out.println(dp[i][j]);
		}
	}
	System.out.println(dp[n][sum]);

	ArrayDeque<Pair> queue=new ArrayDeque<Pair>();

	queue.add(new Pair(n,sum,""));

	while(queue.size()>0){
		Pair rem=queue.removeFirst();
		if(rem.i==0 || rem.j==0){
			System.out.println(rem.psf);
		}
		else{
			if(rem.j>=arr[rem.i-1]){
				boolean inc=dp[rem.i-1][rem.j-arr[rem.i-1]];
				if(inc){
					queue.add(new Pair(rem.i-1,rem.j-arr[rem.i-1],(rem.i-1)+" "+rem.psf));
				}
			}
			boolean exc=dp[rem.i-1][rem.j];
			if(exc)
			queue.add(new Pair(rem.i-1,rem.j,rem.psf));
		}
	}
}

	// find the no of continous subarray with the given sum
	public static void continousSubsArray(int arr[],int sum,int n){
		int prefixSum[]=new int[n+1];
		prefixSum[0]=0;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();	
		hm.put(0,1);
		int count=0;
		for(int i=1;i<=n;i++){
			prefixSum[i]=prefixSum[i-1]+arr[i-1];
			System.out.println("prefix i "+prefixSum[i]);
			System.out.println(prefixSum[i]-sum);
			if(hm.containsKey(prefixSum[i]-sum)){
				count+=hm.get(prefixSum[i]-sum);
			}
			if(hm.containsKey(prefixSum[i])){
				hm.put(prefixSum[i],hm.get(prefixSum[i])+1);
			}
			else
				hm.put(prefixSum[i], 1);
		}
		System.out.println(count);
	}
	public static void main(String args[]) {
		int set[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        int sum = 0;
        continousSubsArray(set,sum,12);
	}
}
class Pair{
	int i;
	int j;
	String psf;
	Pair(int a,int b,String str){
		this.i=a;
		this.j=b;
		this.psf=str;
	}
}