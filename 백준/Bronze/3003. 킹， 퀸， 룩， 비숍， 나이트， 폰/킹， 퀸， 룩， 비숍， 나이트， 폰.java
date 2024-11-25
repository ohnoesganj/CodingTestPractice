import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[6];

        int[] chess = new int[6];

        for (int i = 0; i < chess.length; i++) {
            chess[0] = 1;
            chess[1] = 1;
            chess[2] = 2;
            chess[3] = 2;
            chess[4] = 2;
            chess[5] = 8;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] != chess[i]) {
                if (arr[i] > chess[i]) {
                    sb.append("-").append(arr[i] - chess[i]).append(" ");
                } else {
                    sb.append(chess[i] - arr[i]).append(" ");
                }
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}