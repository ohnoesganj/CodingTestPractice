import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 가장 인접한 두 공유기 사이의 거리를 최대
        int N = Integer.parseInt(st.nextToken());  // 집의 개수
        int C = Integer.parseInt(st.nextToken());  // 공유기의 개수

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);   // 이분탐색은 무조건 정렬

        int lo = 1;
        int hi = arr[N - 1] - arr[0] + 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int position = 0;
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if (cnt < C) {  // 설치된 공유기 수가 가지고 있는 공유기의 수보다 적으면
                hi = mid - 1;  // Upper Bound 내림 -> 최소 거리 줄임
                continue;
            }

            lo = mid + 1;
            // 설치된 공유기 수가 가지고 있는 공유기의 수보다 크다면 Lower Bound 올림 -> 최소 거리 늘림
        }

        System.out.println(lo - 1);
    }
}