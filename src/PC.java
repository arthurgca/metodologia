
public class PC {
	
	private double cpu;
	private double ram;

	public PC() {
		this.cpu = 0.55;
		this.ram = 0.55;
	}
	
	public double getCpu() {
		return cpu;
	}
	
	public double getRam() {
		return ram;
	}
	
	public void addProcess(double usage) {
		this.cpu -= usage;
	}
}
