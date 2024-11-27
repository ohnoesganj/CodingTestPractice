import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 두 변의 길이의 합이 나머지 한 변의 길이보다 커야함
        int max = 0;

        if (a > b) {
            if (b > c) {
                max = a;
            }
            else {
                max = Math.max(a, c);
            }
        } else {
            max = Math.max(b, c);
        }

        if (a + b + c - max > max) {
            System.out.println(a + b + c);
        }
        else {
            System.out.println((a + b + c - max) * 2 - 1);
        }
    }
}