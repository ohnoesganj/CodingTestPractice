import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());

            sb.append(padovan(a)).append("\n");
        }

        System.out.println(sb);
    }

    public static long padovan(int n) {
        if (arr[n] == null) {
            arr[n] = padovan(n - 3) + padovan(n - 2);
        }

        return arr[n];
    }
}