package dynamic;
public class BST_Trees{

public static void solve(int n){
    int dp[]=new int[n+1];
    dp[0]=1;
    for(int i=1;i<=n;i++){
        dp[i]=0;
        for(int j=0;j<i;j++){
            dp[i]+=dp[j]*dp[i-j-1];
        }
        System.out.println(i+" "+dp[i]);
    }
    System.out.println(dp[n]);
}

    public static void main(String arg[]){

        solve(5);
    }
}