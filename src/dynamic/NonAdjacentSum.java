package dynamic;

public class NonAdjacentSum {
    public static void solve(int arr[],int n){
        int dp[]=new int [n+1];
        dp[0]=0;
        dp[1]=arr[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+arr[i-1]);
            System.out.println(dp[i]);
        }
        System.out.println(dp[n]);

    }
    public static void main(String args[]){

        int arr[]={5, 5, 10, 100, 10, 5};
        solve(arr,6);
    }
    
}
