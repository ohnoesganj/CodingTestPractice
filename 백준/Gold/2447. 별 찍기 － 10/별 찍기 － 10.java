import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void star(int x, int y, int N, boolean blank) {
       if (blank) {
           for (int i = x; i < x + N; i++) {
               for (int j = y; j < y + N; j++) {
                   arr[i][j] = ' ';
               }
           }
           return;
       }

       if (N == 1) {
           arr[x][y] = '*';
           return;
       }

       int size = N / 3;  // 한 칸
       int cnt = 0;  // 별 출력 누적 합

       for (int i = x; i < x + N; i += size) {
           for (int j = y; j < y + N; j += size) {
               cnt++;
               star(i, j, size, cnt == 5);
           }
       }
    }
}