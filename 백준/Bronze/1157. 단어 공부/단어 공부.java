import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s_upper = s.toUpperCase();

        int[] arr = new int[26];

        for (int i = 0; i < s_upper.length(); i++) {
            int num = s_upper.charAt(i) - 'A';
            arr[num]++;
        }

        int max = 0;
        char result = '?';

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                result = (char) (i + 'A');
            } else if (max == arr[i]) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}