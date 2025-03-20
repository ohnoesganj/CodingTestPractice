class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(0, begin, target, words);
        
        return answer;
    }
    
    private void dfs(int depth, String begin, String target, String[] words) {
        if (begin.equals(target))  {
            answer = depth;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) 
                continue;
            
            int cnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }
            
            if (cnt == begin.length() - 1) {
                visited[i] = true;
                dfs(depth + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }
}