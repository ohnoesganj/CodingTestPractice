import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static int M, N, H;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int maxDay = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            
            for(int i = 0; i < 6; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                int newZ = z + dz[i];

                if ((newX >= 0  && newX < N) && (newY >= 0 && newY < M) && (newZ >= 0 && newZ < H)
                    && map[newZ][newX][newY] == 0) {  // 익지 않은 토마토만 큐에 넣기
                    map[newZ][newX][newY] = map[z][x][y] + 1;
                    q.add(new int[]{newZ, newX, newY});
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return -1;
                    }
                    maxDay = Math.max(maxDay, map[i][j][k]);
                }
            }
        }
        return maxDay - 1;
    }
}