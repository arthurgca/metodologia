package org.metodologia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Allocator {

	private final int TIME_LAPSE = 2100000000;
	private final int PC_NUMBER = 16000;
	private AllocationAlgorithm algorithm;

	public Allocator(AllocationAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	private List<PC> createPCList() {
		List<PC> list = new ArrayList<PC>();
		for (int i = 0; i < PC_NUMBER; i++) {
			list.add(new PC(i));
		}
		return list;
	}

	private List<Task> createTaskList() {
		String file = "resource/task-events.txt";
		List<Task> taskList = new ArrayList<Task>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] arrayLine = line.split(" ");
				if (!(Integer.valueOf(arrayLine[1]) < TIME_LAPSE))
					break;
				else {
					BigDecimal cpuString = new BigDecimal(arrayLine[8]);
					BigDecimal memString = new BigDecimal(arrayLine[9]);

					taskList.add(new Task(cpuString, memString));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	public void run() {
		List<PC> listPC = createPCList();
		List<Task> listTask = createTaskList();
		algorithm.allocate(listPC, listTask);
		BigDecimal fragmentationCPU = new BigDecimal("0");
		BigDecimal fragmentationMEM = new BigDecimal("0");

		try {
			PrintWriter writer = new PrintWriter("pc-log.txt", "UTF-8");

			for (PC pc : listPC) {
				fragmentationCPU = fragmentationCPU.add(pc.getCpu());
				fragmentationMEM = fragmentationMEM.add(pc.getRam());

				writer.println(
						"PC ID: " + pc.getId() + "||| CPU STATUS: " + pc.getCpu() + " ||| MEM STATUS: " + pc.getRam());
			}
			writer.println("Fragmentação - CPU: " + fragmentationCPU + "|| RAM: " + fragmentationMEM);
			writer.println("Tasks sem alocação: " + algorithm.getUnnalocatedTasks());
			writer.close();

			System.out.println("Finished.");

		} catch (IOException e) {
			// do something
		}
	}

}
