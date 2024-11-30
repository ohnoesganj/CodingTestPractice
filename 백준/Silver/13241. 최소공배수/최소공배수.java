import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long d = gcd(Math.max(A, B), Math.min(A, B));

        sb.append(A * B / d);
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}