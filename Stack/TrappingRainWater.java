/*
    Prefix And Suffix method
    ========================
    Maintains left greater and right greater arrays for each element and we will add to sum if the present element is less than left
    and right greater elements then substract the current with least greater and add to sum.
    TIME COMPLEXITY : O(N)
    SPACE COMPLEXITY : O(2N)
    Two pointer method
    =====================
    TIME COMPLEXITY : O(N)
 */
class TrappingRainWater {
    public int prefixAndSuffixMethod(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        int max = -1, s = 0;
        for(int i = 0; i < height.length; i++){
            max = Math.max(max, height[i]);
            lmax[i] = max;
        }
        max = -1;
        for(int i = height.length - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            rmax[i] = max;
        }
        for(int i = 0; i < height.length; i++){
            if(height[i] < lmax[i] && height[i] < rmax[i]) s += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return s;
    }

    public int twoPointerMethod(int[] height) {
        int l = 0, r = height.length - 1, lmax = 0, rmax = 0, res = 0;
        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if(lmax < rmax){
                res += (lmax - height[l]);
                l++;
            } else{
                res += (rmax - height[r]);
                r--;
            }
        }
        return res;
    }
}