/*
    TIME COMPLEXITY
    ================
    O(n log(maxBloomDay))
 */
class MinDaysToMBuckets {
    public int getMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) max = Math.max(max, a[i]);
        return max;
    }
    public int bSearch(int[] a, int l, int h, int m, int k){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        int boq = possNumBoqAtGivenDay(a, mid, k);
        if(boq >= m){
            int ans = bSearch(a, l, mid - 1, m, k);
            return ans == -1 ? mid : ans;
        }
        else return bSearch(a, mid + 1, h, m, k);
    }
    public int possNumBoqAtGivenDay(int[] a, int day, int k){
        int seq = 0, boq = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] <= day){
                seq += 1;
                if(seq % k == 0) boq += 1;
            } else seq = 0;
        }
        return boq;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max = getMax(bloomDay);
        return bSearch(bloomDay, 1, max, m, k);
    }
}