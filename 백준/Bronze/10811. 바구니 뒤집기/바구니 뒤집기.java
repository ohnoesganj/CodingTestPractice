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

        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int temp = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int I = Integer.parseInt(st.nextToken()) - 1;
            int J = Integer.parseInt(st.nextToken()) - 1;

            while (I < J) {
                temp = arr[I];
                arr[I] = arr[J];
                arr[J] = temp;
                I++;
                J--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}