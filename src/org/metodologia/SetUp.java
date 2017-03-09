package org.metodologia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SetUp {
	private static final int TIME_LAPSE = 2100000000;
	private static final int PC_NUMBER = 16000;

	public static List<Task> createTaskList() {
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

	public static List<PC> createPCList() {
		List<PC> list = new ArrayList<PC>();
		for (int i = 0; i < PC_NUMBER; i++) {
			list.add(new PC(i));
		}
		return list;
	}

}
