import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	static List<PC> listCPU = new ArrayList<PC>();
	static List<Task> listTask = new ArrayList<Task>();

	public static void main(String[] args) {
		String firstFit = "first-fit";
		String randomFit = "random-fit";
		String worstFit = "worst-fit";
		String arg = "0";

		listCPU = SetUp.createPCList();

		listTask = SetUp.createTaskList();

		firstFit();

		printUsage();

		if (arg.equals(firstFit)) {
			firstFit();
		} else if (arg.equals(worstFit)) {
			worstFit();
		} else if (args.equals(randomFit)) {
			randomFit();
		}
	}

	private static void firstFit() {
		Iterator<Task> iteratorTask = listTask.iterator();

		while (iteratorTask.hasNext()) {
			Task currentTask = iteratorTask.next();
			for (PC pc : listCPU) {
				if (pc.addProcess(currentTask)) {
					iteratorTask.remove();
					break;
				}
			}
		}

	}

	private static void worstFit() {

	}

	private static void randomFit() {

	}

	private static void printUsage() {
		try {
			PrintWriter writer = new PrintWriter("pc-log.txt", "UTF-8");

			for (PC pc : listCPU) {
				writer.println(
						"PC ID: " + pc.getId() + "||| CPU STATUS: " + pc.getCpu() + " ||| MEM STATUS: " + pc.getRam());
			}
			writer.close();

		} catch (IOException e) {
			// do something
		}
	}

}
