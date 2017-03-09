package org.metodologia;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

public class Main {

	private static FirstFit ff = new FirstFit();

	public static void main(String[] args) {
		String firstFit = "first-fit";
		String randomFit = "random-fit";
		String worstFit = "worst-fit";
		String arg = "0";		
		
		List<PC> listPC = ff.allocate(SetUp.createPCList(), SetUp.createTaskList());
		printUsage(listPC);

		if (arg.equals(firstFit)) {
			firstFit();
		} else if (arg.equals(worstFit)) {
			worstFit();
		} else if (args.equals(randomFit)) {
			randomFit();
		}
	}

	private static void firstFit() {

	}

	private static void worstFit() {

	}

	private static void randomFit() {

	}

	private static void printUsage(List<PC> listPC) {
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
			writer.println("Tasks sem alocação: "+ ff.getUnnalocatedTasks());
			writer.close();

			System.out.println("Finished.");

		} catch (IOException e) {
			// do something
		}
	}

}
