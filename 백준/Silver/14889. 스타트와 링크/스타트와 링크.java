import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int MIN = Integer.MAX_VALUE;
    public static int N;
    public static int[][] S;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += S[i][j];
                    start += S[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }

        int result = Math.abs(start - link);

        if (result == 0) {
            System.out.println(result);
            System.exit(0);
        }

        MIN = Math.min(result, MIN);
    }
}