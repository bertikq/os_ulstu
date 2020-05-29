package labs;


public class Program {
	public static void main(String[] args) {
		Device keyboard = new Device(TypeDevice.Input);
		Device monitor = new Device(TypeDevice.Output);
		
		PlanProcess planProcess = new PlanProcess(TypeBreak.InterruptControlled);
		Process read1 = new Process(ProcessPriorityType.Low,"READ1", 2000, keyboard, "");

		Process read2 = new Process(ProcessPriorityType.Middle,"READ2", 2000, keyboard, "");

		Process see = new Process(ProcessPriorityType.High,"SEE", 2000, monitor, "See its text");
		
		keyboard.SetBuffer("lololo");

		planProcess.addProcess(read1);
		planProcess.addProcess(read2);
		planProcess.addProcess(see);
		
		long startTime = System.currentTimeMillis();
		planProcess.planning();
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
	}
}
