class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_row = 0;
        int max_col = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            if (max_row < sizes[i][0]) {
                max_row = sizes[i][0];
            }
            
            if (max_col < sizes[i][1]) {
                max_col = sizes[i][1];
            }
        }
        
        answer = max_row * max_col;
        return answer;
    }
}