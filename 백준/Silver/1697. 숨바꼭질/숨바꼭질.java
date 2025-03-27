import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        arr[node] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp - 1;
                } else if (i == 1) {
                    next = temp + 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(arr[temp]);
                    return;
                }

                if (next >= 0 && next < arr.length && arr[next] == 0) {
                    q.add(next);
                    arr[next] = arr[temp] + 1;
                }
            }
        }
    }
}