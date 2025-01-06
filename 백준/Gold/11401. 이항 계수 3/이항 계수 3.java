import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    final static long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long numerator = factorial(N);  // 분자

        long denominator = factorial(K) * factorial(N - K) % P;  // 분모

        System.out.println(numerator * pow(denominator, P - 2) % P);
    }

    private static long pow(long base, long expo) {
        long result = 1;

        while (expo > 0) {
            if (expo % 2 == 1) {
                result *= base;
                result %= P;
            }

            base = (base * base) % P;
            expo /= 2;
        }
        return result;
    }

    private static long factorial(long n) {
        long fac = 1L;

        while (n > 1) {
            fac = (fac * n) % P;
            n--;
        }

        return fac;
    }
}