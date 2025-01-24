import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static int[][] arr;
    public static int[][] dp;
    public static int[] rangeX = {-1, 0, 1, 0};
    public static int[] rangeY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(1, 1) + "\n");

    }

    private static int DFS(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int newX = x + rangeX[i];
            int newY = y + rangeY[i];

            if (newX < 1 || newY < 1 || newX > M || newY > N) {
                continue;
            }

            if (arr[x][y] > arr[newX][newY]) {
                dp[x][y] += DFS(newX, newY);
            }
        }

        return dp[x][y];
    }
}