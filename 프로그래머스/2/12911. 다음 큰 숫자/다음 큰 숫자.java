class Solution {
    public int solution(int n) {
        int nCount = countOne(n);
        int a = n;
        while(true) {
            a += 1;
            if (nCount == countOne(a)) return a;
        }
    }
    
    public int countOne(int n) {
        int count = 0;
        while(n > 0) {
            if (n % 2 == 0) n /= 2;
            else {
                count++;
                n /= 2;
            }
        }
        return count;
    }
}