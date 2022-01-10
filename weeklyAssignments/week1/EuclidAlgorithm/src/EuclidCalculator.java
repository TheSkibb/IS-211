/**
 * Author: Kristian Skibrek
 * Date: 01/08/2022
 * Class purpose: perform Euclids algorithm for finding the largest common divisor (GCD) between two integers
 */

public class EuclidCalculator {

    /**
     * Euclids algorithm:
     * E1. [Find reminder.] Divide m by n and let r be the remainder (0 <= r <= n)
     * E2. [Is it zero?] If r = 0, the algorithm terminates; n is the answer.E2.
     * E3. [Reduce.] Set value of m to n and value of n to r, go back to step E1.
     * @param m the first number
     * @param n the second number
     * note: n should always be greater than m
     */
    public int euclidAlgorithm(int m, int n){
        int r = m%n;
        if(r == 0){
            return n;
        }
        else {
            m = n;
            n = r;
            return euclidAlgorithm(m, n);
        }
    }

}
