import java.io.*;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static int[][] map;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
        }

        System.out.println(floydWarshall());
    }

    public static int floydWarshall() {
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, map[i][i]);
        }

        return answer >= INF ? -1 : answer;
    }
}