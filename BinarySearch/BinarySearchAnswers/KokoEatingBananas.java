/*
    TIME COMPLEXITY
    ================
    O(n * log m) where m is largest element in array(piles)

    MISTAKES
    =========
    Didnt handled overflow case when two large integers addded.
 */
class KokoEatingBananas {
    public int findMax(int[] a){
        int s = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) s = Math.max(s,a[i]);
        return s;
    }
    public int bSearch(int[] a, int l, int h, int hrs){
        if(l > h) return -1;

        int mid = l +(h - l)/2;
        long totHrs = findHrs(a, mid);
        if(totHrs <= hrs){
            int ans = bSearch(a, l, mid - 1, hrs);
            return ans != -1 ? ans : mid;
        }
        else return bSearch(a, mid + 1, h, hrs);
    }
    public long findHrs(int[] piles, int avg){
        long totHrs = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] <= avg) totHrs += 1;
            else{
                totHrs += (piles[i]/avg);
                totHrs += (piles[i]%avg == 0 ? 0 : 1);
            }
        }
        return totHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles), totHrs = Integer.MAX_VALUE;
        return bSearch(piles, 1, max, h);
    }
}



/*
    The below code is brute force solution
 */
class Solution {
    public long totSum(int[] a){
        long s = 0;
        for(int i = 0; i < a.length; i++) s += a[i];
        return s;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int avg = totSum(piles) / h, totHrs = Integer.MAX_VALUE;
        while(totHrs > h){
            totHrs = 0;
            for(int i = 0; i < piles.length; i++){
                if(piles[i] <= avg) totHrs += 1;
                else{
                    totHrs += (piles[i]/avg);
                    totHrs += (piles[i]%avg == 0 ? 0 : 1);
                }
            }
            avg++;
        }
        return avg - 1;
    }
}