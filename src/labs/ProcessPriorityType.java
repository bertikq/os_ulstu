package labs;

public enum ProcessPriorityType {
	Low (3000),
	Middle(5000),
	High(10000);
	
	private int time;
	
	ProcessPriorityType(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
}
