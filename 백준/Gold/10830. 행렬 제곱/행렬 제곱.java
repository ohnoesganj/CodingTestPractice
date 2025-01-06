import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    final static int MOD = 1000;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        arr = new int[(int) N][(int) N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(arr, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] pow(int[][] A, long expo) {
        if (expo == 1L) {
            return A;
        }

        int[][] temp = pow(A, expo / 2);

        temp = multiply(temp, temp);

        if (expo % 2 == 1L) {
            temp = multiply(temp, arr);
        }

        return temp;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += o1[i][k] * o2[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }

        return temp;
    }
}