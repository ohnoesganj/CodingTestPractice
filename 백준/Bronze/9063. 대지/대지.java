import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        int x_min = 100000;
        int y_min = 100000;
        int x_max = -100000;
        int y_max = -100000;

        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (x_min > x) {
                x_min = x;
            }

            if (x_max < x) {
                x_max = x;
            }

            if (y_min > y) {
                y_min = y;
            }

            if (y_max < y) {
                y_max = y;
            }
        }

        result = (x_max - x_min) * (y_max - y_min);
        System.out.println(result);
    }
}