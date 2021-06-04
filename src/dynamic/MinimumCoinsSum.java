package dynamic;
public class MinimumCoinsSum{


    public static void solve(int arr[],int val){

        int dp[]=new int[val+1];

        int len=arr.length;
        for(int i=0;i<=val;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=1;i<=val;i++){
            for(int j=0;j<len;j++){
                if(arr[j]<=i){
                    int subres=dp[i-arr[j]];
                    if(subres!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],subres+1);
                }
                System.out.println(i+" is "+dp[i]);
            }
        }
        System.out.println(dp[val]);
    }
    public static void main(String args[]){

        int arr[]={9,6,5,4};
        solve(arr,11);
    }
}