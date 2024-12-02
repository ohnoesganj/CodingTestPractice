import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int openCnt = 0;
        for (int i = 1; i * i <= N; i++) {
            openCnt++;
        }
        sb.append(openCnt).append("\n");

        System.out.println(sb);
    }
}