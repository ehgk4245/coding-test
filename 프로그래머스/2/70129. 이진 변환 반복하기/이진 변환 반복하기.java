class Solution {
    int count;
    int zCount;
    
    public int[] solution(String s) {
        recursive(s);
        int[] arr = {count, zCount};
        return arr;
    }
    
    void recursive(String s) {
        if (s.equals("1")) {
            return;
        }
        String s2 = s.replaceAll("0", "");
        count++;
        zCount += s.length() - s2.length();
        
        recursive(trans(s2.length()));
    }
    
    String trans(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            if (n == 1) {
                sb.insert(0, "1");
                break;
            }
            int num = n % 2;
            sb.insert(0, String.valueOf(num));
            n /= 2;
        }
        return sb.toString();
    }
}