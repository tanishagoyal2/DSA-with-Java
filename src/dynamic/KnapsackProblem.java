package dynamic;
import java.util.*;
public class KnapsackProblem {
    


    //using dynamic approach (bounded)
    public static void solve(int wt[],int val[],int W,int n){

        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(j-wt[i-1]>=0 && dp[i-1][j-wt[i-1]]+val[i-1]>dp[i-1][j]){

                    dp[i][j]=dp[i-1][j-wt[i-1]]+val[i-1];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
                System.out.println("dp of "+i+" "+j+" is "+ dp[i][j]);
            }
        }
        System.out.println(dp[n][W]);
    }

    //dynamic approach in which the no of items are not bounded
    public static void solveB(int wt[],int v[],int W,int n){

        int dp[]=new int[W+1];
        Arrays.fill(dp,0);
        for(int i=0;i<n;i++){
            for(int j=wt[i];j<=W;j++){
                if(j-wt[i]>=0 && dp[j-wt[i]]+v[i]>dp[j]){
                    dp[j]=dp[j-wt[i]]+v[i];
                }
                System.out.println(j+" is "+dp[j]);
            }
        }
        System.out.println(dp[W]);
    }
    public static void main(String args[]){

        int wt[]={2,5,1,3,4}; 
        int n[]={15,14,10,45,30};
        solveB(wt,n,7,5);
    }
}
