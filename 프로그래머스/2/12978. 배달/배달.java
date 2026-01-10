import java.util.*;

class Solution {

    static class Node {
        int to;
        int cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<Node>> m = new HashMap<>();
        
        for (int[] edge : road) {
            if (m.containsKey(edge[0])) {
                m.get(edge[0]).add(new Node(edge[1], edge[2]));
            } else {
                List<Node> list = new ArrayList<>();
                list.add(new Node(edge[1], edge[2]));
                m.put(edge[0], list);
            }
            
            if (m.containsKey(edge[1])) {
                m.get(edge[1]).add(new Node(edge[0], edge[2]));
            } else {
                List<Node> list = new ArrayList<>();
                list.add(new Node(edge[0], edge[2]));
                m.put(edge[1], list);
            }
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 500001);
        dist[1] = 0;
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        q.add(new Node(1, 0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.cost != dist[cur.to]) {
                continue;
            }
            
            for (Node next : m.get(cur.to)) {
                int newCost = cur.cost + next.cost;
                
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    q.add(new Node(next.to, newCost));
                }
            }
        }
        
        int count = 0;
        for (int n : dist) {
            if (n <= K) count++;
        }
        
        return count;
    }
}