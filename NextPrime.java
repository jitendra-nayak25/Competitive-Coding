public class NextPrime {
    public static int nextPrime(int n) {
        int nxt = n + 1;

        while (true) {
            if (isPrime(nxt)) {
                return nxt;
            }
            nxt++;
        }
    }



    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 17;
        int res = nextPrime(n);
        System.out.println("The next prime number after " + n + " is: " + res);
    }
}