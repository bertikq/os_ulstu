package labs;
import java.io.Console;
import java.util.ArrayList;

public class Process {
	
	
	private ProcessPriorityType priority;
	private String name;
	private boolean isStop;
	private int _operatingTime;
	private Device device;
	private String buffer;
	private TypeBreak typeBreak;
	
	
	public boolean isIsStop() {
		return isStop;
	}
	
	public void set_operatingTime(int time, String name) {
		_operatingTime = time;
		this.name = name;
	}
	
	public int get_operatingTime() {
		return _operatingTime;
	}

	public void setIsStop(boolean isStop) {
		this.isStop = isStop;
	}

	public Process(ProcessPriorityType priority, String name, int _operatingTime, Device device, String buffer) {
		this.priority = priority;
		this.name = name;
		this._operatingTime = _operatingTime;
		this.device = device;
		this.buffer = buffer;
	}
	
	
	public ProcessPriorityType getPriority() {
		return priority;
	}
	
	public void WorkDevice() {
		System.out.println("Work device" + name);
		if (device.GetTypeDevice() == TypeDevice.Input && device.GetBuffer().length() > 0) {
			device.setFree(false);
			buffer += device.GetBuffer().substring(0, 0);
			System.out.println("Read byte");
			device.SetBuffer(device.GetBuffer().substring(1));
			if (typeBreak ==  TypeBreak.InterruptControlled) {
				isStop = true;
			}
			else WorkDevice();
		}
		
		if (device.GetTypeDevice() == TypeDevice.Output && buffer.length() > 0) {
			device.setFree(false);
			if (typeBreak ==  TypeBreak.InterruptControlled) {
				device.SetBuffer(buffer.substring(0, 0));
				buffer = buffer.substring(1);
				System.out.println("Write byte");
				isStop = true;
			}
			else WorkDevice();
		}
	}
	
	public void run(int time) {
		System.out.println("Run process " + name);
		
		_operatingTime -= time;
		
		try {
			java.lang.Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	public TypeBreak getTypeBreak() {
		return typeBreak;
	}

	public void setTypeBreak(TypeBreak typeBreak) {
		this.typeBreak = typeBreak;
	}

	public void setPriority(ProcessPriorityType priority) {
		this.priority = priority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void set_operatingTime(int _operatingTime) {
		this._operatingTime = _operatingTime;
	}

	public void stop() {
		System.out.println("Stop process " + name);
	}
	
	public String getName() {
		return name;
	}
}
