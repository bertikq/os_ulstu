package labs;

public class Device {
	private TypeDevice typeDevice;
	private String buffer;
	private boolean isFree;
	
	public Device(TypeDevice typeDevice) {
		this.typeDevice = typeDevice;
		buffer = "";
		isFree = true;
	}
	
	
	
	public boolean isFree() {
		return isFree;
	}



	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}



	public String GetBuffer() {
		return buffer;
	}
	
	public void SetBuffer(String buffer) {
		this.buffer = buffer;
	}
	
	public TypeDevice GetTypeDevice() {
		return typeDevice;
	}
}
