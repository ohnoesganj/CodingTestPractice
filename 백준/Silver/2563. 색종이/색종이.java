import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader vs Scanner : 속도 차원에서 br이 더 빠름
        // BufferedReader => 문자열을 한 줄로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        boolean[][] arr = new boolean[100][100];
        int total = 0;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!arr[j][k])  {
                        arr[j][k] = true;
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}