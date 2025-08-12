/*
    Below code takes TIME COMPLEXITY -> O(2 ^ N)
    But using Dynamic programming we can reduce time complexity
 */
import java.util.*;
import java.io.*;

public class Solution {
    public static int compute(int[] nums, int x, int sum, int ind){
        if(sum == x) return 1;
        if(sum > x || ind >= nums.length) return 0;

        int res = 0;
        res += compute(nums, x, sum, ind + 1);
        res += compute(nums, x, sum + nums[ind], ind + 1);
        return res;
    }
    public static int findWays(int nums[], int target) {
        return compute(nums, target, 0, 0);
    }
}