import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
            dfs(R);
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(checked[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;
        checked[node] = cnt++;

        Collections.sort(arr[node], Collections.reverseOrder());
        for (Integer i : arr[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}