import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(factorial(N));

        System.out.println(sb);
    }

    static long factorial(int n) {
        if (n <= 0) {
            return 1;
        }

        return n * factorial(n-1);
    }
}