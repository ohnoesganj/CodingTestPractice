import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int now;
        int time;

        public Node(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }

    static boolean[] visited;
    static int N, K;
    static int max = 100_000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];

        bfs();

        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            visited[cur.now] = true;

            if (cur.now == K) {
                min = Math.min(min, cur.time);
            }

            if (cur.now * 2 <= max && !visited[cur.now * 2]) {
                q.offer(new Node(cur.now * 2, cur.time));
            }
            if (cur.now + 1 <= max && !visited[cur.now + 1]) {
                q.offer(new Node(cur.now + 1, cur.time + 1));
            }
            if (cur.now - 1 >= 0 && !visited[cur.now - 1]) {
                q.offer(new Node(cur.now - 1, cur.time + 1));
            }
        }
    }
}