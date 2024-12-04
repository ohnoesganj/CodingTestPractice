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

        Deque<Integer> q = new ArrayDeque<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if (!q.isEmpty()) {
                        sb.append(q.pollFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case 4:
                    if (!q.isEmpty()) {
                        sb.append(q.pollLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case 5:
                    sb.append(q.size()).append("\n");
                    break;
                case 6:
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    if (!q.isEmpty()) {
                        sb.append(q.peekFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case 8:
                    if (!q.isEmpty()) {
                        sb.append(q.peekLast());
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