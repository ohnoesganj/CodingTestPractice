import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static boolean[] visited;
    ArrayList<String> allPath;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        allPath = new ArrayList<>();
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(allPath);
        answer = allPath.get(0).split(" ");
        
        return answer;
    }
    
    private void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) {
            allPath.add(path);
            return;
        }
        
        
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " +tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}