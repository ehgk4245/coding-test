import java.util.*;

class Solution {
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Stack<Integer> st = new Stack<>();
                st.push(i);
                visit[i] = true;
                dfs(n, computers, st);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int n, int[][] graph, Stack<Integer> st) {
        while (!st.empty()) {
            int cn = st.pop();
            
            for (int i = 0; i < n; i++) {
                if (!visit[i] && graph[cn][i] == 1) {
                    st.push(i);
                    visit[i] = true;
                }
            }
        }
    }
}