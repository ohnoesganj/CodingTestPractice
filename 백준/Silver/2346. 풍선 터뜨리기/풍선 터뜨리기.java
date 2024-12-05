import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("1 ");
        int in = arr[0];

        for (int i = 1; i < N; i++) {
            q.add(new int[] {(i+1), arr[i]});  // {풍선 idx, 내용}
        }

        while (!q.isEmpty()) {
            if (in > 0) {
                for (int i = 1; i < in; i++) {
                    q.add(Objects.requireNonNull(q.poll()));
                }

                int[] nxt = q.poll();
                assert nxt != null;
                in = nxt[1];
                sb.append(nxt[0]).append(" ");
            } else {
                for (int i = 1; i < -in; i++) {
                    q.addFirst(Objects.requireNonNull(q.pollLast()));
                }

                int[] nxt = q.pollLast();
                assert nxt != null;
                in = nxt[1];
                sb.append(nxt[0]).append(" ");
            }
        }

        System.out.println(sb);
    }
}