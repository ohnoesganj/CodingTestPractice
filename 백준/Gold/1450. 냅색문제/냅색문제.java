import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N, C;
	static int[] arr;
	static ArrayList<Long> leftSums = new ArrayList<>();
	static ArrayList<Long> rightSums = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열을 반으로 나눔
		dfs(0, N / 2, 0, leftSums);
		dfs(N / 2, N, 0, rightSums);

		Collections.sort(rightSums); // 이분 탐색을 위해 정렬

		long count = 0;
		for (long left : leftSums) {
			long remain = C - left;
			count += upperBound(rightSums, remain); // C 이하인 값의 개수 합산
		}

		System.out.println(count);
	}

	// 부분합을 구하는 DFS
	static void dfs(int start, int end, long sum, ArrayList<Long> list) {
		if (sum > C)
			return;
		if (start == end) {
			list.add(sum);
			return;
		}
		dfs(start + 1, end, sum + arr[start], list); // 선택
		dfs(start + 1, end, sum, list);              // 선택 안 함
	}

	// upperBound: val 이하인 원소 개수 반환
	static int upperBound(ArrayList<Long> list, long val) {
		int low = 0, high = list.size();
		while (low < high) {
			int mid = (low + high) / 2;
			if (list.get(mid) <= val) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}