/*
    TIME COMPLEXITY
    ===============
    O(N * log(max)), where max is maximum element in the given arr.

    Questions
   ==============
   -> Why maximum is taken as the max range to act as divisor?
   Ans) Because after the max element all greater elements than that will return same threshold, so it is unnecessary to include greater
        than max in range
        EX: [1, 2, 5, 9]
        if divisor = 9 then threshold = 4
        if divisor = 10 then threshold = 4
        if divisor = 100 then threshold = 4
 */

class SmallDivThreshold {
    public int bSearch(int[] a, int l, int h, int t){
        if(l > h) return -1;
        int mid = l +(h - l)/2;
        long res = findThreshold(a, mid);
        if(res <= t){
            int ans = bSearch(a, l, mid - 1, t);
            return ans == -1 ? mid : ans;
        } else return bSearch(a, mid + 1, h, t);
    }
    public long findThreshold(int[] a, int t){
        long s = 0;
        for(int i = 0; i < a.length; i++){
            s += a[i]/t;
            s += (a[i] % t == 0 ? 0 : 1);
        }
        return s;
    }
    public int getMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) max = Math.max(max, a[i]);
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max  = getMax(nums);
        return bSearch(nums, 1, max, threshold);
    }
}