package dynamic;
public class OptimalGame{

    //recursive solution
    public static int solve(int arr[],int i,int j,int sum){

        if(i+1==j){
            return Math.max(arr[i], arr[j]);
        }
        else{
            return Math.max(sum-solve(arr,i+1,j,sum-arr[i]),sum-solve(arr,i,j-1,sum-arr[j]));
        }
    }

    //dynamic programming approach

    public static void main(String args[]){

        int arr[]={5,7,20,10};
        int n=4;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        System.out.println(solve(arr,0,n-1,sum));
    }
}