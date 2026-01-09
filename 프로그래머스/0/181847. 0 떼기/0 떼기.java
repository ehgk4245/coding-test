class Solution {
    public String solution(String n_str) {
        while (true) {
            if (n_str.charAt(0) != '0') {
                break;
            }
            n_str = n_str.substring(1);
        }
        
        return n_str;
    }
}