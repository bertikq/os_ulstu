package labs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlanProcess {
	
	private ArrayList<Process> processes;
	private boolean isStop;
	private TypeBreak typeBreak;
	
	public PlanProcess(TypeBreak typeBreak) {
		processes = new ArrayList<Process>();
	}
	
	public void addProcess(Process process) {
		processes.add(process);
		process.setTypeBreak(typeBreak);
	}
	
	public void SetIsStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	public void planning() {
		while(processes.size() > 0) {
			for (int i = 0; i < processes.size(); i++)
			{
				Process process = processes.get(i);
				if (!process.isStop() && process.get_operatingTime() > 0) {
					
					if (process.getDevice().isFree() && process.getDevice().GetBuffer().length() > 0) {
						process.WorkDevice();
					}
					
					if (process.isStop() && process.getTypeBreak() == TypeBreak.InterruptControlled) {
						continue;
					}
					
					process.run(Math.max(process.getPriority().getTime(), 1));
					
					if (process.get_operatingTime() <= 0) {
						processes.remove(i);
						System.out.println("Remove procces " + process.getName());
					}
					else process.stop();
				}
				
				if (process.isStop()) {
					if (process.getDevice().isFree() && process.getDevice().GetBuffer().length() > 0) {
						process.WorkDevice();
					}
				}
			}
		}
	}
	
}
