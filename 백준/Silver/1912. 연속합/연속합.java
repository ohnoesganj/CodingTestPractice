import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        sum(N - 1);

        System.out.println(max);
    }

    public static int sum(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(sum(n - 1) + arr[n], arr[n]);

            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}