import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수
        int V = Integer.parseInt(st.nextToken());  // 탐색을 시작할 정점의 번호

        arr = new ArrayList[N + 1];
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

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : arr[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");

            for (int next : arr[u]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}