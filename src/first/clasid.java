package first;

import java.math.BigDecimal;
import java.util.Scanner;

public class clasid {
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
	//HashMap<BigDecimal,String> map=new HashMap<BigDecimal,String>();
	for(int i=0;i<n;i++) {
		String no=scanner.nextLine();
		BigDecimal deci=new BigDecimal(no);
		//map.put(deci,no);
	}
	scanner.close();
	}
}
