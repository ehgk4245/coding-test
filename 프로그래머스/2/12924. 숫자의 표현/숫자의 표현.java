class Solution {
    public int solution(int n) {
        int answer = 0;
        
        outer:
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    continue outer;
                } else if (sum > n) continue outer;
            }
        }
        
        return answer;
    }
}