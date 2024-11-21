import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
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

            if (cnt < N) {  // 자른 랜선의 개수가 만들고자 하는 랜선의 개수보다 작은 경우 -> 최대 길이 줄임
                max = mid;
            } else {  // 큰 경우 -> 최소 길이 늘림
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}