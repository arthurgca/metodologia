
public class Task {

	
	private double cpuReq;
	private double memoryReq;

	public Task(double cpuReq, double memoryReq) {
		this.cpuReq = cpuReq;
		this.memoryReq = memoryReq;
	}

	public double getMemoryReq() {
		return memoryReq;
	}

	public double getCpuReq() {
		return cpuReq;
	}

}
