package com.rizwan;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rizwansharif
 * 
 */
public class PrimeNumberFinder {
	/**
	 * Uses Sieve of Eratosthenes
	 * @link{http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes} to generate N
	 * prime numbers. Complexity of this Sieve is O(nloglog n) which effectively decides the
	 * complexity of our whole system. 
	 * 
	 * @param howMany
	 *            , how many prime numbers are needed
	 * @return List of Integers containing the prime numbers
	 * @throws AlgoCantHelpException
	 *             if we can't handle your input , such as large numbers then this expection gets thrown.
	 *             Since Algorthim is using ArrayList which internally uses
	 *             integer to track its indices , i cannot go beyond MAX_VALUE
	 *             of Integer, hence the maximum point to which sieve of
	 *             Eratosthenes can work while using ArrayList is
	 *             sqrt(Integer.Max_Value). If more prime numbers (numbers greater than sqrt of MAX_VALUE of Int) are needed ,
	 *             then we should use LinkedList in the implementation
	 */
	public List<Integer> getPrimeNumbers(int howMany)
			throws AlgoCantHelpException {
		long limit = 30;

		if (howMany >= new Double(Math.sqrt(Integer.MAX_VALUE)).intValue())
			throw new AlgoCantHelpException("We can only handle max input of "
					+ new Double(Math.sqrt(Integer.MAX_VALUE)).intValue());

		if (howMany > 10)
			limit = howMany * howMany;

		ArrayList<Boolean> sieve = new ArrayList<Boolean>();
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

		for (int k = 0; k < limit; k++) {
			sieve.add(true);
		}
		for (int i = 2; i < Math.sqrt(limit); i++) {
			if (sieve.get(i)) {
				for (int j = i * i, k = 0; j < limit; k++, j = i * i + k * i) {
					sieve.set(j, false);

				}
			}
		}
		for (int l = 2; l < sieve.size(); l++) {
			if (sieve.get(l))
				primeNumbers.add(l);
		}
		return primeNumbers.subList(0, howMany);
	}

}
