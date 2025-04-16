import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int from, to, weight;
        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = 1_000_000_000;
    static ArrayList<Node> graph;
    static long[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dist = new long[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
        }

        boolean hasCycle = bellmanFord(1);

        if (hasCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        }

    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;

        for (int i = 1; i < N + 1; i++) {
            for (Node node : graph) {
                if (dist[node.from] != INF && dist[node.to] > dist[node.from] + node.weight) {
                    dist[node.to] = dist[node.from] + node.weight;
                }
            }
        }

        for (Node node : graph) {
            if (dist[node.from] != INF && dist[node.to] > dist[node.from] + node.weight) {
                return true;
            }
        }
        return false;
    }
}