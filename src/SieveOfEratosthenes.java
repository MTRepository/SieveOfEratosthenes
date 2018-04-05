import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {


    public static void main(String[] args) {

        int maxNumber = 100000;

        // primitive method

        List<Integer> primeListReg = new ArrayList<>();

        long timeIn = System.currentTimeMillis();

        for (int i = 2; i <= maxNumber; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primeListReg.add(i);
        }

        long timeOut = System.currentTimeMillis();
        long totalTimePrimitiveMethod = timeOut - timeIn;

        System.out.println("Primitive method, total time: " + totalTimePrimitiveMethod +" ms");
        System.out.println("Primes found:");
        System.out.println(primeListReg);


        // sieve of Eratosthenes - loop approach

        boolean[] isPrimeArray = new boolean[maxNumber];
        isPrimeArray[0] = false; // 1 is not a prime number

        List<Integer> primeList = new ArrayList<>();

        timeIn = System.currentTimeMillis();

        for (int i = 1; i < maxNumber; i++) {
            isPrimeArray[i] = true;
        }

        for (int i = 2; i <= maxNumber; i++) {
            if(isPrimeArray[i-1]) {
                primeList.add(i);
                for (int j = 2*i; j <= maxNumber; j += i) {
                    isPrimeArray[j-1] = false;
                }
            }
        }

        timeOut = System.currentTimeMillis();
        long totalTimeSimpleSieve = timeOut - timeIn;

        System.out.println("Sieve of Eratosthenes, total time: " + totalTimeSimpleSieve +" ms");
        System.out.println("Primes found:");
        System.out.println(primeList);


    }

}
