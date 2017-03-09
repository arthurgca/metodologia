package org.metodologia;

import java.util.Iterator;

import java.util.List;

public class FirstFit {
	private int unnalocatedTasks; 

	public FirstFit() {
		this.unnalocatedTasks = 0;
	}
	
	public List<PC> allocate(List<PC> listPC, List<Task> listTask) {
		Iterator<Task> iteratorTask = listTask.iterator();

		while (iteratorTask.hasNext()) {
			Task currentTask = iteratorTask.next();
			for (PC pc : listPC) {
				if (pc.addProcess(currentTask)) {
					iteratorTask.remove();
					break;
				}
			}
		}
		setUnnalocatedTasks(listTask.size());
		return listPC;
	}
	
	public int getUnnalocatedTasks() {
		return unnalocatedTasks;
	}
	
	public void setUnnalocatedTasks(int unnalocatedTasks) {
		this.unnalocatedTasks = unnalocatedTasks;
	}
	
	
}
