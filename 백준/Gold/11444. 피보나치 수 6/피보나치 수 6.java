import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    final static int MOD = 1000000007;
    static long N;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(fibonacci(A, N-1)[0][0]);
    }

    private static long[][] fibonacci(long[][] A, long expo) {
        if (expo == 1L || expo == 0) {
            return A;
        }

        long[][] temp = fibonacci(A, expo / 2);

        temp = multiply(temp, temp);

        if (expo % 2 == 1L) {
            temp = multiply(temp, origin);
        }

        return temp;
    }

    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] temp = new long[2][2];

        temp[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
        temp[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
        temp[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
        temp[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;

        return temp;
    }
}