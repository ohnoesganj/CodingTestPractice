import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";

        while (true) {
            str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}