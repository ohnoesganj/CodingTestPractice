import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> st = new Stack<>();
        
        for (int i : arr) {
            if (st.empty() || !st.peek().equals(i)) {
                st.push(i);
            }
        }
        
        answer = new int[st.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = st.get(i);
        }

        return answer;
    }
}