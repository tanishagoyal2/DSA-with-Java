package dynamic;

public class MinimumJumps {
    

    public static void solve(int arr[],int n){

        int dp[]=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=arr[i];j++){
                if(i+j<n){
                    dp[i]=Math.min(dp[i],dp[i+j]+1);
                }
            }
        }
        System.out.println(dp[0]);
    }
    public static void main(String args[]){

        int arr[]={3,4,2,1,2,1};
        solve(arr,6);
    }
}
