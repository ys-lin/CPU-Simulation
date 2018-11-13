
public class UnsortedListPQ{
	private long priorityChange=0;
	private Job[] liQueue;
	private int numElements=0;
	
	public UnsortedListPQ(Job[] j) {
		liQueue=j;
		numElements=j.length-1;
		for(int i=1;i<=numElements;i++) {
			Timer.inc(liQueue[i]);
		}
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
	
	
	
public void insert(int key, Job value) {
		liQueue[++numElements]=liQueue[key];
		liQueue[key]=value;
	}

	
	public Job removeMin() {
		int min=50;
		int index=-1;
		for(int i=1;i<=numElements;i++) {
			if(liQueue[i].getJP()<min) {
				min=liQueue[i].getJP();
				index=i;
			}else if(liQueue[i].getJP()==min) {
				if(liQueue[index].getTime()>liQueue[i].getTime()) {
					index=i;
				}
			}
		}
		Job temp=liQueue[index];
		liQueue[index]=liQueue[numElements];
		numElements--;
		return temp;
		}

	
	public int min() {
		return numElements;
	}


	public int size() {
		return 0;
	}

	
	public int isEmpty() {
		return 0;
	}
}
