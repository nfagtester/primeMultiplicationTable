package com.rizwan;

import java.util.List;

/**
 * This class generates the multiplication table. Kind of separator between view and model 
 * @author rizwansharif
 * 
 */

public class TableGenerator {

	public int[][] generateTableForNPrimes(int n) throws AlgoCantHelpException {

		if (n == 0)
			return new int[n][n];

		PrimeNumberFinder primeNumberFinder = new PrimeNumberFinder();
		List<Integer> primeNumbers;

		primeNumbers = primeNumberFinder.getPrimeNumbers(n);
		int[][] table = new int[n + 1][n + 1];
		primeNumbers.add(0, 1);
		for (int i = 0; i < primeNumbers.size(); i++) {
			for (int j = 0; j < primeNumbers.size(); j++) {
				int product = primeNumbers.get(i) * primeNumbers.get(j);
				table[i][j] = product;
			}
		}

		return table;
	}

}
