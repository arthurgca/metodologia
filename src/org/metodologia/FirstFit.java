package org.metodologia;

import java.util.Iterator;
import java.util.List;

public class FirstFit implements AllocationAlgorithm {

	private int unnalocatedTasks;

	public FirstFit() {
		this.unnalocatedTasks = 0;
	}

	@Override
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
		this.unnalocatedTasks = listTask.size();
		return listPC;
	}

	@Override
	public int getUnnalocatedTasks() {
		return unnalocatedTasks;
	}

}
