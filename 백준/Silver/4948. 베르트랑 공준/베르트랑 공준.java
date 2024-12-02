import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        getPrime();

        while (true) {
            int a = Integer.parseInt(br.readLine());
            int cnt = 0;

            if (a == 0) {
                break;
            }

            for (int i = a + 1; i <= 2 * a; i++) {
                if (!prime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void getPrime() {
        prime[0] = prime[1] = true;  // 소수 -> false, 소수 X -> true

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}