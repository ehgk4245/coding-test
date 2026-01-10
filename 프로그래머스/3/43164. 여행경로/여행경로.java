import java.util.*;

class Solution {
    List<String> answer = new ArrayList<>();
    Map<String, Queue<String>> graph = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
        
        for (String[] ticket : tickets) {
            if (graph.containsKey(ticket[0])) {
                graph.get(ticket[0]).add(ticket[1]);
            } else {
                Queue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                graph.put(ticket[0], q);
            }
        }
        search("ICN");
        
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }
    
    void search(String cur) {
        if (!graph.containsKey(cur)) {
            answer.add(cur);
            return;
        }
        
        Queue<String> q = graph.get(cur);
        while (!q.isEmpty()) {
            String next = q.poll();
            search(next);
        }
        answer.add(cur);
    }
}