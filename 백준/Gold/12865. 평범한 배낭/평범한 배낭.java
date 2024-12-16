import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static Integer[][] dp;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new Integer[N][K + 1];
        arr1 = new int[N];
        arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N - 1, K));
    }

    public static int knapsack(int n, int k) {
        if (n < 0) {
            return 0;
        }

        if (dp[n][k] == null) {

            if (arr1[n] > k) {
                dp[n][k] = knapsack(n - 1, k);
            } else {
                dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - arr1[n]) + arr2[n]);
            }
        }

        return dp[n][k];
    }
}