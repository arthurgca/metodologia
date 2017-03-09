package org.metodologia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String firstFit = "first-fit";
		String randomFit = "random-fit";
		String worstFit = "worst-fit";
		String arg = "0";

		List<PC> listPC = FirstFit.allocate(SetUp.createPCList(), SetUp.createTaskList());
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
		try {
			PrintWriter writer = new PrintWriter("pc-log.txt", "UTF-8");

			for (PC pc : listPC) {
				writer.println(
						"PC ID: " + pc.getId() + "||| CPU STATUS: " + pc.getCpu() + " ||| MEM STATUS: " + pc.getRam());
			}
			writer.close();
			System.out.println("Finished.");

		} catch (IOException e) {
			// do something
		}
	}

}
