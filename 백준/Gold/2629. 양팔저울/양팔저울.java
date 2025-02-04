import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][40001];
        findDp(0, 0);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());

            if(dp[N][t]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    private static void findDp(int cnt, int num) {
        if (dp[cnt][num]) {
            return;
        }

        dp[cnt][num] = true;

        if (cnt == N) {
            return;
        }

        findDp(cnt + 1, num + arr[cnt]);
        findDp(cnt + 1, num);
        findDp(cnt + 1, Math.abs(num - arr[cnt]));
    }
}