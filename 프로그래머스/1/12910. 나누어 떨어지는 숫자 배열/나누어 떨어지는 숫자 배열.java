import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) list.add(n);
        }
        
        if (list.isEmpty()) {
            int[] a = {-1};
            return a;
        }
        
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}