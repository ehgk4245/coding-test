import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    static class Position {
        int x;
        int y;
        int count;
        
        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int xLength = maps[0].length;
        int yLength = maps.length;
        
        boolean[][] visit = new boolean[yLength][xLength];
        
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(0, 0, 1));
        visit[0][0] = true;
        
        return bfs(q, maps, visit);
    }
    
    int bfs(Queue<Position> q, int[][] maps, boolean[][] visit) {
        while (!q.isEmpty()) {
            Position cp = q.poll();
            
            if (cp.x == maps[0].length - 1 && cp.y == maps.length - 1) {
                return cp.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                
                if (nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length) {
                    continue;
                }
                
                if (maps[ny][nx] == 1 && !visit[ny][nx]) {
                    q.add(new Position(nx, ny, cp.count + 1));
                    visit[ny][nx] = true;
                }
            }
        }
        return -1;
    }
}