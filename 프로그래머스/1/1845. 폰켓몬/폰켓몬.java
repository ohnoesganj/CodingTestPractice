import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int size = set.size();

        if(size >= len) {
            answer = len;
        } else {
            answer = size;
        }
        
        return answer;
    }
}