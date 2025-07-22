/*
    We will find lower bound for an element x in an sorted array using binary search.
    Lower bound of x ===> y >= x
    Since we want least index we will divide the array even element is equal

    Key Points
    ============
    If all elements in array are greater than given x then l = 0 and h = -1, because we go left part with search(l, mid - 1) only h is
    updating.
    If all elements in array are smaller than given x tehn l = n and h = n - 1, because we gor right part search(mid + 1, h) only l is
    updating.
 */
public class LowerBound {
    public int lowerBoundUsingBSearch(int[] a, int l, int h, int x){
        if(l > h) return l;
        int mid = l + (h - l)/2;
        if(a[mid] >= x) return lowerBoundUsingBSearch(a, l, mid - 1, x);
        else return lowerBoundUsingBSearch(a, mid + 1, h, x);
    }
}
/*
    Upper bound of x ===> y > x
 */
public class UpperBound {
    public int upperBoundUsingBSearch(int[] a, int l, int h, int x){
        if(l > h) return l;
        int mid = l + (h - l)/2;
        if(a[mid] <= x) return upperBoundUsingBSearch(a, mid + 1, h, x);
        else return upperBoundUsingBSearch(a, l, mid - 1, x);
    }
}

/*
    Same as lower bound
    We can simply use condition if(a[mid] >= x) rqather than independent conditions.
    https://leetcode.com/problems/search-insert-position/
 */
class Solution {
    public int findPosUsingBsearch(int[] a, int l, int h, int x){
        if(l > h) return l;
        int mid = l + (h - l)/2;
        if(a[mid] == x) return mid;
        else if(a[mid] < x) return findPosUsingBsearch(a, mid + 1, h, x);
        else return findPosUsingBsearch(a, l, mid - 1, x);
    }
    public int searchInsert(int[] nums, int target) {
        return findPosUsingBsearch(nums, 0, nums.length - 1, target);
    }
}