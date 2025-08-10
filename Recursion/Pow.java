class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            return ((1 / x) * myPow(x, n + 1));
        }
        boolean neg = n < 0;
        n = n < 0 ? n * -1 : n;
        double ans = 1, val = x;
        while(n > 0){
            if(n % 2 == 0){
                x = x * x;
                n /= 2;
            } else {
                ans *= x;
                n--;
            }
        }
        if(neg) return 1/ans;
        return ans;
    }
}