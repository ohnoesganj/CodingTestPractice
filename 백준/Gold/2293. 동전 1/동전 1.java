import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[k + 1];

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= arr[i]) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }
        sb.append(dp[k]).append("\n");

        System.out.println(sb);
    }
}