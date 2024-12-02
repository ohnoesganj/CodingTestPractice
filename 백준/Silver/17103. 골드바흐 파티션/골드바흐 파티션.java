import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        getPrime();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int partitionCnt = 0;

            for (int j = 2; j  <= N / 2; j++) {
                // 순서가 다르고 두 소수가 같은 경우 같은 파티션 -> N/2
                if (!prime[j] && !prime[N - j]) {
                    partitionCnt++;
                }
            }

            sb.append(partitionCnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void getPrime() {
        prime[0] = prime[1] = true;  // 소수 -> false, 소수 X -> true

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}