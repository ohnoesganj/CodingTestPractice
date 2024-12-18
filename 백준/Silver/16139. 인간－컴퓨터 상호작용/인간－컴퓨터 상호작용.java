import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[S.length() + 1][26];

        for (int i = 1; i <= S.length(); i++) {
            int search = S.charAt(i - 1)-'a';

            for (int j = 0; j < 26; j++) {
                int before = arr[i-1][j];
                arr[i][j] = j == search ? before + 1 : before;
            }
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            sb.append(arr[end][idx] - arr[start-1][idx]).append("\n");
        }

        System.out.println(sb);
    }
}