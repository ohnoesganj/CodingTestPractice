import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[9][9];
        int max = 0;
        int x = 1;
        int y = 1;

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (max < arr[i][j]) {
                    max = arr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}