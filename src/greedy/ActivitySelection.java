package greedy;
import java.util.*;
public class ActivitySelection {

	Activity acts[];
	int n;
	int pos=0;
	ActivitySelection(int n){
		this.n=n;
		acts=new Activity[n];
	}
	
	@SuppressWarnings("unchecked")
	public void addActivity(int s,int f) {
		acts[pos]=new Activity(s,f);
		pos++;
	}
	
	public void maxActivity() {
		
		Arrays.sort(acts,new sorting());
		int count=1;
		@SuppressWarnings("unchecked")
		Stack<Activity> st=new Stack<Activity>();
		st.add(acts[0]);
		Activity prev=acts[0];
		for(int i=1;i<acts.length;i++) {
			if(prev.finish<=acts[i].start) {
				count++;
				prev=acts[i];
				st.add(acts[i]);
			}
		}
		while(!st.isEmpty()) {
			Activity cur=st.pop();
			System.out.println(cur.start+"  "+cur.finish);
		}
		System.out.println("no of activity is "+count);
		
	}

	public static void main(String args[]) {
		ActivitySelection sel=new ActivitySelection(3);
		sel.addActivity(12,25);
		sel.addActivity(10,20);
		sel.addActivity(20,30);
		sel.maxActivity();
	}
}

class Activity{
	int start;
	int finish;
	Activity(int s,int f){
		this.start=s;
		this.finish=f;
	}
	public Activity() {
		// TODO Auto-generated constructor stub
	}
}

class sorting implements Comparator<Activity>{
	public int compare(Activity a1,Activity a2) {
		return a1.finish-a2.finish;
	}
}

