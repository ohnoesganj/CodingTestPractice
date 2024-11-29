import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> a_set = new HashSet<>();
        Set<Integer> b_set = new HashSet<>();

        int cnt1 = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            a_set.add(a);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(st.nextToken());
            b_set.add(b);
        }

        for (int n : a_set) {
            if (!b_set.contains(n)) {
                cnt1 += 1;
            }
        }

        for (int n : b_set) {
            if (!a_set.contains(n)) {
                cnt1 += 1;
            }
        }

        sb.append(cnt1);
        System.out.println(sb);
    }
}