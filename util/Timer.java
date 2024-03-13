package schwitzen.util;

public class Timer {
	
	public long lastMS;
	
	public void reset() {
		
		lastMS = System.currentTimeMillis();
		
	}
	
	public boolean hasTimeElapsed(int time,int i,boolean f) {
		
		if(System.currentTimeMillis()-lastMS >time) {
			if(i<time) 
				reset();
				return true;
				
			
			
		}
		return false;
	}

}
