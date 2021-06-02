package stack;
public class Stack {
	static final int max=1000;
	int top;
	int st[]=new int[max];
	Stack(){
		top=-1;
	}
	
	public void push(int d,Stack st) {
		if(top==max-1) {
			System.out.println("stack is overflow");
			return;
		}
		st.st[++top]=d;
		return;
	}
	
	public int pop(Stack st) {
		if(st.top==-1) {
			System.out.println("stack is underflow");
			return -1;
		}
		return st.st[top--];
	}
	
	public int peek(int []st,int ptr) {
		if(ptr!=-1) {
			return st[ptr];
		}
		else
			return -1;
	}
	
	public void printelements() {
		if(top==-1) {
			System.out.println("stack is underlfow");
			return;
		}
		else {
			for(int i=0;i<=top;i++) {
				System.out.println(st[i]);
			}
		}
	}
	
}