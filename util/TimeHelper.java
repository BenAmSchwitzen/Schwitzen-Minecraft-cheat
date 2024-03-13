package schwitzen.util;

public class TimeHelper {
	
	public long lastMS = 0L;
	public long prevMS;
	
	public TimeHelper() {
		this.prevMS = 0L;
		
		
		
	}
	
	public boolean  hasReached(float f) {
		
		return (float) (getCurrentMS() - this.lastMS) >=f;
	}
	
	public long getCurrentMS() {
		
		return System.nanoTime() /100000L;
		
	}
	
	public void reset() {
     this.lastMS = getCurrentMS();
	
}}
