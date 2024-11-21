import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader vs Scanner : 속도 차원에서 br이 더 빠름
        // BufferedReader => 문자열을 한 줄로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());  // 카드의 개수 (N장 중 3장)
        int M = Integer.parseInt(st.nextToken());  // 숫자의 합 (넘지 않는 최대수)

        int[] a = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken()); // 문자 하나씩 끊기
        }

        int result = search(a, N, M);
        System.out.println(result);
    }

    static int search(int[] a, int N, int M) {
        int result = 0;

        for (int i = 0; i < N-2; i++) {

            if (a[i] > M) continue; // 첫번째 카드가 M보다 크면 패스

            for (int j = i + 1; j < N - 1; j++) {
                if (a[i] + a[j] > M) continue;

                for (int k = j + 1; k < N; k++) {
                    int sum = a[i] + a[j] + a[k];

                    if (M == sum) {
                        return sum;
                    }

                    // 세 카드의 합이 이전 합보다 크면서 M보다 작을 경우 (최대값 구하기)
                    if (result < sum && sum < M) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}