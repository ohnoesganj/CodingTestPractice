import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] r_dp;
    static Integer[] l_dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        r_dp = new Integer[N];
        l_dp = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(r_dp[i] + l_dp[i], max);
        }

        System.out.println(max - 1);
    }

    public static int LIS(int N) {
        if (r_dp[N] == null) {
            r_dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
                }
            }
        }

        return r_dp[N];
    }

    public static int LDS(int N) {
        if (l_dp[N] == null) {
            l_dp[N] = 1;

            for (int i = N + 1; i < l_dp.length; i++) {
                if (arr[i] < arr[N]) {
                    l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
                }
            }
        }

        return l_dp[N];
    }
}