import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][][] visited;
    static int[][] map;
    static int M, N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][2];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0, 0, 1}); // x, y, 벽 부순 여부, 이동 횟수
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], z = now[2], count = now[3];

            if (x == N - 1 && y == M - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M)) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][z]) {
                        visited[nx][ny][z] = true;
                        q.add(new int[] {nx, ny, z, count + 1});
                    } else if (map[nx][ny] == 1 && z == 0 && !visited[nx][ny][z]) {
                        visited[nx][ny][1] = true;
                        q.add(new int[] {nx, ny, 1, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}