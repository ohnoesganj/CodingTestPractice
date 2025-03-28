import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] color;
    static ArrayList<Integer>[] map;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            map = new ArrayList[V + 1];
            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                map[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x].add(y);
                map[y].add(x);
            }

            boolean result = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        result = false;
                        break;
                    }
                }
            }

            System.out.println(result ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : map[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    q.add(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }

        return true;
    }
}