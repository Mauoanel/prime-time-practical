package za.co.bmw.primetime.calculate;

import za.co.bmw.primetime.pojo.Range;

import java.util.List;

public interface PrimeNumberInterface {

    /**
     * Calculate and Get a list of prime numbers.
     * @param range object contains - start of range
     * @param range object contains - end of range
     * @return a list of prime numbers.
     */
    List<Integer> getPrimeNumbers(Range range);

    /**
     * Calculate and Get a list of prime numbers with Sieve Of Eratosthenes.
     * @param range object contains - start of range
     * @param range object contains - end of range
     * @return a list of prime numbers.
     */
    List<Integer> getPrimeNumbersWithSieveOfEratosthenes(Range range);
}
