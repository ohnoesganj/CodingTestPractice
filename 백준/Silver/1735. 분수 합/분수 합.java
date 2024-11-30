import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken()); // 분자 1
        int B = Integer.parseInt(st.nextToken()); // 분모 1

        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken()); // 분자 2
        int D = Integer.parseInt(st.nextToken()); // 분모 2

        int n = A * D + B * C;
        int m = B * D;

        int gcd = gcd(n, m);
        
        sb.append(n / gcd).append(" ").append(m / gcd);
        System.out.println(sb);
    }

    public static int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;

            n = m;
            m = r;
        }
        return n;
    }
}