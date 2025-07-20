/*
    Here in this problem i used prefix and suffix product method, i.e at a particular elemnt i tracked the prefix and suffix product
    and update the max result.
    Edge case
    ==========
    I missed the edge what to do if element is 0, we have to do prefix/suffix production to 1.
    TIME COMPLEXITY : o(n)
    =======================
    SPACE COMPLEXITY : O(1)
    =======================

    SIMILAR QUESTIONS
    ==================
    Maximum sub array sum but we use kadanes algo because we will use only prefix sum.
 */


class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, prod1 = 1, prod2 = 1, n = nums.length;
        for(int i = 0; i < n; i++){
            prod1 *= nums[i];
            prod2 *= nums[n - i - 1];
            res = Math.max(prod1, Math.max(res, prod2));
            if(prod1 == 0) prod1 = 1;
            if(prod2 == 0) prod2 = 1;
        }
        return res;
    }
}