package dynamic;
import java.util.*;
public class activitySelectionProblem {
    public static void solve(int n,Room arr[]){
		Arrays.sort(arr,new Comparator<Room>(){
			public int compare(Room a,Room b){return a.start-b.start;}
		});
        PriorityQueue<Room> queue=new PriorityQueue<>(new Comparator<Room>(){
            public int compare(Room a,Room b){
                return a.end-b.end;
            }
        });
        queue.add(arr[0]);
        int count=1;
        for(int i=1;i<n;i++){
            Room earliest=queue.peek();
            Room room=arr[i];
            if(earliest.end<=room.start){
                earliest.end=room.end;
            }
            else{
                count++;
                queue.add(room);
            }
        }
        System.out.println(count);
	}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rooms=sc.nextInt();
        Room arr[]=new Room[rooms];
        for(int i=0;i<rooms;i++){
            int input[]=new int[2];
            for(int j=0;j<2;j++){
                String  st=sc.next();
                System.out.println("input is "+st);
                input[j]=Integer.parseInt(st);
            }
            arr[i]=new Room(input[0],input[1]);
        }
        solve(rooms, arr);
    }
}

class Room{
    int start;
    int end;
    Room(int s,int e){
        this.start=s;
        this.end=e;
    }
}