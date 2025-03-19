import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1;  // 2
            int b = commands[i][1] - 1;  // 5
            int c = commands[i][2] - 1;  // 3
            
            int[] arr = new int[b - a + 1];
            
            for (int j = a; j <= b; j++) {
                arr[j - a] = array[j];
            }
            
            Arrays.sort(arr);
            
            answer[i] = arr[c];
        }
        
        return answer;
    }
}