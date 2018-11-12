
public class Timer {
private static long currentTime;//counter: incremented by 1 each time a job
								//is inserted in the queue from the array
								//and each time an iteration
								//is made to search for the first starved process

public static void reset() {
	currentTime=0;
}

public static void inc(Job j) {
	currentTime++;
	j.setTime(currentTime);
}
public static void inc() {
	currentTime++;
}
public static long get() {
	return currentTime;
}
}
