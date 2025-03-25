import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<int[]> points = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long denominator = a * d - b * c;
                
                if(denominator == 0) continue;
                
                long xNumerator = b * f - e * d;
                long yNumerator = e * c - a * f;
                
                if(xNumerator % denominator != 0 || yNumerator % denominator != 0) continue;
                
                int x = (int) (xNumerator / denominator);
                int y = (int) (yNumerator / denominator);

                points.add(new int[]{x, y});
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }
        
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] grid = new char[height][width];
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        
        for (int[] p : points) {            
            int gridX = (int) (p[0] - minX);
            int gridY = (int) (maxY - p[1]);
            grid[gridY][gridX] = '*';
        }
        
        answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }
}