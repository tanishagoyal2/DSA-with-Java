package sorting;

public class QuickSort {

	static void quickSort(int arr[], int low, int high)
    {
        // code here
		int idx = partition(arr, low, high);
	       if(low < idx-1) {
	          quickSort(arr, low, idx-1);
	        }
	       if(high > idx) {
	           quickSort(arr, idx, high);
	        }
        printarray(arr);
    }
    static int partition(int a[], int left, int right)
    {
        // your code here
    	int pivot = a[left];
        while(left<=right) {
            while(a[left] < pivot)
                left++;
            while(a[right] > pivot)
                right--;
            if(left<=right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    } 
    public static void printarray(int arr[]){
        int len = arr.length;
        for(int i=0; i<len; i++)
            System.out.print(arr[i]+" ");
    }
	public static void main(String args[]) {
		int arr[]= {4,1,3,9,7};
		quickSort(arr,0,4);
	}
}
