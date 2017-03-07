import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<PC> listCPU = new ArrayList<PC>();

	public static void main(String[] args) {
		String bestFit = "best-fit";
		String randomFit = "random-fit";
		String worstFit = "worst-fit";
		String arg = "0";
		
		SetUp.createTaskList();
		
		if (arg.equals(bestFit)) {
			bestFit();
		} else if (arg.equals(worstFit)) {
			worstFit();
		} else if (args.equals(randomFit)){
			randomFit();
		}
	}

	
	private static void bestFit() {
 
		for (PC pc : listCPU) {
			
		}
	}
	
	private static void worstFit() {

	}
	
	private static void randomFit() {

	}

}
