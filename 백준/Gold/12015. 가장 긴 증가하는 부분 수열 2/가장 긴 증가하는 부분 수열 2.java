import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 가장 긴 증가하는 부분 수열의 길이 출력
        int N = Integer.parseInt(br.readLine());  // 배열의 크기
        int[] arr = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = arr[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (result[len - 1] < key) {
                len++;
                result[len - 1] = key;
            } else {
                int lo = 0;
                int hi = len;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (result[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                result[lo] = key;
            }
        }

        System.out.println(len);
    }
}