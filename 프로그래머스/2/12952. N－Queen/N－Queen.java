class Solution {
    boolean[] colb;
    boolean[] cross1;
    boolean[] cross2;
    int count;
    
    public int solution(int n) {
        colb = new boolean[n];
        cross1 = new boolean[2 * n];
        cross2 = new boolean[2 * n];
        
        search(0, n);
        return count;
    }
    
    void search(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (colb[col] || cross1[row - col + n] || cross2[row + col]) {
                continue;
            }
            
            colb[col] = true;
            cross1[row - col + n] = true;
            cross2[row + col] = true;
            
            search(row + 1, n);
            
            colb[col] = false;
            cross1[row - col + n] = false;
            cross2[row + col] = false;
        }
    }
}