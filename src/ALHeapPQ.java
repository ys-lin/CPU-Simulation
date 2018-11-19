import java.util.Arrays;

public class ALHeapPQ{
	private Job[] timeRank;
	private long priorityChange=0;
	private Job[] arrQueue;
	private int numElements=0;
	
	public long getchange() {
		return priorityChange;
	}
	
	
	public ALHeapPQ(Job[]arr){
		buildHeap(arr);
	}
	
	public void noExecuted() {
		Timer.inc();
		long oldest=Timer.get();
		int index=-1;
		for(int i=1;i<numElements;i++) {
			if(arrQueue[i].getCurrentJobLength()==arrQueue[i].getJobLength())
			if(arrQueue[i].getTime() < oldest) {
				oldest=arrQueue[i].getTime();
				index=i;
			}
		}
		if(index!=-1) {
			priorityChange++;
			arrQueue[index].setJP(1);
			upHeap(index);
		}
	}
	private void upHeap(int i) {
		while(i/2>0) {
			if(isHigherPriority(arrQueue[i],arrQueue[i/2])) {
				exchange(arrQueue,i,i/2);
			}
			i=i/2;
		}
	}
	private void buildHeap(Job[] arr) {
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
	
	
	private boolean isHigherPriority(Job a, Job b) {
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
	
	private void heapify(Job[] arr, int parent) {
		int child;
		while(parent*2<numElements) {
			//if right child exists
			if(parent*2+1<numElements) {
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
	private void exchange(Job[] arr, int i1,int i2) {
		arr[i1].setKey(i2);
		arr[i2].setKey(i1);
		Job temp=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}
	
	public void insert(int i, Job value) {
		numElements++;
		arrQueue[i]=value;
		upHeap(i);
	}

	
	@Override
	public String toString() {
		return "ALHeapPQ [arrQueue=" + Arrays.toString(arrQueue) + ", numElements=" + numElements + "]";
	}

	public Job removeMin() {
	Job temp=arrQueue[1];
	arrQueue[1]=arrQueue[numElements];
	arrQueue[1].setKey(1);
	arrQueue[numElements]=null;
	numElements--;
	heapify(arrQueue,1);
	return temp;
	}

	
	public int min() {
		return 1;
	}


	public int size() {
		return numElements;
	}

	
	public boolean isEmpty() {
		return (numElements==0);
	}
	
	
	
	

}
