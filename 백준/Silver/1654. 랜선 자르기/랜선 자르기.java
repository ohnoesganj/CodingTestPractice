import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader vs Scanner : 속도 차원에서 br이 더 빠름
        // BufferedReader => 문자열을 한 줄로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer => 공백을 기준으로 문자열 분리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {   // 랜선 최대 길이 저장
                max = arr[i];
            }
        }

        max++;

        long min = 0; // 탐색 길이 최솟값
        long mid = 0;

        while (min < max) {

            mid = (min + max) / 2;

            long cnt = 0;

            for (int j : arr) {  // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지
                cnt += (j / mid);
            }

            // Upper Bound 형식
            if (cnt < N) {  // 자른 랜선의 개수가 만들고자 하는 랜선의 개수보다 작은 경우 -> 최대 길이 줄임
                max = mid;
            } else {  // 큰 경우 -> 최소 길이 늘림
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}