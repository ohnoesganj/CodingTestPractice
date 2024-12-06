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

        int[] typeArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (typeArr[i] == 0) {
                q.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        while (M-- > 0) {
            int moveValue = Integer.parseInt(st.nextToken());
            q.addFirst(moveValue);
            sb.append(q.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}