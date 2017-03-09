package org.metodologia.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.metodologia.FirstFit;
import org.metodologia.PC;
import org.metodologia.Task;

public class FirstFitTest {

	private List<PC> listPC;
	private List<Task> listTask;
	private List<PC> listPCAfter;
	private FirstFit ff = new FirstFit();
	private BigDecimal pTrinta = new BigDecimal("0.30");
	private BigDecimal pDez = new BigDecimal("0.10");

	@Test
	public void testAllocationNoRest() {
		resetLists();
		PC pc1 = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc1, pc2));

		Task t1 = new Task(pTrinta, pTrinta);
		Task t2 = new Task(pTrinta, pTrinta);
		Task t3 = new Task(pDez, pDez);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		//pc1 = 0.55 - 0.3 = 0.25
		//pc2 = 0.55 - 0.3 = 0.25 , pulou pc1 por falta de espaço
		//pc1 = 0.25 - 0.1 = 0.15
		listPCAfter = ff.allocate(listPC, listTask);
		assertEquals(listPCAfter.get(0).getCpu(), new BigDecimal("0.15"));
		assertEquals(listPCAfter.get(1).getCpu(), new BigDecimal("0.25"));

	}

	@Test
	public void testAllocationRest() {
		resetLists();
		PC pc = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc, pc2));

		Task t1 = new Task(pTrinta, pTrinta);
		Task t2 = new Task(pTrinta, pTrinta);
		Task t3 = new Task(pTrinta, pTrinta);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		listPCAfter = ff.allocate(listPC, listTask);

		//pc1 = 0.55 - 0.30 = 0.25
		//pc2 = 0.55 - 0.30 = 0.25
		//não há espaço em nenhum dos dois pcs para alocar, t3 não foi alocada
		assertEquals(listPCAfter.get(0).getCpu(), new BigDecimal("0.25"));
		assertEquals(listPCAfter.get(1).getCpu(), new BigDecimal("0.25"));
	}
	
	@Test
	public void testAllocationRest2() {
		resetLists();
		PC pc = new PC(1);
		PC pc2 = new PC(2);
		listPC.addAll(Arrays.asList(pc, pc2));

		Task t1 = new Task(pTrinta, pTrinta);
		Task t2 = new Task(pDez, pDez);
		Task t3 = new Task(pTrinta, pTrinta);
		listTask.addAll(Arrays.asList(t1, t2,t3));
		
		listPCAfter = ff.allocate(listPC, listTask);

		//pc1 = 0.55 - 0.3 = 0.25
		//pc1 = 0.55 - 0.1 = 0.15
		//pc2 = 0.55 - 0.3 = 0.25
		//para t2 é alocada em pc1 pois ainda há espaço
		assertEquals(listPCAfter.get(0).getCpu(), new BigDecimal("0.15"));
		assertEquals(listPCAfter.get(1).getCpu(), new BigDecimal("0.25"));
	}
	
	private void resetLists() {
		listPC = new ArrayList<PC>();
		listTask = new ArrayList<Task>();
		listPCAfter = new ArrayList<PC>();
	}
	
}
