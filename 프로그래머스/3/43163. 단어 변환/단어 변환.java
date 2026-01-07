import java.util.*;

class Solution {
    
    static class Word {
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        Queue<Word> q = new ArrayDeque<>();
        
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word word = q.poll();
            if (word.word.equals(target)) {
                return word.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visit[i]) {
                    if (isTransable(word.word, words[i])) {
                        visit[i] = true;
                        q.add(new Word(words[i], word.count + 1));
                    }
                }
            }
        }
        
        return 0;
    }
    
    boolean isTransable(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}