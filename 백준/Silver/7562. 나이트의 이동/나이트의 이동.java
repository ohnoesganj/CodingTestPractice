import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;
    static boolean[][] visited;
    static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine(), " ");
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            bfs(cx, cy);

            System.out.println(map[tx][ty]);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 8; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if ((newX >= 0 && newX < I) && (newY >= 0 && newY < I)
                    && !visited[newX][newY]) {
                    q.add(new int[]{newX, newY});
                    map[newX][newY] = map[cur[0]][cur[1]] + 1;
                    visited[newX][newY] = true;
                }
            }
        }
    }
}