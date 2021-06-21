package heaps;

public class BinaryMinHeap {

	int size;
	int maxSize;
	int heap[];
	
	BinaryMinHeap(int maxsize){
		this.maxSize=maxsize;
		this.size=0;
		heap=new int [maxsize+1];
		heap[0]=Integer.MIN_VALUE;
	}
	
	
	public int parent(int pos) {
		return pos/2;
	}
	
	
	public int leftChild(int pos) {
		return pos*2;
	}
	
	
	public int rightChild(int pos) {
		return pos*2+1;
	}
	
	
	public void insert(int data) {
		if(size>=maxSize) {
			return ;
		}
		heap[++size]=data;
		int current=size;
		while(heap[current]<heap[parent(current)]) {
			int temp=heap[current];
			heap[current]=heap[parent(current)];
			heap[parent(current)]=temp;
			current=parent(current);
		}
	}
	
	
	public boolean isleaf(int pos) {
		if(pos>(size/2) && pos<size) {
			return true;
		}
		return false;
	}
	
	
	public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                             + " LEFT CHILD : " + heap[2 * i]
                             + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }
	
	
	public void swap(int pos,int secondpos) {
		int temp=heap[pos];
		heap[pos]=heap[secondpos];
		heap[secondpos]=temp;
	}
	
	
	public void minHeapify(int pos) {
		if(!isleaf(pos)) {
			if(heap[pos]>heap[pos*2] || heap[pos]>heap[pos*2+1]) {
				if(heap[pos*2]>heap[pos*2+1]) {
					swap(pos,pos*2+1);
					minHeapify(pos*2+1);
				}
				else {
					swap(pos,pos*2);
					minHeapify(pos*2);
				}
			}
		}
	}
	
	
	public void minHeap() {
		for(int i=size/2;i>=1;i--) {
			minHeapify(i);
		}
	}
	
	
	public static void main(String []args) {
		BinaryMinHeap minHeap=new BinaryMinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        //minHeap.minHeap();
  
        minHeap.print();
		
	}
}


