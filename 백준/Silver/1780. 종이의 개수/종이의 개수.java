import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n1;
    static int n2;
    static int n3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        n1 = 0;
        n2 = 0;
        n3 = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }

    public static void partition(int row, int col, int size) {
        if (numberCheck(row, col, size)) {
            if (arr[row][col] == -1) {
                n1++;
            } else if (arr[row][col] == 0) {
                n2++;
            } else {
                n3++;
            }
            return;
        }

        int newSize = size / 3;  // 3

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize * 2, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize * 2, newSize);

        partition(row + newSize * 2, col, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);
    }

    public static boolean numberCheck(int row, int col, int size) {
        int number = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (number != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}