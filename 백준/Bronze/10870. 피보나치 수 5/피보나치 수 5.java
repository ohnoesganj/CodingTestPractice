import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(fibonacci(N));

        System.out.println(sb);
    }

    static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}