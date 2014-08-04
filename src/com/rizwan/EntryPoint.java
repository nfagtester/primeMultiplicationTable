package com.rizwan;

/**
 * 
 * @author rizwansharif
 * 
 */
public class EntryPoint {

	public static void main(String[] args) throws AlgoCantHelpException {

		if (args.length < 1) {
			System.out.println("Usage: java -jar <numberOfPrimes>");
			System.exit(0);
		}

		int numberOfPrimes = 0;

		try {
			numberOfPrimes = Integer.parseInt(args[0]);
		} catch (NumberFormatException ex) {
			System.out.println("We could not parse your input into a number");
			System.exit(0);
		}
		if (numberOfPrimes <= 0) {
			System.out.println("Not a valid input, please enter a number greater than 0");
			System.exit(0);
		}

		TableGenerator tableGenerator = new TableGenerator();

		int[][] table = tableGenerator.generateTableForNPrimes(numberOfPrimes);

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				int product = table[i][j];
				if (product != 1)
					System.out.print(product);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
