class Solution {
    
    private int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int num, int idx) {
        if (idx >= numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, num + numbers[idx], idx + 1);
        dfs(numbers, target, num - numbers[idx], idx + 1);
    }
}