import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());  // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine());  // 컴퓨터 쌍의 수

        arr = new ArrayList[N + 1];
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

        dfs(1);

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;

        for (int i = 0; i < arr[node].size(); i++) {
            int u = arr[node].get(i);
            if (!visited[u]) {
                dfs(u);
                cnt++;
            }
        }
    }
}