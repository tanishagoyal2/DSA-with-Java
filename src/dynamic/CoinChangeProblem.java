package dynamic;
import java.util.*;
public class CoinChangeProblem {

    // solveing using dynamic programming (technique is combinations)
    public static void solveC(int arr[],int sum,int n){

        //consider a array of required sum size+1 since array also includes 0 to required sum(included)
        int dp[]=new int[sum+1];

        //intialize default value to all index to 0;
        Arrays.fill(dp,0);

        //intialize dp[0]=1 because to pay sum 0 there is only one that dont pay anything;
        dp[0]=1;

        //we are going to traverse the sum array for every coin;
        for(int i=0;i<n;i++){
            System.out.println("arr is "+i+" is "+arr[i]);
            for(int j=arr[i];j<=sum;j++){
                if(j-arr[i]>=0){
                    dp[j]+=dp[j-arr[i]];
                    System.out.println(j+" is "+dp[j-arr[i]]);
                }
            }
        }
        System.out.println(dp[sum]);
    }

    //dynamic programming using permutation technique in which (2,3) pair is consider to be different from (3,2);

    public static void solveP(int arr[],int sum,int n){
        int dp[]=new int[sum+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=1;i<=sum;i++){
            for(int j=0;j<n;j++){
                if(i-arr[j]>=0){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
    public static void main(String args[]){


        int arr[]={2,3,5,1};
        solveP(arr,6,4);
    }
}
