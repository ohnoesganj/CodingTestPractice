import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int N;
    public static int[] arr;
    public static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        nQueen(0);

        System.out.println(cnt);
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                // 같은 행에 있을 경우
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                // 대각선에 있는 경우 => 열의 차와 행의 차가 같을 경우
                return false;
            }
        }
        return true;
    }
}