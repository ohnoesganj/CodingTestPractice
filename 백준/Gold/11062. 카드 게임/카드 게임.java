import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[2][N + 1][N + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N + 1; j++) {
					for (int k = 0; k < N + 1; k++) {
						dp[i][j][k] = -1;
					}
				}
			}

			sb.append(solve(0, 1, N)).append("\n");
		}

		System.out.println(sb);
	}

	private static int solve(int p, int start, int end) {
		if (dp[p][start][end] != -1) {
			return dp[p][start][end];
		}

		if (start >= end) {
			if (p == 0) { // 근우
				return arr[start];
			} else {  // 명우
				return 0;
			}
		}

		dp[p][start][end] = 0;
		if (p == 0) {
			dp[p][start][end] = Math.max(solve(p + 1, start + 1, end) + arr[start],
				solve(p + 1, start, end - 1) + arr[end]);
		} else {
			dp[p][start][end] = Math.min(solve(p - 1, start + 1, end),
				solve(p - 1, start, end - 1));
		}

		return dp[p][start][end];
	}
}