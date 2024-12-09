import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        sb.append(tile(N)).append("\n");

        System.out.println(sb);
    }

    public static int tile(int n) {
        if (dp[n] == -1) {
            dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;
        }

        return dp[n];
    }
}