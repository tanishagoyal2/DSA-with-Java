package dynamic;

public class LongestIncreasingSubsequence{

    public static void solve(int arr[],int n){
        int lis[]=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lis[i]=Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int res=lis[0];
        for(int i=1;i<n;i++){
            res=Math.max(res, lis[i]);
        }
        System.out.println(res);
    }
    public static void main(String args[]){

        int arr[]={3,4,2,8,10,5,1};
        solve(arr,7);
    }
}