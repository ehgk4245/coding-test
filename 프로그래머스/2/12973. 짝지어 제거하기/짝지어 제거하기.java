import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> st = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.add(c);
            } else if ((char) st.peekLast() == c) {
                st.removeLast();
            } else {
                st.add(c);
            }
        }
        
        if (st.isEmpty()) {
            return 1;
        }
        return 0;
    }
}