import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int N;
    public static int[] num;
    public static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int n, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, n);
            MIN = Math.min(MIN, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(n + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(n - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(n * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(n / num[idx], idx + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }
}