import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int yh = yellow; yh > 0; yh--) {
            if (yellow % yh != 0) continue;
            int yw = yellow / yh;
            if ((yw + yh) * 2 + 4 == brown) {
                answer[0] = yw + 2;
                answer[1] = yh + 2;
            }
        }
        
        return answer;
    }
}