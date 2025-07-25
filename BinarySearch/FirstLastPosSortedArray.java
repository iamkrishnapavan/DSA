/*
    It is solved using binary search
    MISTAKES
    ============
    Faced some difficulty in writing recursion.
    SIMILAR PROBLEM
    ================
    https://www.naukri.com/code360/problems/occurrence-of-x-in-a-sorted-array_630456?leftPanelTabValue=SUBMISSION
    (right - left + 1) for no of occurrences
 */
class Solution {
    public int lowerBoundUsingBSearch(int[] a, int l, int h, int x){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(a[mid] == x){
            int left =  lowerBoundUsingBSearch(a, l, mid - 1, x);
            return left != -1 ? left : mid;
        }
        else if(a[mid] < x) return lowerBoundUsingBSearch(a, mid + 1, h, x);
        else return lowerBoundUsingBSearch(a, l, mid - 1, x);
    }

    public int upperBoundUsingBSearch(int[] a, int l, int h, int x){
        if(l > h) return -1;
        int mid = l + (h - l)/2;
        if(a[mid] == x){
            int right = upperBoundUsingBSearch(a, mid + 1, h, x);
            return right != -1 ? right : mid;
        }
        else if(a[mid] < x) return upperBoundUsingBSearch(a, mid + 1, h, x);
        else return upperBoundUsingBSearch(a, l, mid - 1, x);
    }
    public int[] searchRange(int[] nums, int target) {
        int s = lowerBoundUsingBSearch(nums, 0, nums.length - 1, target);
        int e = upperBoundUsingBSearch(nums, 0, nums.length - 1, target);
        return new int[]{s, e};
    }
}