class Solution {
    boolean solution(String s) {
        String str = s.toUpperCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') count++;
            else if (str.charAt(i) == 'Y') count--;
        }
    
        return count == 0;
    }
}