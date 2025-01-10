import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[][] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // B[k] 출력
        int N = Integer.parseInt(br.readLine());  // 배열의 크기
        int k = Integer.parseInt(br.readLine());  // k

        long lo = 1;
        long hi = k;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (k <= cnt) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }


        System.out.println(lo);
    }
}