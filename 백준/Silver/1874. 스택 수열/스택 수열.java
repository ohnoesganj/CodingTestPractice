import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int n = sc.nextInt();
        int start = 0;

        while (n-- > 0) {
            int value = sc.nextInt();

            if (value > start) {
                for (int i = start + 1; i <= value; i++) {  // start + 1부터 입력받은 value 까지 push
                    st.push(i);
                    sb.append("+").append("\n");
                }
                start = value;  // 다음 push 할 때 오름차순을 유지하기 위한 변수 초기화
            } else if (st.peek() != value) {  // top 에 있는 원소가 입력받은 값과 다른 경우
                System.out.println("NO");
                return;
            }
            st.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}