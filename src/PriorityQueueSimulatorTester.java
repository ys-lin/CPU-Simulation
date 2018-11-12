import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;


public class PriorityQueueSimulatorTester {

	//current length of the job-- after each execution 
	
	//after 30 processes check oldest job that has never been executed,set priority=1
	
	//job inserted back into the queue if currentLength>0
	
	//the job MUST be inserted behind all other jobs of the same current priority
	
	//if current length == 0, CPU  record  endTime, wait time
	
	
	//Report: Current system time (cycles): 6239854
	//Total number of jobs executed: 100000 jobs
	//Average process waiting time: 2046204.3 cycles
	//Total number of priority changes: 17944 #to avoid starvation
	//Actual system time needed to execute all jobs: 682.35 ms
	
	
	private static double start;
	private static double end;
	private static double runTime;
	private static ALHeapPQ alPQ;
	private static 	final int[]  maxNumberOfJobs = {100};
	//, 1000, 10000, 100000, 1000000
	
	
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
		if (j.getCurrentJobLength()>0) {
			alPQ.insert(alPQ.size()+1, j);
		}else {
			j.jDone();
			Timer.done();
		}
	}

	public static void printReport(String file) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(file+".txt"), "utf-8"))) {
	   writer.write("something");
	}catch(IOException e) {
		e.getMessage();
	}
	}
	public static void main(String[] args) {
		
		for (int e : maxNumberOfJobs) {
			Job[] jobInputArray=fillArray(e);
			Timer.reset();
			alPQ=new ALHeapPQ(jobInputArray);
			while(alPQ.size()!=0) {
			alExecute();
			if(Timer.getDone()%30==0) {
				alPQ.noExecuted();
			}
			}
			
			
		}
		
		
		
	}

}
