import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 1;
    static int[] checked;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        checked = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        if (!visited[R]) {
            bfs(R);
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(checked[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);

        visited[node] = true;
        checked[node] = cnt++;

        while (!q.isEmpty()) {
            int u = q.poll();

            Collections.sort(arr[u], Collections.reverseOrder());
            for (int i = 0; i < arr[u].size(); i++) {
                int v = arr[u].get(i);

                if (visited[v]) {
                    continue;
                }

                q.offer(v);
                visited[v] = true;
                checked[v] = cnt++;
            }
        }
    }
}