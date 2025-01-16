import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] sum;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 0이 주어진 횟수만큼 답 출력
        int N = Integer.parseInt(br.readLine());  // 배열의 크기

        for (int tc = 0; tc < N; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            sum = new int[n + 1];
            dp = new int[n + 1][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 1; i <= n; i++) {
                for (int from = 1; from + i <= n; from++) {
                    int to = from + i;

                    dp[from][to] = Integer.MAX_VALUE;

                    for (int j = from; j < to; j++) {
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][j] + dp[j+1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}