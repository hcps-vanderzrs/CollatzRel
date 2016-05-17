package collatz;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************
 * Compilation: javac Collatz.java Execution: java Collatz N
 *
 * Print the collatz sequence of N.
 *
 * % java Collatz 6 6 3 10 5 16 8 4 2 1
 *
 * % java Collatz 27 27 82 41 124 62 31 94 47 142 71 214 107 322 161 484 242 121 364 182 91 274 137 412 206 103 310 155 466 233 700 350 175 526 263
 * 790 395 1186 593 1780 890 445 1336 668 334 167 502 251 754 377 1132 566 283 850 425 1276 638 319 958 479 1438 719 2158 1079 3238 1619 4858 2429
 * 7288 3644 1822 911 2734 1367 4102 2051 6154 3077 9232 4616 2308 1154 577 1732 866 433 1300 650 325 976 488 244 122 61 184 92 46 23 70 35 106 53 160
 * 80 40 20 10 5 16 8 4 2 1
 *
 * % java Collatz 35 35 106 53 160 80 40 20 10 5 16 8 4 2 1
 *
 * % java Collatz 256 256 128 64 32 16 8 4 2 1
 *
 *****************************************************************************
 */
public class Collatz {
    static List<String> dataSet = new ArrayList<>();
    static int count = 0;
    static int evencount = 0;
    static int oddcount = 0;
    public static void collatz(int n) {
        
        if (n == 1) {
            return;
        } else if (n % 2 == 0) {
            collatz(n / 2);
            count++;
            evencount++;
        } else {
            collatz(3 * n + 1);
            count++;
            oddcount++;
        }
    }

    public static void main(String[] args) {
        int N = 1;
        for(int i = 1; i < 100000; i++){
            N = i;           
            dataSet.add(primeFactors(N).toString());
            collatz(N);
            dataSet.add(String.valueOf(N));
            dataSet.add(String.valueOf(count));
            count = 0;
            dataSet.add(String.valueOf(evencount));
            evencount = 0;
            dataSet.add(String.valueOf(oddcount));
            oddcount = 0;
        }
        System.out.print("NUMBER | " + " OPERATIONS | " + "    EVEN | " + "    ODD | " + "          PRIMES");
        for(int z = 0; z < dataSet.size() - 4; z+=5){
            System.out.print("\n");
            
            System.out.print(dataSet.get(z+1) + "         " + dataSet.get(z+2) + "                " + dataSet.get(z+3) + "          " + dataSet.get(z+4) + "               " + dataSet.get(z));
        }
    }

    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}

//Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
//Last updated: Mon Aug 3 13:12:19 EDT 2015.
