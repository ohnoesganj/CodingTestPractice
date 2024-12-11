import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int R = 0;
    static int G = 1;
    static int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][R] = Integer.parseInt(st.nextToken());
            arr[i][G] = Integer.parseInt(st.nextToken());
            arr[i][B] = Integer.parseInt(st.nextToken());
        }

        dp[0][R] = arr[0][R];
        dp[0][G] = arr[0][G];
        dp[0][B] = arr[0][B];

        System.out.println(Math.min(cost(N-1, R), Math.min(cost(N-1, G), cost(N-1, B))));
    }

    public static int cost(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == R) {
                dp[n][R] = Math.min(cost(n-1, G), cost(n-1, B)) + arr[n][R];
            } else if (color == G) {
                dp[n][G] = Math.min(cost(n-1, R), cost(n-1, B)) + arr[n][G];
            } else {
                dp[n][B] = Math.min(cost(n-1, R), cost(n-1, G)) + arr[n][B];
            }
        }

        return dp[n][color];
    }
}