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
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i : sortArr) {
            if (!map.containsKey(i)) {
                map.put(i, index++);
            }
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}