import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static int arr[];
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        arr = new int[n + 1];
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        answer = bfs(1, n);
        
        
        return answer;
    }
    
    private int bfs(int start, int n) {
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int a=  q.poll();
            
            for(int b : graph[a]) {
                if(visited[b]) {
                    continue;
                }
                q.add(b);
                visited[b] = true;
                arr[b] = arr[a] + 1;
            }
        }
        
        Arrays.sort(arr);
        int cnt = 0;
        int max = arr[n];
        
        for(int i = n; i >= 1; i--) {
            if(max == arr[i]) {
                cnt++;
            }
            else {
                break;
            }
        }
        
        return cnt;
    }
}