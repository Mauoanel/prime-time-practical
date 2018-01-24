package za.co.bmw.primetime.calculate;

import org.springframework.stereotype.Service;
import za.co.bmw.primetime.pojo.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class PrimeNumbersCalculator implements PrimeNumberInterface {

    static int array[];
    static int primes[];
    @Override
    public List<Integer> getPrimeNumbers(Range range) {

        int lowerNumber     = range.getLowerNumber();
        int upperNumber     = range.getUpperNumber();

        List<Integer> primeNumbers = new ArrayList<>();
        int flag = 0, i, j;

        for (i = lowerNumber; i <= upperNumber; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                } else {
                    flag = 1;
                }
            }
            if (flag == 1) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    @Override
    public List<Integer> getPrimeNumbersWithSieveOfEratosthenes(Range range){
        int lowerNumber     = range.getLowerNumber();
        int upperNumber     = range.getUpperNumber();
        List<Integer> primeNumbers = calculate(lowerNumber, upperNumber);

        return primeNumbers;
    }

    public  List<Integer> calculate(int n, int m) {
        List<Integer> primeNumbers = new ArrayList<>();
        int j = 0;
        int sqt = (int) Math.sqrt(m);
        array = new int[sqt + 1];
        primes = new int[sqt + 1];
        initialise(sqt + 1);
        for (int i = 2; i <= sqt; i++) {
            if (array[i] == 1) {
                primes[j] = i;
                j++;
                for (int k = i + i; k <= sqt; k += i) {
                    array[k] = 0;
                }
            }
        }

        int diff = (m - n + 1);
        array = new int[diff];
        initialise(diff);
        for (int k = 0; k < j; k++) {
            int div = n / primes[k];
            div *= primes[k];
            while (div <= m) {
                if(div>=n && primes[k]!=div)
                    array[div-n] = 0;
                div += primes[k];
            }
        }

        for (int i = 0; i < diff; i++) {
            if (array[i] == 1 && (i+n) !=1)
                primeNumbers.add(i + n);
        }

        return primeNumbers;
    }

    public static void initialise(int sqt) {
        for (int i = 0; i < sqt; i++) {
            array[i] = 1;
        }
    }
}

