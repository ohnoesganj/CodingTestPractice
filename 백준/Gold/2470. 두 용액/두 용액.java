import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

		sum(n);
	}

	private static void sum(int n) {
		int start = 0;
		int end = n - 1;
		int min = Integer.MAX_VALUE;
		int a = 0, b = 0;

		while (start < end) {
			int sum = arr[start] + arr[end];

			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[start];
				b = arr[end];
			}

			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(a + " " + b);
	}
}