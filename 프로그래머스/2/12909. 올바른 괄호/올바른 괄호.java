import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        char[] cArr = s.toCharArray();
        
        for (char c : cArr) {
            if (c == '(') {
                st.add(c);
            } else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        
        return st.isEmpty();
    }
}