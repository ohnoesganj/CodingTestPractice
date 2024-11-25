import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            if (str.length() > 1) {
                sb.append(str.charAt(0)).append(str.substring(str.length()-1)).append("\n");
            } else {
                sb.append(str).append(str).append("\n");
            }
        }
        System.out.println(sb);
    }
}