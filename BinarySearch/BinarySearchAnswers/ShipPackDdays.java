/*
    Here we used max(weights) as lower bound and sum of weights as upper bound, because
    Ex : [1,2,3,1,1]
    if we take small than element 3 then it 3 is never ship because it is bigger than selected capacity, so we need to try with large
    weight so it is also shipped.
    Sum(Weights) as upper bound
    ===============================
    Every number greater than sum of weights is take only one day.
    TIME COMPLEXITY
    ===================
    O(n * log(sum(weights) - max(weights))
    MISTAKES
    =========
    I selected incorrect lower bound as 1
    Incorrect logic in findDays().
 */
class Solution {
    public int getSum(int[] a){
        int s = 0;
        for(int i = 0; i < a.length; i++) s += a[i];
        return s;
    }
    public int getMax(int[] a){
        int max = 0;
        for(int i = 0; i < a.length; i++) max = Math.max(a[i], max);
        return max;
    }
    public int bSearch(int[] a, int l, int h, int d){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        long days = findDays(a, mid);
        if(days <= d){
            int ans = bSearch(a, l, mid - 1, d);
            return ans == -1 ? mid : ans;
        } else return bSearch(a, mid + 1, h, d);
    }
    public long findDays(int[] a, int weight){
        int days = 1, totWeight = 0;
        for(int i = 0; i < a.length; i++){
            if(totWeight + a[i] > weight){
                days += 1;
                totWeight = a[i];
            } else{
                totWeight += a[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = getSum(weights);
        int max = getMax(weights);
        return bSearch(weights, max, sum, days);
    }
}