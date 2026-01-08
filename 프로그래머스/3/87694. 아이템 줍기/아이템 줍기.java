import java.util.*;

class Solution {
    
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
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visit = new boolean[101][101];
        
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(characterX * 2, characterY * 2, 0));
        visit[characterY * 2][characterX * 2] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            Position p = q.poll();
            if (p.x == itemX * 2 && p.y == itemY * 2) {
                return p.count / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (isMovable(nx, ny, rectangle) && !visit[ny][nx]) {
                    q.add(new Position(nx, ny, p.count + 1));
                    visit[ny][nx] = true;
                }
            }
        }
        return 0;
    }
    
    boolean isMovable(int x, int y, int[][] rectangle) {
        boolean isMovable = false;
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int x2 = rec[2] * 2;
            int y1 = rec[1] * 2;
            int y2 = rec[3] * 2;
            
            if (x < x1 || x > x2 || y < y1 || y > y2) continue;
            if (x1 < x && x < x2 && y1 < y && y < y2) return false;
            if (x == x1 || x == x2 || y == y1 || y == y2) {
                isMovable = true;
            }
        }
        return isMovable;
    }
}