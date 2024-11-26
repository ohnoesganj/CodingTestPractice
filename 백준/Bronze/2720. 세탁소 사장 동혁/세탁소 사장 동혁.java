import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            int q = C / 25;
            C %= 25;

            int d = C / 10;
            C %= 10;

            int n = C / 5;
            C %= 5;

            int p = C;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}