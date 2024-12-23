import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        System.out.println(Math.min(chessBoard('B'), chessBoard('W')));
    }

    public static int chessBoard(char c) {
        int cnt = Integer.MAX_VALUE;
        int value;
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    value = board[i][j] != c ? 1 : 0;
                } else {
                    value = board[i][j] == c ? 1 : 0;
                }
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + value;
            }
        }

        for(int i = 1; i <= N - K + 1; i++) {
            for(int j = 1; j <= M - K + 1; j++) {
                cnt = Math.min(cnt, dp[i + K - 1][j + K - 1] - dp[i + K - 1][j - 1] - dp[i - 1][j + K - 1] + dp[i - 1][j - 1]);
            }
        }
        return cnt;

    }
}