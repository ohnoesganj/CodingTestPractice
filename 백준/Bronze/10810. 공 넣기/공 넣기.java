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

        int N = Integer.parseInt(st.nextToken()); // 총 바구니의 개수
        int M = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수
        int[] cnt = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int j = I - 1; j < J; j++) {
                cnt[j] = K;
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
}