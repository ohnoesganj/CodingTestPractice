import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        System.out.println(sum(n, x));
    }

    private static int sum(int n, int x) {
        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int temp = arr[start] + arr[end];
            if (temp > x) {
                end--;
            } else {
                if (temp == x) {
                    count++;
                }
                start++;
            }
        }

        return count;
    }
}