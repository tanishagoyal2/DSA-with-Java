package dynamic;
import java.util.*;
public class EggDroppingProblem {
    

    //solve using dynmic programming
    public static void solve(int f,int e){

        int dp[][]=new int[e+1][f+1];
        for(int i=0;i<=f;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=e;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=e;i++){
            for(int j=1;j<=f;j++){
                if(i==1){
                    dp[i][j]=j;
                }
                else if(j==1){
                    dp[i][j]=1;
                }
                else{
                   dp[i][j]=Integer.MAX_VALUE;
                   for(int m=0;m<j;m++){
                       dp[i][j]=Math.min(dp[i][j], Math.max(dp[i-1][m], dp[i][j-m-1]));
                   }
                   dp[i][j]+=1;
                }
            
            }
        }
        System.out.println(dp[e][f]);
    }

    public static void main(String args[]){


        int eggs=7;
        int floors=1000;
        solve(floors,eggs);

    }
}
