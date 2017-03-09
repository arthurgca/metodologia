package org.metodologia.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.metodologia.FirstFit;
import org.metodologia.PC;
import org.metodologia.Task;

public class FirstFitTest {

	private List<PC> listPC = new ArrayList<PC>();;
	private List<Task> listTask = new ArrayList<Task>();;
	private List<PC> listPCAfter = new ArrayList<PC>();

	@Test
	public void testAllocationNoRest() {
		PC pc = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc, pc2));

		Task t1 = new Task(0.30, 0.30);
		Task t2 = new Task(0.30, 0.30);
		Task t3 = new Task(0.10, 0.10);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		//pc = 0.55 - 0.3 - 0.1
		//pc2 = 0.55 - 0.3 = 0.25
		//porque há espaço no pc para alocar
		listPCAfter = FirstFit.allocate(listPC, listTask);
		assertEquals(listPCAfter.get(0).getCpu(), 0.15, 0.000001);
		assertEquals(listPCAfter.get(1).getCpu(), 0.25, 0.000001);

	}
	
	@Test
	public void testAllocationRest() {
		PC pc = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc, pc2));

		Task t1 = new Task(0.30, 0.30);
		Task t2 = new Task(0.30, 0.30);
		Task t3 = new Task(0.30, 0.10);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		listPCAfter = FirstFit.allocate(listPC, listTask);

		//pc = 0.55 - 0.30 = 0.25
		//pc2 = 0.55 - 0.30 = 0.25
		//não há espaço em nenhum dos dois pcs para alocar
		assertEquals(listPCAfter.get(0).getCpu(), 0.25, 0.000001);
		assertEquals(listPCAfter.get(1).getCpu(), 0.25, 0.000001);
	}
	
	@Test
	public void testAllocationRest2() {
		PC pc = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc, pc2));

		Task t1 = new Task(0.30, 0.30);
		Task t2 = new Task(0.10, 0.30);
		Task t3 = new Task(0.30, 0.10);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		listPCAfter = FirstFit.allocate(listPC, listTask);

		//pc = 0.55 - 0.30 = 0.25
		//pc2 = 0.55 - 0.10 - 0.30 = 0.15
		//para t3 não há espaço no primeiro pc, mas há espaço no segundo
		assertEquals(listPCAfter.get(0).getCpu(), 0.25, 0.000001);
		assertEquals(listPCAfter.get(1).getCpu(), 0.15, 0.000001);
	}
	
}
