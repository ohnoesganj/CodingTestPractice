import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] wire;
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        wire = new int[N][2];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            wire[i][0] = Integer.parseInt(st.nextToken());  // A
            wire[i][1] = Integer.parseInt(st.nextToken());  // B
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(N - max);
    }

    public static int recur(int N) {
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N + 1; i < dp.length; i++) {
                if (wire[N][1] < wire[i][1]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }

        return dp[N];
    }
}