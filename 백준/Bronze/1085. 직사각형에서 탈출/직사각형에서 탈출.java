import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int width_min = w;
        int height_min = h;

        if (w - x < x) {
            width_min = w - x;
        } else {
            width_min = x;
        }

        if (h - y < y) {
            height_min = h - y;
        } else {
            height_min = y;
        }

        System.out.println(Math.min(width_min, height_min));
    }
}