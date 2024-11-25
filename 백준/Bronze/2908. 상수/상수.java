import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int a_i = A / 100;
        int a_j = (A % 100) / 10;
        int a_k = (A % 100) % 10;

        int b_i = B / 100;
        int b_j = (B % 100) / 10;
        int b_k = (B % 100) % 10;

        int a = a_k * 100 + a_j * 10 + a_i;
        int b = b_k * 100 + b_j * 10 + b_i;

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}