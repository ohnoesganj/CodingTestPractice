import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int a = (int) Math.pow(3, N);

            sb = new StringBuilder();
            for (int i = 0; i < a; i++) {
                sb.append("-");
            }

            cento(0, a);

            System.out.println(sb);
        }
    }

    private static void cento(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        // 3등분한 문자열의 두번째 부분 => 공백처리
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        cento(start, newSize);  // 3등분한 문자열의 첫번째 부분
        cento(start + 2 * newSize, newSize); // 3등분한 문자열의 세번째 부분
    }
}