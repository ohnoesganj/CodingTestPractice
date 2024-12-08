import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {            // 해당 노드를 방문하지 않았을 때만
                visit[i] = true;        // 방문 상태로 변경
                arr[depth] = i + 1;     // 해당 깊이를 index로 하여 i+1 저장
                dfs(depth + 1);  // 다음 자식 노드 방문을 위해 depth 값을 1 증가
                visit[i] = false;       // 자식 노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
            }
        }
    }
}