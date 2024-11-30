import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());  // 배열에 값 저장
        }

        int gcd = 0;
        for (int i = 0; i < N-1; i++) {
            int d = arr[i+1] - arr[i];
            gcd = gcd(d, gcd);
        }

        sb.append((arr[N-1] - arr[0]) / gcd + 1 - arr.length);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}