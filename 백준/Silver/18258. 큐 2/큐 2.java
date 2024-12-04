import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        sb.append(q.poll());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (!q.isEmpty()) {
                        sb.append(q.getFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (!q.isEmpty()) {
                        sb.append(q.getLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}