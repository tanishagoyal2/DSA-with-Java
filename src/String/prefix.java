package String;

import java.util.Scanner;

public class prefix {
//program to find the prefix string from the set of strings
    public static void solve(int n,String arr[]){
        int i=0;
        String prefix="";
        int loop=arr[0].length();
        while(i<loop){
            boolean status=true;
            char con=arr[0].charAt(i);
            System.out.println("consider is "+con);
            for(int j=0;j<n;j++){

                if(con!=arr[j].charAt(i)){
                    status=false;
                    break;
                }
            }
            if(!status){
                break;
            }
            else{
                prefix+=con;
            }
            i++;
        }
        System.out.println(prefix);
    }
    //main function to run the program
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next().split(" ")[0];
        }
        solve(n,arr);
    }
}
