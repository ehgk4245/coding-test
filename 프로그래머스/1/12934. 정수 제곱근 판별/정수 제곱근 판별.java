class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        if (num % 1 == 0.0) {
            return (long) Math.pow(num + 1, 2);
        }
        return -1;
    }
}