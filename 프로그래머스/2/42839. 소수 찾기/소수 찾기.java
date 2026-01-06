import java.util.*;

class Solution {
    boolean[] visit;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        visit = new boolean[numbers.length()];
        solve("", numbers);
        
        for (int n : set) {
            if (isPrime(n)) answer += 1;
        }
        
        return answer;
    }
    
    void solve(String number, String numbers) {
        if (!number.isEmpty()) {
            set.add(Integer.parseInt(number));
            if (number.length() == numbers.length()) {
                return;
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(number.concat(numbers.substring(i, i + 1)), numbers);
                visit[i] = false;
            }
        }
    }
    
    boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}