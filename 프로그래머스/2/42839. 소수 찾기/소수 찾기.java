import java.util.HashSet;

class Solution {
    static boolean[] visited = new boolean[7];
    static HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        String[] arr = new String[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = String.valueOf(numbers.charAt(i));
        }
        
        dfs(numbers, 0, "");
        
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private static void dfs(String numbers, int depth, String now) {
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(now + numbers.charAt(i)));
                dfs(numbers, depth + 1, now + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}