import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArr = new int[N];

        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr); 

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (binarySearch(nArr, sc.nextInt()) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    // 이진 탐색
    static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (key < arr[mid]) {  // key가 중간보다 작을 경우
                right = mid - 1;
            } else if (key > arr[mid]) {  // key가 중간보다 클 경우
                left = mid + 1;
            } else {  // key와 중간이 같을 경우
                return mid;
            }
        }
        return -1;
    }
}