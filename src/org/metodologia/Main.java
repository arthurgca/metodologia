package org.metodologia;

public class Main {


	public static void main(String[] args) {
		String firstFit = "first-fit";
		String randomFit = "random-fit";
		String worstFit = "worst-fit";
		String arg = args[0];

		if (arg.equals(firstFit)) {
			firstFit();
		} else if (arg.equals(worstFit)) {
			worstFit();
		} else if (args.equals(randomFit)) {
			randomFit();
		}
	}
	
	private static void firstFit() {
		FirstFit ff = new FirstFit();
		Allocator alc = new Allocator(ff);
		alc.run();
	}

	private static void randomFit() {

	}

	private static void worstFit() {

	}

}
