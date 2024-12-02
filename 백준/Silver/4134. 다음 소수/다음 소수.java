import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(br.readLine());
            if (a == 0 | a == 1) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                long cnt = 0;

                for (long j = 2; j <= Math.sqrt(a); j++) {
                    if (a % j == 0) {
                        cnt++;
                        break;
                    }
                }

                if (cnt == 0) {
                    sb.append(a).append("\n");
                    break;
                }
                a++;
            }
        }
        System.out.println(sb);
    }
}