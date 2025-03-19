import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashMap<Integer, Integer> indexCount = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (int i = 0; i < plays.length; i++) {
            indexCount.put(i, plays[i]);
        }
        
        ArrayList<String> genreSet = new ArrayList<>(genreCount.keySet());
        
        Collections.sort(genreSet, (o1, o2) ->
                        genreCount.get(o2).compareTo(genreCount.get(o1))
                        );
        
        List<Integer> indexList = new ArrayList<>(indexCount.keySet());

        Collections.sort(indexList, (o1, o2) ->
                        indexCount.get(o2).compareTo(indexCount.get(o1))
                        );
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String s : genreSet) {
            int count = 1;
            for (int i : indexList) {
                if (genres[i].equals(s) && count < 3) {
                    count++;
                    answerList.add(i);
                }
            }
        }
        
        answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
                    
        return answer;
    }
}