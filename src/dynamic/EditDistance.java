
package dynamic;
public class EditDistance {
    
//using dynamic programming and tabulation method
    public static void solve(String s1,String s2,int m,int n){
        int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        for(int j=0;j<=n;j++){
            dp[j][0]=j;
        }
        int i,j;
        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    public static void main(String args[]){

        solve("CAT","CUT",3,3);
    }
}
