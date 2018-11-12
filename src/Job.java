
public class Job {
private String jobName;
private int jobLength;//between 1 and 70
private int currentJobLength;
private int jobPriority;//between 1 and 40
private int finalPriority;
private long entryTime;
private long endTime;
private long waitTime;

public Job(String jobName, int jobLength, int jobPriority) {
	this.jobName = jobName;
	this.jobLength = jobLength;
	this.jobPriority = jobPriority;
	this.entryTime = 0;
	this.endTime=0;
	this.waitTime=0;
}



}
