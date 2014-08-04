To generate prime numbers we use   Sieve of Eratosthenes http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
 Complexity of this Sieve is O(nloglog n) which effectively decides the complexity of our whole system.
 
 Limitations : Cannot work for prime numbers larger than sqrt(Integer.Max_Value) because of the usage of
 ArrayList in PrimeNumberFinder class. This can, however, be improved by using LinkedList. 

