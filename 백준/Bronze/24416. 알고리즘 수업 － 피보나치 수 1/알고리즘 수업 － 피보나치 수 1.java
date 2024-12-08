import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] f;
    public static int fib_cnt = 0;
    public static int fibonacci_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        f = new int[N];

        fib(N);
        fibonacci(N);

        sb.append(fib_cnt).append(" ").append(fibonacci_cnt);
        System.out.println(sb);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            fib_cnt++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n-2));
        }
    }

    public static int fibonacci(int n) {
        f[0] = f[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci_cnt++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n-1];
    }
}