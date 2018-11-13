
public class Job {
private int key;
public int getKey() {
	return key;
}

public void setKey(int key) {
	this.key = key;
}
private String jobName;
private int jobLength;//between 1 and 70
private int currentJobLength;
private int jobPriority;//between 1 and 40
private int finalPriority;
private long entryTime=0;
private long endTime=0;
private long waitTime=0;

public Job(String jobName, int jobLength, int jobPriority) {
	this.jobName = jobName;
	this.jobLength = jobLength;
	currentJobLength=jobLength;
	this.jobPriority = jobPriority;
	finalPriority=jobPriority;
}


public String toString() {
	return "Now executing " + jobName + ". job length: " + jobLength + " cycles; Current remaing length: "  + currentJobLength + "; Initial Priority: " + jobPriority + "; current Priority: " + finalPriority+"\n";
}

public int getCurrentJobLength() {
	return currentJobLength;
}

public void decLength() {
	currentJobLength--;
}

public int getJobLength() {
	return jobLength;
}

public void setJobLength(int jobLength) {
	this.jobLength = jobLength;
}

public int getJP() {
	return finalPriority;
}
public void setJP(int priority) {
	finalPriority=priority;
}
public long getTime() {
	return endTime;
}
public void setTime(long time) {
	endTime=time;
}
public void setEntryTime(long time) {
	entryTime=time;
}
public void jDone() {
	waitTime=endTime-entryTime-jobLength;
}
public long getWaitTime() {
	return waitTime;
}
}
