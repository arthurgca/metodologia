package org.metodologia;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PC {

	private BigDecimal cpu;
	private BigDecimal ram;
	private List<Task> taskList;
	private int id;

	public PC(int id) {
		this.id = id;
		this.cpu = new BigDecimal("0.55");
		this.ram = new BigDecimal("0.55");
		this.taskList = new ArrayList<Task>();
	}

	public BigDecimal getCpu() {
		return cpu;
	}

	public BigDecimal getRam() {
		return ram;
	}

	public boolean addProcess(Task task) {
		BigDecimal restCPU = getCpu().subtract(task.getCpuReq());
		BigDecimal restMEMORY = getRam().subtract(task.getMemoryReq());
		

		if (restCPU.compareTo(BigDecimal.ZERO) >= 0 
				&& restMEMORY.compareTo(BigDecimal.ZERO) >= 0) {

			this.cpu = restCPU;
			this.ram = restMEMORY;

			this.taskList.add(task);
			return true;

		} else
			return false;
		
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return cpu+";"+ram;
	}
}
