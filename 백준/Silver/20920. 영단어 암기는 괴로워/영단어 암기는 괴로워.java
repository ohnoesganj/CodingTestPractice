import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) {
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (o1, o2) -> {
            
            // 1. 자주 등장하는 단어 순
            if ((int) map.get(o1) != map.get(o2)) {
                return Integer.compare(map.get(o2), map.get(o1));
            }

            // 2. 길이 순
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            // 3. 사전 순
            return o1.compareTo(o2);
        });

        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}