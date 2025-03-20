import java.util.ArrayList;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list;
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        
        dfs(0, "");
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int depth, String word) {
        list.add(word);
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(depth + 1, word + words[i]);
        }
    }
}