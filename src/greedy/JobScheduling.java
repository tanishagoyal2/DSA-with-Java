package greedy;
import java.util.*;
public class JobScheduling {

	int n;
	Job jobs[];
	int pos=0;
	JobScheduling(int n){
		this.n=n;
		jobs=new Job[n];
	}
	
	public void addJob(int d,int p,char c) {
		jobs[pos++]=new Job(d,p,c);
	}
	
	public void scheduling() {
		boolean slots[]=new boolean[n];
		Stack<Character> output=new Stack<Character>();
		int profit=0;
		Arrays.sort(jobs,new sort());
		for(int i=0;i<n;i++) {
			if(slots[jobs[i].deadline-1]==false) {
				slots[jobs[i].deadline-1]=true;
				profit+=jobs[i].profit;
				output.add(jobs[i].id);
			}
			else {
				for(int j=jobs[i].deadline-1;j>=0;j--) {
					if(slots[j]==false) {
						slots[j]=true;
						output.add(jobs[i].id);
						profit+=jobs[i].profit;
						break;
					}
				}
			}
		}
		System.out.println("total profit is "+profit);
	}
	
	public static void main(String args[]) {
		JobScheduling js=new JobScheduling(5);
		js.addJob(4,200,'a');
		js.addJob(5,150,'b');
		js.addJob(1,20,'c');
		js.addJob(1,30,'d');
		js.addJob(2,90,'e');
		js.scheduling();
	}
}


class sort implements Comparator<Job>{
	public int compare(Job a,Job b) {
		return b.profit-a.profit;
	}
}

class Job{
	int deadline;
	int profit;
	char id;
	Job(int d,int p,char id){
		this.deadline=d;
		this.profit=p;
		this.id=id;
	}
}