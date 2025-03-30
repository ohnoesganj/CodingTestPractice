import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


    static int[] arr;
    static ArrayList<Node>[] map;
    static int V, E;
    static final int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        arr = new int[V + 1];
        Arrays.fill(arr, INF);

        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[x].add(new Node(y, z));
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            sb.append(arr[i] == INF ? "INF" : arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        arr[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.vertex;
            int curWeight = cur.weight;

            if (curWeight > arr[curVertex]) continue;

            for (Node next : map[curVertex]) {
                int newNode = arr[curVertex] + next.weight;

                if (newNode < arr[next.vertex]) {
                    arr[next.vertex] = newNode;
                    pq.add(new Node(next.vertex, newNode));
                }
            }
        }
    }
}