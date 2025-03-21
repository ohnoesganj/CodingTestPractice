import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            graph[wire[0]].remove(new Integer(wire[1]));
            graph[wire[1]].remove(new Integer(wire[0]));
            
            int cnt = bfs(wire[0], graph, n);
            
            answer = Math.min(answer, Math.abs(2 * cnt - n));
            
            if (answer == 0) break;
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
    
    private static int bfs(int start, LinkedList<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        
        return cnt;
    }
}