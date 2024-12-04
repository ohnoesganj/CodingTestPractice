import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int now = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == now) {
                now++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == now) {
                        stack.pop();
                        now++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(arr[i]);
            }
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}