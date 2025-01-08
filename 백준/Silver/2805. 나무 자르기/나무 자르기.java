import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int height: arr) {
                /* 나무의 잘린 길이 = height - mid
                   자르는 위치가 나무의 높이보다 클 수 있기 때문에 양수만 if 문으로 거르기
                */
                if (height - mid > 0) {
                    sum += (height - mid);
                }
            }

            if (sum < M) {   // 자른 나무의 길이가 M보다 작을 때 -> max 를 낮춰야 함
                max = mid;
            } else {  // 자른 나무의 길이가 M보다 클 때 -> min 를 높여야 함
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}