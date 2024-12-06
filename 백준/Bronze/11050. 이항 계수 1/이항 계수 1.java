import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sb.append(BC(N, K));

        System.out.println(sb);
    }

    static int BC(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return BC(n - 1, k - 1) + BC(n - 1, k);
    }
}