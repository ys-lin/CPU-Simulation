
public class PriorityQueueSimulatorTester {
//Now executing Job_285. Job length: 42 cycles; Current remaining length: 26 cycles;
//Initial priority: 22; Current priority: 1 
	
	// First-Come-First-Served (FCFS)if currentPriority is the same for 2 jobs
	
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
	
	private static int currentTime;//counter: incremented by 1 each time a job
								   //is inserted in the queue from the array
								   //and each time an iteration
							       //is made to search for the first starved process
	private static double start;
	private static double end;
	private static double runTime;
	private static 	final int[]  maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};
	
	
	public static Job[] fillArray(int maxJobNum) {
		Job[] arr=new Job[maxJobNum];
		for(int i=0;i<maxJobNum;i++) {
			arr[i]=new Job("Job_"+(i+1),(int)(1+Math.random()*69),(int)(1+Math.random()*39));	
		}
		return arr;
	}
	
	

	public static void main(String[] args) {
		
		for (int e : maxNumberOfJobs) {
			Job[] jobInputArray=fillArray(e);
				
		}
		
		
		
	}

}
