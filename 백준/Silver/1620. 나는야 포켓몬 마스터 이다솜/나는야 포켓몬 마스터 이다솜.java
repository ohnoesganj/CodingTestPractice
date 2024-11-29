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

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map1.put(i+1, name);
            map2.put(name, i+1);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (49 <= s.charAt(0) && s.charAt(0) <= 57) {
                sb.append(map1.get(Integer.parseInt(s)));
            } else {
                sb.append(map2.get(s));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}