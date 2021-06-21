package heaps;
public class BinaryMaxHeap {
	int heap[];
	int maxSize;
	int size;
	BinaryMaxHeap(int s){
		maxSize=s;
		s=1;
		heap=new int [this.maxSize+1];
		heap[0]=Integer.MAX_VALUE;
		
	}
	
	public boolean isLeaf(int pos) {
		if(pos>size/2 && pos<=size)
			return true;
		return false;
	}
	
	
	public int parent(int pos) {
		return pos/2;
	}
	
	public int leftChild(int pos) {
		return pos*2;
	}
	
	public int rightChild(int pos) {
		return (pos*2)+1;
	}
	
	public void swap(int fpos,int spos) {
		int temp=heap[fpos];
		heap[fpos]=heap[spos];
		heap[spos]=temp;
	}
	
	public void maxHeapify(int pos) {
		if(!isLeaf(pos) && (heap[pos]<heap[leftChild(pos)] || heap[pos]<heap[rightChild(pos)])) {
			if(heap[rightChild(pos)]<heap[leftChild(pos)]) {
				swap(pos,leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else {
				swap(pos,rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}
	
	public void insert(int data) {
		heap[++size]=data;
		int current=size;
		while(heap[current]>heap[parent(current)]) {
			swap(current,parent(current));
			current=parent(current);
		}
	}
	
	public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i]
                + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }
	
	public static void main(String []args) {
		BinaryMaxHeap maxHeap = new BinaryMaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
  
        maxHeap.print();
        int max=maxHeap.heap[1];
        System.out.println(maxHeap.size);
        maxHeap.heap[1]=maxHeap.heap[maxHeap.size--];
        maxHeap.maxHeapify(1);
        System.out.println(maxHeap.size);
        maxHeap.print();
	}
	
}
