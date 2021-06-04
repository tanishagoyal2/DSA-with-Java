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
    // using dynamic programming

    public static void dpsolve(int arr[],int n){
            int res[]=new int[n];
            int k=0;
            res[k++]=arr[0];
            for(int i=1;i<n;i++){
                if(res[k-1]<arr[i]){
                    res[k++]=arr[i];
                }
                else{
                    //to find the ceil position of given no.
                    int index=findIndex(res,arr[i],k);
                    res[index]=arr[i];
                }
            }
            System.out.println(k);
            for(int i=0;i<k;i++){
                System.out.print(res[i]);
            }
    }

    public static  int findIndex(int res[],int ele,int high){
        int low=0;
        int index=high;
        while(low<high){
            int mid=(low+high)/2;
            if(ele<res[mid]){
                high=mid;
            }
            else if(ele>res[mid]){
                low=mid+1;
            }
            else{
                index=mid;
            }
        }
        return index;
    }
    public static void main(String args[]){

        int arr[]={3,4,2,8,5,1,10,6,7,9};
        dpsolve(arr,10);
    }
}