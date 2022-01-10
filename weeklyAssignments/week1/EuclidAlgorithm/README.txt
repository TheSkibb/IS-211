The program jar file is located at out/artifacts/EuclidAlgorithm_jar, and can be run in a terminal.

https://tiennh.com/time-complexity-of-the-euclidean-algorithm/
Why is this algorithm O(log n)?

the alorithm looks like this:

int euclidAlgorithm(int m, int n){
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

this is written recursivly, it could also be written like this:

int gcd(int a, int b) {
    while (b != 0) {
        int tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}

practically, these two are the same, but the second one is a bi easier to show the time complexity

