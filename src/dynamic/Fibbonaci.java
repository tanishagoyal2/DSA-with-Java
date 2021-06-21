package dynamic;
public class Fibbonaci {

	//using recursion (complexity is greater)
	public static int fibb(int n) {
		if(n<=1) {
			return 1;
		}
		return fibb(n-1)+fibb(n-2);
	}
	
	
	// memorization mathod
	public static int fibbMem(int n,int mb[]) {
		System.out.println(mb[n]);
		if(n<=1) {
			mb[n]=1;
			return 1;
		}
		if(mb[n]>0) {
			return mb[n];
		}
		System.out.println("call for "+n);
		mb[n]=fibbMem(n-1,mb)+fibbMem(n-2,mb);
		return mb[n]; 
	}
	
	// tabulation method
	public static void fibbTab(int n) {
		int tab[]=new int [n+1];
		tab[0]=1;
		for(int i=1;i<=n;i++) {
			if(i==1) {
				tab[i]=tab[i-1];
			}
			else {
				tab[i]=tab[i-1]+tab[i-2];
			}
			System.out.println(tab[i]);
		}
		System.out.println(tab[n]);
	}
	
	
	public static void main(String args[]) {
		fibbTab(6);
	}
}
//1,1,2,3,5,8,13