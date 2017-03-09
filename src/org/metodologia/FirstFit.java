package org.metodologia;

import java.util.Iterator;
import java.util.List;

public class FirstFit {
	
	public static List<PC> allocate(List<PC> listPC, List<Task> listTask) {
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
		
		return listPC;
	}
	
	
}
