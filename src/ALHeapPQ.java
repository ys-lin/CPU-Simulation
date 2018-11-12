import java.util.Arrays;

public class ALHeapPQ{
	private Job[] arrQueue;
	private int numElements;
	
	
	
	public ALHeapPQ(Job[]arr){
		buildHeap(arr);
	}
	
	public void buildHeap(Job[] arr) {
		//from last index to first index
		numElements=arr.length-1;
				for (int i=arr.length-1;i>0;i--) {
					//increment timer and job endTime
					Timer.inc(arr[i]);
					arr[i].setEntryTime(Timer.get());
					arr[i].setKey(i);
					heapify(arr,i);
				}
				arrQueue= arr;
	}
	
	
	public boolean isHigherPriority(Job a, Job b) {
		if(a.getJP()<b.getJP()) {
			return true;
		}
		if(a.getJP()==b.getJP()) {
			if(a.getTime()<b.getTime()) {
				return true;
			}
		}
		return false;
	}
	
	public void heapify(Job[] arr, int parent) {
		int child;
		while(parent*2<arr.length) {
			//if right child exists
			if(parent*2+1<arr.length) {
				//if right>left
				if(isHigherPriority(arr[parent*2+1],arr[parent*2])) {
					//child=right
				child=parent*2+1;
				}else {
					//child=left
				child=parent*2;
				}
			}else {
				child=parent*2;
			}
				
			if(isHigherPriority(arr[child],arr[parent])){
				exchange(arr,child,parent);
				parent=child;
				}else break;
			
			
	
		}
	}
	public void exchange(Job[] arr, int i1,int i2) {
		arr[i1].setKey(i2);
		arr[i2].setKey(i1);
		Job temp=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}
	
	public void insert(int i, Job value) {
		
	}

	
	@Override
	public String toString() {
		return "ALHeapPQ [arrQueue=" + Arrays.toString(arrQueue) + ", numElements=" + numElements + "]";
	}

	public void removeMin() {
	arrQueue[0]=arrQueue[numElements];
	}

	
	public int min() {
		return 0;
	}


	public int size() {
		return 0;
	}

	
	public int isEmpty() {
		return 0;
	}
	
	
	
	

}
