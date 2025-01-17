import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = a;
            arr[i+1] = b;
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], min);
        }

        System.out.println(solve(0, N - 1));

    }

    private static int solve(int pos, int cur) {
        if (pos == cur)
            return 0;

        if (dp[pos][cur] != min)
            return dp[pos][cur];

        for (int i = pos; i < cur; i++) {
            int value = solve(pos, i) + solve(i + 1, cur) + (arr[pos] * arr[i+1] * arr[cur + 1]);
            dp[pos][cur] = Math.min(dp[pos][cur], value);
        }

        return dp[pos][cur];
    }
}