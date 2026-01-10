class Solution {
    public long solution(int a, int b) {
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        
        return end * (end + 1) / 2 - (start - 1) * start / 2;
    }
}