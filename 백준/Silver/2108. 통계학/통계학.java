import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader vs Scanner : 속도 차원에서 br이 더 빠름
        // BufferedReader => 문자열을 한 줄로 읽음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        int[] arr = new int[N];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int mod = getMod(arr, N);

        // 1. 평균값
        System.out.println(Math.round((double) sum / N));

        // 2. 중앙값
        System.out.println(arr[(N-1)/2]);

        // 3. 최빈값
        System.out.println(mod);

        // 4. 범위
        System.out.println(arr[N-1] - arr[0]);
    }

    private static int getMod(int[] arr, int N) {
        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for (int i = 0; i < N - 1; i++) {
            
            if (arr[i] == arr[i + 1]) {
                count++;  // 같은 수가 있으면 count++
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check) {
                mod = arr[i];
                check = false;
            }
        }
        return mod;
    }
}