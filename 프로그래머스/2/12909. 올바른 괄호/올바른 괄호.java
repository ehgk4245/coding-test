import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) return false;
            c = st.pop();
        }
        if (st.isEmpty()) return true;
        return false;
    }
}