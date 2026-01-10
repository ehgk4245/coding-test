import java.util.*;

class Solution {
    public long solution(long n) {
        List<Long> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        list.sort((a, b) -> Long.compare(b, a));
        
        StringBuilder sb = new StringBuilder();
        
        for (Long num : list) {
            sb.append(String.valueOf(num));
        }
        
        return Long.parseLong(sb.toString());
    }
}