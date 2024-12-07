import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] A, temp;
    static int result = -1;
    static int cnt = 0;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[N];
        merge_sort(A, 0, N - 1);

        System.out.println(result);
    }

    static void merge_sort(int[] arr, int p, int r) {
        if (cnt > M) return;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                temp[t] = A[i];
                i++;
            } else {
                temp[t] = A[j];
                j++;
            }
            t++;
        }

        while (i <= q) {
            temp[t++] = A[i++];
        }

        while (j <= r) {
            temp[t++] = A[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            cnt++;
            if (cnt == M) {
                result = temp[t];
                break;
            }
            A[i++] = temp[t++];
        }
    }
}