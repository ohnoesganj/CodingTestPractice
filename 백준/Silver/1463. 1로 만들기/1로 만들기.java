import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        System.out.println(find(N));
    }

    public static int find(int n) {
        if (dp[n] == null) {
            if (n % 6 ==0) {
                dp[n] = Math.min(find(n - 1), Math.min(find(n / 3), find(n / 2))) + 1;
            } else if (n % 3 ==0) {
                dp[n] = Math.min(find(n / 3), find(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(find(n / 2), find(n - 1)) + 1;
            } else {
                dp[n] = find(n - 1) + 1;
            }
        }

        return dp[n];
    }
}