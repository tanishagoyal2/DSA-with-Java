package sorting;
import java.util.*;

public class CountingSort {

	public void sort(int []list) {
		int max=Arrays.stream(list).max().getAsInt();
		int min=Arrays.stream(list).min().getAsInt();
		int range=max-min+1;
		int count[]=new int [range];
		int len=list.length;
		int output[]=new int[len];
		for(int i=0;i<len;i++) {
			count[list[i]-min]++;
		}
		for(int i=1;i<range;i++) {
			count[i]=count[i]+count[i-1];
		}
		for(int i=0;i<len;i++) {
			output[--count[list[i]-min]]=list[i];
		}
		for(int i=0;i<len;i++) {
			System.out.println(output[i]);
		}
	}
	
	public static void main(String []args) {
		int list[]= { 2,1,1,0,9,6,8,9,9,3,4,1,2,6,5,};
		CountingSort cs=new CountingSort();
		cs.sort(list);
	}
}
