import java.io.FileWriter;
import java.io.IOException;


public class PriorityQueueSimulatorTester {

	//current length of the job-- after each execution 
	//after 30 processes check oldest job that has never been executed,set priority=1
	//job inserted back into the queue if currentLength>0
	//the job MUST be inserted behind all other jobs of the same current priority
	//if current length == 0, CPU  record  endTime, wait time
	
	private static double totalWait;
	private static double start;
	private static double end;
	private static ALHeapPQ alPQ;
	private static UnsortedListPQ unsortL;
	private static 	final int[]  maxNumberOfJobs = {100,1000,10000,100000};
	
	
	public static Job[] fillArray(int maxJobNum) {
		//index 0 is left empty, thus jobNum+1
		Job[] arr=new Job[maxJobNum+1];
		//from i=1 to maxJobNum
		for(int i=1;i<=maxJobNum;i++) {
			arr[i]=new Job("Job_"+i,(int)(Math.random()*70+1),(int)(Math.random()*40+1));
		}
		return arr;
	}
	
	public static void alExecute() {
		
		Job j=alPQ.removeMin();
		j.decLength();
		Timer.inc(j);
		System.out.println(j);
		if (j.getCurrentJobLength()>0) {
			alPQ.insert(alPQ.size()+1, j);
		}else {
			j.jDone();
			totalWait=totalWait+j.getWaitTime();
			Timer.done();
		}
	}
	
public static void unsortExecute() {
		
		Job j=unsortL.removeMin();
		j.decLength();
		Timer.inc(j);
		System.out.println(j);
		if (j.getCurrentJobLength()>0) {
			unsortL.insert(unsortL.size()+1, j);
		}else {
			j.jDone();
			totalWait=totalWait+j.getWaitTime();
			Timer.done();
		}
	}
	

	public static void printReport(String file,int j,ALHeapPQ al) {
		try (FileWriter writer = new FileWriter(file+".txt",true)) {
	   writer.write("Current system time (cycles): " + Timer.get()+
	   		"\nTotal number of jobs executed:" + j +
	   		"\nAverage process waiting time: " + (totalWait/j)+
	   		" cycles\nTotal number of priority changes: " + al.getchange()+
	   		"\nActual system time needed to execute all jobs: "+(end-start)+"ms\n\n");
	}catch(IOException e) {
		e.getMessage();
	}
		
	}
	
	public static void ini() {
		start=0;
		end=0;
		totalWait=0;
	}
	public static void main(String[] args) {
		
		for (int e : maxNumberOfJobs) {
			Job[] jobInputArray=fillArray(e);
			Timer.reset();
			alPQ=new ALHeapPQ(jobInputArray);
			start=System.currentTimeMillis();
			while(alPQ.size()!=0) {
			alExecute();
			if(Timer.getDone()!=0&&(Timer.getDone())%30==0) {
				Timer.resetDone();
				alPQ.noExecuted();
			}
			}
			end=System.currentTimeMillis();
			printReport("out",e,alPQ);
			ini();
		}
		
		
		
	}

}
