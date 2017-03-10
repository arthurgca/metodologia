package org.metodologia;

import java.util.List;

public interface AllocationAlgorithm {

	List<PC> allocate(List<PC> listPC, List<Task> listTask);

	int getUnnalocatedTasks();

}
