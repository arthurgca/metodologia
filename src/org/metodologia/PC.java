package org.metodologia;
import java.util.ArrayList;
import java.util.List;

public class PC {

	private double cpu;
	private double ram;
	private List<Task> taskList;
	private int id;

	public PC(int id) {
		this.id = id;
		this.cpu = 0.55;
		this.ram = 0.55;
		this.taskList = new ArrayList<Task>();
	}

	public double getCpu() {
		return cpu;
	}

	public double getRam() {
		return ram;
	}

	public boolean addProcess(Task task) {
		if ((this.cpu - task.getCpuReq() > 0) && (this.ram - task.getMemoryReq() > 0)) {

			this.cpu -= task.getCpuReq();
			this.ram -= task.getMemoryReq();

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
