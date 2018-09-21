package primary.mathproblem;
//统计所有小于非负整数 n 的质数的数量。
public class CountPrimes {
    public static void main(String[] args) {
//        System.out.println(countPrimes(499979));
        System.out.println(countPrimes2(499979));

    }

    public static int countPrimes(int n) {
        //暴力法。先排除2以外的偶数
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        int count = 0;
        for(int i = 3; i < n; i+=2) {
            if (isSu(i)) {
                count++;
            }
        }
        return count + 1;
    }

    public static boolean isSu(int n) {
        //判断一个奇数是否是素数
        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes2(int n) {
        //Eratosthenes sieve
//        n = n - 1;
        boolean primes[] = new boolean[n];
        for(int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        for(int a = 2; a*a < n;a++) {
            //把根号n内所有数的倍数剔除。
            for(int i = a*2; i<n;i+=a) {
                if (primes[i]) {
                    primes[i] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
}
